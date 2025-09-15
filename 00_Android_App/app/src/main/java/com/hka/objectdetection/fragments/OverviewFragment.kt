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
import android.graphics.BitmapFactory
import com.hka.objectdetection.OverviewCanvasView
import android.graphics.Bitmap

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

        val canvasView = binding.overviewCanvas

        // 1️⃣ Hintergrund setzen
        canvasView.background = BitmapFactory.decodeResource(resources, R.drawable.anlagen_hintergrund)

        // 2️⃣ OverlayItems vorbereiten (x/y im Designmaßstab, z.B. 1080x1920)
        canvasView.overlayItems = mutableListOf(
            // Ventile
            OverviewCanvasView.OverlayItem("ventil1", BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray), 80f, 630f, designWidth = 50f, designHeight = 50f),
            OverviewCanvasView.OverlayItem("ventil2", BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray), 285f, 775f, designWidth = 50f, designHeight = 50f),
            OverviewCanvasView.OverlayItem("ventil3", BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray), 450f, 775f, designWidth = 50f, designHeight = 50f),
            OverviewCanvasView.OverlayItem("ventil4", BitmapFactory.decodeResource(resources, R.drawable.vlv2_gray), 173f, 1480f, designWidth = 50f, designHeight = 50f),
            OverviewCanvasView.OverlayItem("ventil5", BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray), 260f, 1408f, designWidth = 50f, designHeight = 50f),
            OverviewCanvasView.OverlayItem("ventil6", BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray), 450f, 1408f, designWidth = 50f, designHeight = 50f),
            OverviewCanvasView.OverlayItem("ventil7", BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray), 650f, 1408f, designWidth = 50f, designHeight = 50f),
            OverviewCanvasView.OverlayItem("ventil8", BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray), 850f, 1408f, designWidth = 50f, designHeight = 50f),
            OverviewCanvasView.OverlayItem("ventil9", BitmapFactory.decodeResource(resources, R.drawable.vlv2_gray), 765f, 1100f, designWidth = 50f, designHeight = 50f),

            // Pumpen
            OverviewCanvasView.OverlayItem("pump1", BitmapFactory.decodeResource(resources, R.drawable.pump_gray), 372f, 1280f, designWidth = 70f, designHeight = 70f),
            OverviewCanvasView.OverlayItem("pump2", BitmapFactory.decodeResource(resources, R.drawable.pump_gray), 755f, 1280f, designWidth = 70f, designHeight = 70f),

            // Heizstäbe
            OverviewCanvasView.OverlayItem("heater1", BitmapFactory.decodeResource(resources, R.drawable.heizstab_gray), 230f, 615f, designWidth = 167f, designHeight = 36f),
            OverviewCanvasView.OverlayItem("heater2", BitmapFactory.decodeResource(resources, R.drawable.heizstab_gray), 835f, 615f, designWidth = 167f, designHeight = 36f),

            // AValve
            OverviewCanvasView.OverlayItem("aventil", BitmapFactory.decodeResource(resources, R.drawable.avlv_gray), 385f, 1100f, designWidth = 70f, designHeight = 70f)
        )

        canvasView.invalidate() // einmalig initial zeichnen

        // 3️⃣ ViewModel Updates
        viewModel.allValues.observe(viewLifecycleOwner) { values ->

            canvasView.overlayItems.forEach { item ->
                when (item.id) {
                    // Ventile
                    "ventil1" -> item.bitmap = when (values["ventil_1"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray)
                    }
                    "ventil2" -> item.bitmap = when (values["ventil_2"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray)
                    }
                    "ventil3" -> item.bitmap = when (values["ventil_3"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray)
                    }
                    "ventil4" -> item.bitmap = when (values["ventil_4"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv2_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv2_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv2_gray)
                    }
                    "ventil5" -> item.bitmap = when (values["ventil_5"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray)
                    }
                    "ventil6" -> item.bitmap = when (values["ventil_6"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray)
                    }
                    "ventil7" -> item.bitmap = when (values["ventil_7"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray)
                    }
                    "ventil8" -> item.bitmap = when (values["ventil_8"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray)
                    }
                    "ventil9" -> item.bitmap = when (values["ventil_9"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.vlv2_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.vlv2_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.vlv2_gray)
                    }

                    // Pumpen
                    "pump1" -> item.bitmap = when (values["pumpe_1"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.pump_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.pump_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.pump_gray)
                    }
                    "pump2" -> item.bitmap = when (values["pumpe_2"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.pump_red)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.pump_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.pump_gray)
                    }

                    // Heizstäbe
                    "heater1" -> item.bitmap = when (values["heater_1"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.heizstab_rot)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.heizstab_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.heizstab_gray)
                    }
                    "heater2" -> item.bitmap = when (values["heater_2"] ?: 3f) {
                        0f -> BitmapFactory.decodeResource(resources, R.drawable.heizstab_rot)
                        1f -> BitmapFactory.decodeResource(resources, R.drawable.heizstab_green)
                        else -> BitmapFactory.decodeResource(resources, R.drawable.heizstab_gray)
                    }

                    // AValve
                    "aventil" -> {
                        val percent = (values["aventil"] ?: 101f).toInt()
                        item.bitmap = when {
                            percent <= 10 -> BitmapFactory.decodeResource(resources, R.drawable.avlv_red)
                            percent in 11..80 -> BitmapFactory.decodeResource(resources, R.drawable.avlv_orange)
                            percent in 81..100 -> BitmapFactory.decodeResource(resources, R.drawable.avlv_green)
                            else -> BitmapFactory.decodeResource(resources, R.drawable.avlv_gray)
                        }
                    }
                }
            }

            canvasView.invalidate() // Canvas neu zeichnen
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
