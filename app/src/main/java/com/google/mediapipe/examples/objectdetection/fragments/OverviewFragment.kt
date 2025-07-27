package com.google.mediapipe.examples.objectdetection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.mediapipe.examples.objectdetection.MainViewModel
import com.google.mediapipe.examples.objectdetection.databinding.FragmentOverviewBinding
import com.google.mediapipe.examples.objectdetection.R

class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tanks und Ventile aus dem ViewModel beobachten
        viewModel.allValues.observe(viewLifecycleOwner) { values ->
            // 🔹 Tanks anzeigen
            binding.tempBoil.text = "${values["tank_1"] ?: "--"} °C"
            binding.tempMlt.text = "${values["tank_2"] ?: "--"} °C"
            binding.tempHlt.text = "${values["tank_3"] ?: "--"} °C"

            // 🔹 Beispiel für Ventil A
            val ventilAState = values["ventil_A"] ?: 0f
            if (ventilAState > 0f) {
                binding.ventilA.setImageResource(R.drawable.valve_open)   // dein Bild für geöffnet
            } else {
                binding.ventilA.setImageResource(R.drawable.valve_closed) // dein Bild für geschlossen
            }

            // 🔹 Beispiel für eine Pumpe
            val pumpState = values["pumpe"] ?: 0f
            if (pumpState > 0f) {
                binding.pump.setImageResource(R.drawable.pump_on)
            } else {
                binding.pump.setImageResource(R.drawable.pump_off)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
