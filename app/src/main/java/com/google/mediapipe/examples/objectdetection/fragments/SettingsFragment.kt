package com.google.mediapipe.examples.objectdetection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.mediapipe.examples.objectdetection.databinding.FragmentSettingsBinding
import com.google.mediapipe.examples.objectdetection.MainViewModel

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSettingsControls()
        updateSettingsUi()
    }

    private fun initSettingsControls() {
        binding.thresholdMinus.setOnClickListener {
            if (viewModel.currentThreshold >= 0.1f) {
                viewModel.setThreshold(viewModel.currentThreshold - 0.1f)
                updateSettingsUi()
            }
        }

        binding.thresholdPlus.setOnClickListener {
            if (viewModel.currentThreshold <= 0.8f) {
                viewModel.setThreshold(viewModel.currentThreshold + 0.1f)
                updateSettingsUi()
            }
        }

        binding.maxResultsMinus.setOnClickListener {
            if (viewModel.currentMaxResults > 1) {
                viewModel.setMaxResults(viewModel.currentMaxResults - 1)
                updateSettingsUi()
            }
        }

        binding.maxResultsPlus.setOnClickListener {
            if (viewModel.currentMaxResults < 5) {
                viewModel.setMaxResults(viewModel.currentMaxResults + 1)
                updateSettingsUi()
            }
        }

        binding.spinnerDelegate.setSelection(viewModel.currentDelegate, false)
        binding.spinnerDelegate.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.setDelegate(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.spinnerModel.setSelection(viewModel.currentModel, false)
        binding.spinnerModel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.setModel(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun updateSettingsUi() {
        binding.thresholdValue.text = String.format("%.2f", viewModel.currentThreshold)
        binding.maxResultsValue.text = viewModel.currentMaxResults.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
