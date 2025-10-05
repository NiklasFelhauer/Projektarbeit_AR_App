package com.hka.objectdetection.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.hka.objectdetection.MainViewModel
import com.hka.objectdetection.databinding.FragmentMqttBinding
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

        // Manuell verbinden, wenn Button geklickt wird
        binding.buttonConnect.setOnClickListener {
            viewModel.startMqtt()
        }

        // Verlauf löschen
        binding.buttonClear.setOnClickListener {
            viewModel.clearMessages()
        }

        // Nachrichten-Log anzeigen
        viewModel.mqttMessages.observe(viewLifecycleOwner) { list ->
            binding.textMessages.text = list.joinToString("\n")

            binding.scrollViewMessages.post {
                binding.scrollViewMessages.fullScroll(View.FOCUS_DOWN)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}