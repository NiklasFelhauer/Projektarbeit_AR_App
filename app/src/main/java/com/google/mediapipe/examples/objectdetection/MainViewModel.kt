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

    init {
        Log.d("MQTT", "MQTT Verbindung im MainViewModel aufbauen")
        startMqtt()
        Log.d("MQTT", "MQTT Verbindung im MainViewModel aufgebaut")
    }

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

    // 🔹 MQTT LiveData
    private val _mqttMessages = MutableLiveData<List<String>>(emptyList())
    val mqttMessages: LiveData<List<String>> get() = _mqttMessages

    private val _tankTemperatures = MutableLiveData<Map<String, Float>>()
    val tankTemperatures: LiveData<Map<String, Float>> get() = _tankTemperatures

    // 🔹 MQTT Client
    private var mqttClient: MqttClient? = null
    private val brokerUri = "tcp://192.168.1.12:1883"   // deine Broker-IP
    private val topic = "mein/test/topic"

    private var connected = false

    fun startMqtt() {
        if (connected) return  // ✅ nur einmal verbinden

        viewModelScope.launch(Dispatchers.IO) {
            try {
                mqttClient = MqttClient(brokerUri, MqttClient.generateClientId(), null)

                val options = MqttConnectOptions().apply {
                    isCleanSession = false        // Session behalten
                    keepAliveInterval = 60
                }

                mqttClient!!.setCallback(object : MqttCallback {
                    override fun connectionLost(cause: Throwable?) {
                        addMessage("⚠️ Verbindung verloren")
                        connected = false
                    }

                    override fun messageArrived(topic: String?, message: MqttMessage?) {
                        val raw = message?.toString() ?: return
                        Log.d("MQTT", "Raw message: $raw")

                        addMessage("📩 $raw") // zum MQTT Tab
                        
                        try {
                            var cleaned = raw.trim()

                            // 🔹 Äußere Quotes entfernen
                            if ((cleaned.startsWith("\"") && cleaned.endsWith("\"")) ||
                                (cleaned.startsWith("'") && cleaned.endsWith("'"))) {
                                cleaned = cleaned.substring(1, cleaned.length - 1)
                            }

                            // 🔹 Escapes von \" entfernen
                            cleaned = cleaned.replace("\\\"", "\"")

                            val parsed = mutableMapOf<String, Float>()
                            val obj = JSONObject(cleaned)
                            obj.keys().forEach { key ->
                                parsed[key] = obj.getDouble(key).toFloat()
                            }
                            Log.d("MQTT", "Parsed temperatures: $parsed")
                            _tankTemperatures.postValue(parsed)

                        } catch (e: Exception) {
                            Log.e("MQTT", "JSON parse error", e)
                        }
                    }




                    override fun deliveryComplete(token: IMqttDeliveryToken?) {}
                })

                mqttClient!!.connect(options)
                mqttClient!!.subscribe(topic, 1)  // QoS 1

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
