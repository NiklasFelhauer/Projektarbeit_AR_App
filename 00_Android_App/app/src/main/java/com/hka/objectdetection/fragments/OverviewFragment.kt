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
        // preload resources once (do this after you've set canvasView and overlayItems)
        val vlv1Gray = BitmapFactory.decodeResource(resources, R.drawable.vlv1_gray)
        val vlv1Red = BitmapFactory.decodeResource(resources, R.drawable.vlv1_red)
        val vlv1Green = BitmapFactory.decodeResource(resources, R.drawable.vlv1_green)

        val vlv2Gray = BitmapFactory.decodeResource(resources, R.drawable.vlv2_gray)
        val vlv2Red = BitmapFactory.decodeResource(resources, R.drawable.vlv2_red)
        val vlv2Green = BitmapFactory.decodeResource(resources, R.drawable.vlv2_green)

        val pumpGray = BitmapFactory.decodeResource(resources, R.drawable.pump_gray)
        val pumpRed = BitmapFactory.decodeResource(resources, R.drawable.pump_red)
        val pumpGreen = BitmapFactory.decodeResource(resources, R.drawable.pump_green)

        val heaterGray = BitmapFactory.decodeResource(resources, R.drawable.heizstab_gray)
        val heaterRed = BitmapFactory.decodeResource(resources, R.drawable.heizstab_rot)
        val heaterGreen = BitmapFactory.decodeResource(resources, R.drawable.heizstab_green)

        val avlvGray = BitmapFactory.decodeResource(resources, R.drawable.avlv_gray)
        val avlvRed = BitmapFactory.decodeResource(resources, R.drawable.avlv_red)
        val avlvOrange = BitmapFactory.decodeResource(resources, R.drawable.avlv_orange)
        val avlvGreen = BitmapFactory.decodeResource(resources, R.drawable.avlv_green)

        viewModel.allValues.observe(viewLifecycleOwner) { values ->

            // store values so Canvas can also draw text (if you use canvasView.values)
            canvasView.values = values

            // Iterate all overlay items and set .bitmap depending on id and values map
            canvasView.overlayItems.forEach { item ->
                val id = item.id

                when {
                    // ventil1, ventil2, ... mostly using vlv1 assets, but ventil4 & ventil9 use vlv2
                    id.startsWith("ventil") -> {
                        val num = id.removePrefix("ventil")                  // "1", "2", ...
                        val key = "ventil_$num"
                        val state = values[key] ?: 3f

                        val usesVlv2 = (id == "ventil4" || id == "ventil9")
                        item.bitmap = if (usesVlv2) {
                            when (state) {
                                0f -> vlv2Red
                                1f -> vlv2Green
                                else -> vlv2Gray
                            }
                        } else {
                            when (state) {
                                0f -> vlv1Red
                                1f -> vlv1Green
                                else -> vlv1Gray
                            }
                        }
                    }

                    // pumps: pump1 -> key "pumpe_1"
                    id.startsWith("pump") -> {
                        val num = id.removePrefix("pump")
                        val key = "pumpe_$num"
                        val state = values[key] ?: 3f
                        item.bitmap = when (state) {
                            0f -> pumpRed
                            1f -> pumpGreen
                            else -> pumpGray
                        }
                    }

                    // heaters: heater1 -> "heater_1"
                    id.startsWith("heater") -> {
                        val num = id.removePrefix("heater")
                        val key = "heater_$num"
                        val state = values[key] ?: 3f
                        item.bitmap = when (state) {
                            0f -> heaterRed
                            1f -> heaterGreen
                            else -> heaterGray
                        }
                    }

                    // AValve
                    id == "aventil" -> {
                        val percent = (values["aventil"] ?: 101f).toInt()
                        item.bitmap = when {
                            percent <= 10 -> avlvRed
                            percent in 11..80 -> avlvOrange
                            percent in 81..100 -> avlvGreen
                            else -> avlvGray
                        }
                    }

                    else -> {
                        // fallback: leave item's bitmap as-is
                    }
                }
            }

            // redraw canvas once after updating bitmaps
            canvasView.invalidate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
