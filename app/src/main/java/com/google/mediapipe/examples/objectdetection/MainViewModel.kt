package com.google.mediapipe.examples.objectdetection

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.eclipse.paho.client.mqttv3.*
import org.json.JSONObject

class MainViewModel : ViewModel() {

    // 🔹 Object Detection Einstellungen
    private var _delegate: Int = ObjectDetectorHelper.DELEGATE_CPU
    private var _threshold: Float = ObjectDetectorHelper.THRESHOLD_DEFAULT
    private var _maxResults: Int = ObjectDetectorHelper.MAX_RESULTS_DEFAULT
    private var _model: Int = ObjectDetectorHelper.MODEL_TANKS

    val currentDelegate: Int get() = _delegate
    val currentThreshold: Float get() = _threshold
    val currentMaxResults: Int get() = _maxResults
    val currentModel: Int get() = _model

    fun setDelegate(delegate: Int) { _delegate = delegate }
    fun setThreshold(threshold: Float) { _threshold = threshold }
    fun setMaxResults(maxResults: Int) { _maxResults = maxResults }
    fun setModel(model: Int) { _model = model }

    // 🔹 MQTT LiveData für Nachrichten
    private val _mqttMessages = MutableLiveData<List<String>>(emptyList())
    val mqttMessages: LiveData<List<String>> get() = _mqttMessages

    // 🔹 LiveData für Tanks (Overlay)
    private val _tankTemperatures = MutableLiveData<Map<String, Float>>(emptyMap())
    val tankTemperatures: LiveData<Map<String, Float>> get() = _tankTemperatures

    // 🔹 LiveData für alle Werte (inkl. Ventile)
    private val _allValues = MutableLiveData<Map<String, Float>>(emptyMap())
    val allValues: LiveData<Map<String, Float>> get() = _allValues

    // 🔹 MQTT Client
    private var mqttClient: MqttClient? = null
    private val brokerUri = "tcp://192.168.1.12:1883"   // deine Broker-IP
    private val topic = "mein/test/topic"

    private var connected = false

    init {
        startMqtt()   // ✅ MQTT automatisch starten, egal welcher Tab zuerst
    }

    fun startMqtt() {
        if (connected) return

        viewModelScope.launch(Dispatchers.IO) {
            try {
                mqttClient = MqttClient(brokerUri, MqttClient.generateClientId(), null)

                val options = MqttConnectOptions().apply {
                    isCleanSession = false
                    keepAliveInterval = 60
                }

                mqttClient!!.setCallback(object : MqttCallback {
                    override fun connectionLost(cause: Throwable?) {
                        addMessage("⚠️ Verbindung verloren")
                        connected = false
                    }

                    override fun messageArrived(topic: String?, message: MqttMessage?) {
                        val raw = message?.toString() ?: return
                        addMessage("📩 $raw")

                        try {
                            // 🔹 Parsing aller Werte aus der Nachricht
                            val parsed = mutableMapOf<String, Float>()
                            val tankMap = mutableMapOf<String, Float>()
                            val obj = JSONObject(raw)

                            obj.keys().forEach { key ->
                                val value = obj.getDouble(key).toFloat()
                                parsed[key] = value

                                // ✅ Tanks ins Overlay
                                if (key == "tank_1" || key == "tank_2" || key == "tank_3") {
                                    tankMap[key] = value
                                }
                            }

                            // 🔹 LiveData aktualisieren
                            _allValues.postValue(parsed)         // alle Werte inkl. Ventile
                            _tankTemperatures.postValue(tankMap) // nur Tanks fürs Overlay

                            Log.d("MQTT", "Parsed tanks: $tankMap")
                            Log.d("MQTT", "Parsed all: $parsed")

                        } catch (e: Exception) {
                            Log.e("MQTT", "JSON parse error", e)
                        }
                    }

                    override fun deliveryComplete(token: IMqttDeliveryToken?) {}
                })

                mqttClient!!.connect(options)
                mqttClient!!.subscribe(topic, 1)

                connected = true
                addMessage("✅ Verbunden mit Broker\n📡 Subscribed to $topic")

            } catch (e: Exception) {
                addMessage("❌ Fehler: ${e.message}")
            }
        }
    }

    private fun addMessage(msg: String) {
        val list = _mqttMessages.value?.toMutableList() ?: mutableListOf()
        list.add(msg)
        _mqttMessages.postValue(list)
    }

    override fun onCleared() {
        super.onCleared()
        try {
            mqttClient?.disconnect()
        } catch (_: Exception) {}
    }
}
