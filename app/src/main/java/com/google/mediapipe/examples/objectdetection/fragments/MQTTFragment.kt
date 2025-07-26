package com.google.mediapipe.examples.objectdetection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.mediapipe.examples.objectdetection.MainViewModel
import com.google.mediapipe.examples.objectdetection.databinding.FragmentMqttBinding
import org.eclipse.paho.client.mqttv3.*
import org.json.JSONObject

class MQTTFragment : Fragment() {

    private var _binding: FragmentMqttBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMqttBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // MQTT-Verbindung starten (nur einmal)
        viewModel.startMqtt()

        // Nachrichten-Log anzeigen
        viewModel.mqttMessages.observe(viewLifecycleOwner) { list ->
            binding.textMessages.text = list.joinToString("\n")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}