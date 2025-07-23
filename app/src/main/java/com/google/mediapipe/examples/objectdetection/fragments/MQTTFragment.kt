package com.google.mediapipe.examples.objectdetection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.mediapipe.examples.objectdetection.databinding.FragmentMqttBinding

class MQTTFragment : Fragment() {

    private var _binding: FragmentMqttBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMqttBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Beispiel: Button-Klick, um Verbindung zu MQTT aufzubauen
        binding.buttonConnect.setOnClickListener {
            // Hier deine MQTT-Initialisierung
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
