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

            // 🔹 Beispiel für Ventil 1
            val ventil1State = values["ventil_1"] ?: 0f
            if (ventil1State > 0f) {
                binding.ventil1.setImageResource(R.drawable.vlv1_green)   // dein Bild für geöffnet
            } else {
                binding.ventil1.setImageResource(R.drawable.vlv1_red) // dein Bild für geschlossen
            }

            val ventil2State = values["ventil_2"] ?: 0f
            if (ventil2State > 0f) {
                binding.ventil2.setImageResource(R.drawable.vlv1_green)   // dein Bild für geöffnet
            } else {
                binding.ventil2.setImageResource(R.drawable.vlv1_red) // dein Bild für geschlossen
            }

            val ventil3State = values["ventil_3"] ?: 0f
            if (ventil3State > 0f) {
                binding.ventil3.setImageResource(R.drawable.vlv1_green)   // dein Bild für geöffnet
            } else {
                binding.ventil3.setImageResource(R.drawable.vlv1_red) // dein Bild für geschlossen
            }

            val ventil4State = values["ventil_4"] ?: 0f
            if (ventil4State > 0f) {
                binding.ventil4.setImageResource(R.drawable.vlv2_green)   // dein Bild für geöffnet
            } else {
                binding.ventil4.setImageResource(R.drawable.vlv2_red) // dein Bild für geschlossen
            }

            val ventil5State = values["ventil_5"] ?: 0f
            if (ventil5State > 0f) {
                binding.ventil5.setImageResource(R.drawable.vlv1_green)   // dein Bild für geöffnet
            } else {
                binding.ventil5.setImageResource(R.drawable.vlv1_red) // dein Bild für geschlossen
            }

            val ventil6State = values["ventil_6"] ?: 0f
            if (ventil6State > 0f) {
                binding.ventil6.setImageResource(R.drawable.vlv1_green)   // dein Bild für geöffnet
            } else {
                binding.ventil6.setImageResource(R.drawable.vlv1_red) // dein Bild für geschlossen
            }

            val ventil7State = values["ventil_7"] ?: 0f
            if (ventil7State > 0f) {
                binding.ventil7.setImageResource(R.drawable.vlv1_green)   // dein Bild für geöffnet
            } else {
                binding.ventil7.setImageResource(R.drawable.vlv1_red) // dein Bild für geschlossen
            }

            val ventil8State = values["ventil_8"] ?: 0f
            if (ventil8State > 0f) {
                binding.ventil8.setImageResource(R.drawable.vlv1_green)   // dein Bild für geöffnet
            } else {
                binding.ventil8.setImageResource(R.drawable.vlv1_red) // dein Bild für geschlossen
            }

            val ventil9State = values["ventil_9"] ?: 0f
            if (ventil9State > 0f) {
                binding.ventil9.setImageResource(R.drawable.vlv1_green)   // dein Bild für geöffnet
            } else {
                binding.ventil9.setImageResource(R.drawable.vlv1_red) // dein Bild für geschlossen
            }

            // 🔹 Beispiel für eine AValve
            val aventilState = values["aventil"] ?: 0f
            if (aventilState > 0f) {
                binding.aventil.setImageResource(R.drawable.avlv_green)
            } else {
                binding.aventil.setImageResource(R.drawable.avlv_red)
            }

            // 🔹 Beispiel für eine Pumpe 1
            val pump1State = values["pumpe_1"] ?: 0f
            if (pump1State > 0f) {
                binding.pump1.setImageResource(R.drawable.pump_green)
            } else {
                binding.pump1.setImageResource(R.drawable.pump_red)
            }

            val pump2State = values["pumpe_2"] ?: 0f
            if (pump2State > 0f) {
                binding.pump2.setImageResource(R.drawable.pump_green)
            } else {
                binding.pump2.setImageResource(R.drawable.pump_red)
            }

            val heater1State = values["heater_1"] ?: 0f
            if (heater1State > 0f) {
                binding.heater1.setImageResource(R.drawable.heizstab_green)
            } else {
                binding.heater1.setImageResource(R.drawable.heizstab_rot)
            }

            val heater2State = values["heater_2"] ?: 0f
            if (heater2State > 0f) {
                binding.heater2.setImageResource(R.drawable.heizstab_green)
            } else {
                binding.heater2.setImageResource(R.drawable.heizstab_rot)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
