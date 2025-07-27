package com.hka.objectdetection.fragments
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hka.objectdetection.databinding.FragmentPromilleBinding
import kotlin.math.max

class PromilleFragment : Fragment() {

    private var _binding: FragmentPromilleBinding? = null
    private val binding get() = _binding!!

    private var beerCount = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPromilleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Normaler Klick: +1 Bier
        binding.addBeerButton.setOnClickListener {
            beerCount++
            binding.beerCountText.text = "$beerCount Bier"
            calculatePromille()
        }

        // Langer Klick: Reset
        binding.addBeerButton.setOnLongClickListener {
            beerCount = 0
            binding.beerCountText.text = "0 Bier"
            calculatePromille()
            true
        }
    }


    private fun calculatePromille() {
        val weight = binding.weightInput.text.toString().toFloatOrNull() ?: 0f
        if (weight <= 0f) return

        // 1 Bier = ca. 12g Alkohol bei 0,5l, 5%
        val alcoholGrams = beerCount * 12f
        val promille = alcoholGrams / (weight * 0.68f)

        binding.promilleText.text = String.format("≈ %.2f ‰", promille)

        // Zeit bis nüchtern (0,1 ‰ pro Stunde)
        val hours = promille / 0.1f
        binding.soberTimeText.text = String.format("Wieder nüchtern in: %.1f h", max(0f, hours))

        // Farbcode
        when {
            promille <= 0.3f -> binding.promilleText.setTextColor(Color.GREEN)
            promille <= 0.5f -> binding.promilleText.setTextColor(Color.rgb(211, 126,0))
            else -> binding.promilleText.setTextColor(Color.RED)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
