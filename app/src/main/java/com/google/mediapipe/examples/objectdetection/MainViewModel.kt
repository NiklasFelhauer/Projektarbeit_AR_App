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

    // Object Detection Settings
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

    // MQTT Messages
    private val _mqttMessages = MutableLiveData<List<String>>(emptyList())
    val mqttMessages: LiveData<List<String>> get() = _mqttMessages

    // Tanks for Overlay
    private val _tankTemperatures = MutableLiveData<Map<String, Float>>(emptyMap())
    val tankTemperatures: LiveData<Map<String, Float>> get() = _tankTemperatures

    // All values (incl. valves)
    private val _allValues = MutableLiveData<Map<String, Float>>(emptyMap())
    val allValues: LiveData<Map<String, Float>> get() = _allValues

    // MQTT Client
    private var mqttClient: MqttClient? = null
    private val brokerUri = "tcp://192.168.1.12:1883"
    private val topic = "mein/test/topic"

    private val _mqttConnected = MutableLiveData<Boolean>(false)
    val mqttConnected: LiveData<Boolean> get() = _mqttConnected


    init {
        startMqtt()
    }

    fun startMqtt() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // 🔹 Alte Verbindung schließen, wenn vorhanden
                try {
                    mqttClient?.disconnect()
                } catch (_: Exception) {}

                _mqttConnected.postValue(false)


                mqttClient = MqttClient(brokerUri, MqttClient.generateClientId(), null)

                val options = MqttConnectOptions().apply {
                    isCleanSession = false
                    keepAliveInterval = 60
                }

                mqttClient!!.setCallback(object : MqttCallback {
                    override fun connectionLost(cause: Throwable?) {
                        addMessage("⚠️ Verbindung verloren")
                        _mqttConnected.postValue(false)

                    }

                    override fun messageArrived(topic: String?, message: MqttMessage?) {
                        val raw = message?.toString() ?: return
                        Log.d("MQTT", "Raw message: $raw")
                        addMessage("📩 $raw")

                        try {
                            val parsed = mutableMapOf<String, Float>()
                            val tankMap = mutableMapOf<String, Float>()

                            val obj = JSONObject(raw)
                            obj.keys().forEach { key ->
                                val value = obj.getDouble(key).toFloat()
                                parsed[key] = value

                                if (key == "tank_1" || key == "tank_2" || key == "tank_3") {
                                    tankMap[key] = value
                                }
                            }

                            _allValues.postValue(parsed)
                            _tankTemperatures.postValue(tankMap)

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

                _mqttConnected.postValue(true)

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
