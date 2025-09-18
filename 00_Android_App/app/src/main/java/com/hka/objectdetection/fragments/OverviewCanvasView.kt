package com.hka.objectdetection

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class OverviewCanvasView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    var background: Bitmap? = null
    var designWidth = 1080f
    var designHeight = 1920f

    data class OverlayItem(
        val id: String,
        var bitmap: Bitmap,
        val x: Float,
        val y: Float,
        val designWidth: Float, // in pixels of the design reference
        val designHeight: Float
    )

    var overlayItems = mutableListOf<OverlayItem>()

    var values: Map<String, Float>? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        background?.let { bg ->
            val scaleX = width / designWidth
            val scaleY = height / designHeight
            val scale = minOf(scaleX, scaleY)

            val bgWidth = designWidth * scale
            val bgHeight = designHeight * scale
            val left = (width - bgWidth) / 2
            val top = (height - bgHeight) / 2

            // Hintergrund
            val rect = RectF(left, top, left + bgWidth, top + bgHeight)
            canvas.drawBitmap(bg, null, rect, null)

             // OverlayItems (Ventile, Pumpen, Heizstäbe)
             overlayItems.forEach { item ->

                 val xPos = left + item.x * scale
                 val yPos = top + item.y * scale
                 val bmpWidth = item.designWidth * scale
                 val bmpHeight = item.designHeight * scale
                 canvas.drawBitmap(item.bitmap, null, RectF(xPos, yPos, xPos + bmpWidth, yPos + bmpHeight), null)
             }

            // Text für Temperaturen und AValve
            values?.let {
                val paint = Paint().apply {
                    color = Color.BLACK
                    textSize = 30f * scale    // skalieren je nach Bildschirmgröße
                    isAntiAlias = true
                    typeface = Typeface.DEFAULT
                }

                // Beispielkoordinaten im Designmaßstab
                canvas.drawText(
                    "${it["tank_1"]?.let { v -> String.format("%.2f °C", v) } ?: "-- °C"}",
                    left + 202f * scale,
                    top + 490f * scale,
                    paint
                )
                canvas.drawText(
                    "${it["tank_2"]?.let { v -> String.format("%.2f °C", v) } ?: "-- °C"}",
                    left + 505f * scale,
                    top + 490f * scale,
                    paint
                )
                canvas.drawText(
                    "${it["tank_3"]?.let { v -> String.format("%.2f °C", v) } ?: "-- °C"}",
                    left + 805f * scale,
                    top + 490f * scale,
                    paint
                )

                // AValve Prozent
                val percent = (it["aventil"] ?: 101f).toInt()

                // Draw vertical progress bar background with rounded corners
                val barLeft = left + 340f * scale
                val barTop = top + 1084f * scale
                val barWidth = 15f * scale
                val barHeight = 100f * scale
                val cornerRadius = barWidth / 2

                val backgroundRect = RectF(barLeft, barTop, barLeft + barWidth, barTop + barHeight)
                paint.color = Color.GRAY
                canvas.drawRoundRect(backgroundRect, cornerRadius, cornerRadius, paint)

                // Draw progress bar fill from bottom to top with rounded corners
                val fillHeight = (percent.coerceIn(0, 100) / 100f) * barHeight
                if (fillHeight > 0f) {
                    val fillTop = barTop + barHeight - fillHeight
                    val fillRect = RectF(barLeft, fillTop, barLeft + barWidth, barTop + barHeight)

                    paint.color = when {
                        percent <= 10 -> Color.RED
                        percent in 11..80 -> Color.parseColor("#FFA500") // Orange
                        percent in 81..100 -> Color.GREEN
                        else -> Color.GRAY
                    }

                    // Create path for rounded top corners only if fillHeight < barHeight
                    if (fillHeight < barHeight) {
                        val path = Path()
                        path.addRoundRect(
                            fillRect,
                            floatArrayOf(
                                cornerRadius, cornerRadius, // top-left radius
                                cornerRadius, cornerRadius, // top-right radius
                                0f, 0f, // bottom-right radius
                                0f, 0f  // bottom-left radius
                            ),
                            Path.Direction.CW
                        )
                        canvas.drawPath(path, paint)
                    } else {
                        // Fill entire bar with rounded corners all around
                        canvas.drawRoundRect(fillRect, cornerRadius, cornerRadius, paint)
                    }
                }

                // Draw percent text centered horizontally above the bar with bar color
                paint.color = when {
                    percent <= 10 -> Color.RED
                    percent in 11..80 -> Color.parseColor("#FFA500") // Orange
                    percent in 81..100 -> Color.GREEN
                    else -> Color.GRAY
                }
                paint.textAlign = Paint.Align.CENTER
                canvas.drawText(
                    "$percent %",
                    barLeft + barWidth / 2,
                    barTop - 10f * scale,
                    paint
                )
            }
        }
    }
}