package com.google.mediapipe.examples.objectdetection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.mediapipe.examples.objectdetection.databinding.FragmentMqttBinding
import org.eclipse.paho.client.mqttv3.*

class MQTTFragment : Fragment() {

    private var _binding: FragmentMqttBinding? = null
    private val binding get() = _binding!!

    private lateinit var mqttClient: MqttClient
    private val brokerUri = "tcp://broker.hivemq.com:1883"
    private val topic = "mein/test/topic"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMqttBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonConnect.setOnClickListener { connectAndSubscribe() }
    }

    private fun connectAndSubscribe() {
        try {
            mqttClient = MqttClient(brokerUri, MqttClient.generateClientId(), null)

            val options = MqttConnectOptions().apply {
                isCleanSession = true
            }

            mqttClient.setCallback(object : MqttCallback {
                override fun connectionLost(cause: Throwable?) {
                    activity?.runOnUiThread {
                        binding.textMessages.append("\n⚠️ Verbindung verloren")
                    }
                }

                override fun messageArrived(topic: String?, message: MqttMessage?) {
                    activity?.runOnUiThread {
                        binding.textMessages.append("\n📩 ${message.toString()}")
                    }
                }

                override fun deliveryComplete(token: IMqttDeliveryToken?) {}
            })

            mqttClient.connect(options)
            binding.textMessages.text = "✅ Verbunden mit HiveMQ Broker"
            mqttClient.subscribe(topic)

            binding.textMessages.append("\nSubscribed to $topic")
        } catch (e: Exception) {
            binding.textMessages.text = "❌ Fehler: ${e.message}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (::mqttClient.isInitialized && mqttClient.isConnected) {
            mqttClient.disconnect()
        }
        _binding = null
    }
}
