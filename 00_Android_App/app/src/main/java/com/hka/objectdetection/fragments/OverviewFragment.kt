package com.hka.objectdetection.fragments
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.hka.objectdetection.MainViewModel
import com.hka.objectdetection.databinding.FragmentOverviewBinding
import com.hka.objectdetection.R


class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tanks und Ventile aus dem ViewModel beobachten
        viewModel.allValues.observe(viewLifecycleOwner) { values ->
            // 🔹 Tanks anzeigen
            binding.tempBoil.text = "${values["tank_1"] ?: "--"} °C"
            binding.tempMlt.text = "${values["tank_2"] ?: "--"} °C"
            binding.tempHlt.text = "${values["tank_3"] ?: "--"} °C"

            // 🔹 Beispiel für Ventil 1
            val ventil1State = values["ventil_1"] ?: 3f
            when (ventil1State){
                0f -> binding.ventil1.setImageResource(R.drawable.vlv1_red)
                1f -> binding.ventil1.setImageResource(R.drawable.vlv1_green)
                else -> binding.ventil1.setImageResource(R.drawable.vlv1_gray)
            }

            val ventil2State = values["ventil_2"] ?: 3f
            when (ventil2State){
                0f -> binding.ventil2.setImageResource(R.drawable.vlv1_red)
                1f -> binding.ventil2.setImageResource(R.drawable.vlv1_green)
                else -> binding.ventil2.setImageResource(R.drawable.vlv1_gray)
            }

            val ventil3State = values["ventil_3"] ?: 3f
            when (ventil3State){
                0f -> binding.ventil3.setImageResource(R.drawable.vlv1_red)
                1f -> binding.ventil3.setImageResource(R.drawable.vlv1_green)
                else -> binding.ventil3.setImageResource(R.drawable.vlv1_gray)
            }

            val ventil4State = values["ventil_4"] ?: 3f
            when (ventil4State){
                0f -> binding.ventil4.setImageResource(R.drawable.vlv2_red)
                1f -> binding.ventil4.setImageResource(R.drawable.vlv2_green)
                else -> binding.ventil4.setImageResource(R.drawable.vlv2_gray)
            }

            val ventil5State = values["ventil_5"] ?: 3f
            when (ventil5State){
                0f -> binding.ventil5.setImageResource(R.drawable.vlv1_red)
                1f -> binding.ventil5.setImageResource(R.drawable.vlv1_green)
                else -> binding.ventil5.setImageResource(R.drawable.vlv1_gray)
            }

            val ventil6State = values["ventil_6"] ?: 3f
            when (ventil6State){
                0f -> binding.ventil6.setImageResource(R.drawable.vlv1_red)
                1f -> binding.ventil6.setImageResource(R.drawable.vlv1_green)
                else -> binding.ventil6.setImageResource(R.drawable.vlv1_gray)
            }

            val ventil7State = values["ventil_7"] ?: 3f
            when (ventil7State){
                0f -> binding.ventil7.setImageResource(R.drawable.vlv1_red)
                1f -> binding.ventil7.setImageResource(R.drawable.vlv1_green)
                else -> binding.ventil7.setImageResource(R.drawable.vlv1_gray)
            }

            val ventil8State = values["ventil_8"] ?: 3f
            when (ventil8State){
                0f -> binding.ventil8.setImageResource(R.drawable.vlv1_red)
                1f -> binding.ventil8.setImageResource(R.drawable.vlv1_green)
                else -> binding.ventil8.setImageResource(R.drawable.vlv1_gray)
            }

            val ventil9State = values["ventil_9"] ?: 3f
            when (ventil9State){
                0f -> binding.ventil9.setImageResource(R.drawable.vlv2_red)
                1f -> binding.ventil9.setImageResource(R.drawable.vlv2_green)
                else -> binding.ventil9.setImageResource(R.drawable.vlv2_gray)
            }

            // 🔹 Beispiel für eine AValve
            val percent = (values["aventil"] ?: 101f).toInt()
            binding.aventilPercent.text = "$percent %"
            binding.aventilProgress.progress = percent

            // ✅ Farbe aus colors.xml holen – sicher mit binding.root.context
            val red = ContextCompat.getColor(binding.root.context, R.color.Red)
            val orange = ContextCompat.getColor(binding.root.context, R.color.Orange)
            val green = ContextCompat.getColor(binding.root.context, R.color.Green)
            val black = ContextCompat.getColor(binding.root.context, R.color.Black)

            when {
                percent <= 10 -> {
                    binding.aventilPercent.setTextColor(red)
                    binding.aventil.setImageResource(R.drawable.avlv_red)
                }
                percent in 11..80 -> {
                    binding.aventilPercent.setTextColor(orange)
                    binding.aventil.setImageResource(R.drawable.avlv_orange)
                }
                percent in 81..100 -> {
                    binding.aventilPercent.setTextColor(green)
                    binding.aventil.setImageResource(R.drawable.avlv_green)
                }
                else -> {
                    binding.aventilPercent.text = "-- %"
                    binding.aventilProgress.progress = 0
                    binding.aventilPercent.setTextColor(black)
                    binding.aventil.setImageResource(R.drawable.avlv_gray)
                }
            }










            // 🔹 Beispiel für eine Pumpe 1
            val pump1State = values["pumpe_1"] ?: 3f
            when (pump1State){
                0f -> binding.pump1.setImageResource(R.drawable.pump_red)
                1f -> binding.pump1.setImageResource(R.drawable.pump_green)
                else -> binding.pump1.setImageResource(R.drawable.pump_gray)
            }

            val pump2State = values["pumpe_2"] ?: 3f
            when (pump2State){
                0f -> binding.pump2.setImageResource(R.drawable.pump_red)
                1f -> binding.pump2.setImageResource(R.drawable.pump_green)
                else -> binding.pump2.setImageResource(R.drawable.pump_gray)
            }

            val heater1State = values["heater_1"] ?: 3f
            when (heater1State){
                0f -> binding.heater1.setImageResource(R.drawable.heizstab_rot)
                1f -> binding.heater1.setImageResource(R.drawable.heizstab_green)
                else -> binding.heater1.setImageResource(R.drawable.heizstab_gray)
            }

            val heater2State = values["heater_2"] ?: 3f
            when (heater2State){
                0f -> binding.heater2.setImageResource(R.drawable.heizstab_rot)
                1f -> binding.heater2.setImageResource(R.drawable.heizstab_green)
                else -> binding.heater2.setImageResource(R.drawable.heizstab_gray)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
