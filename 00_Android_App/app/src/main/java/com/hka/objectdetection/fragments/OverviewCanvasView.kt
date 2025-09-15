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
                    textSize = 60f * scale    // skalieren je nach Bildschirmgröße
                    isAntiAlias = true
                    typeface = Typeface.DEFAULT_BOLD
                }

                // Beispielkoordinaten im Designmaßstab (müssen an dein Layout angepasst werden)
                canvas.drawText(
                    "${it["tank_1"]?.let { v -> String.format("%.2f °C", v) } ?: "-- °C"}",
                    left + 200f * scale,
                    top + 460f * scale,
                    paint
                )
                canvas.drawText(
                    "${it["tank_2"]?.let { v -> String.format("%.2f °C", v) } ?: "-- °C"}",
                    left + 250f * scale,
                    top + 460f * scale,
                    paint
                )
                canvas.drawText(
                    "${it["tank_3"]?.let { v -> String.format("%.2f °C", v) } ?: "-- °C"}",
                    left + 460f * scale,
                    top + 175f * scale,
                    paint
                )

                // AValve Prozent
                val percent = (it["aventil"] ?: 101f).toInt()
                paint.color = when {
                    percent <= 10 -> Color.RED
                    percent in 11..80 -> Color.parseColor("#FFA500") // Orange
                    percent in 81..100 -> Color.GREEN
                    else -> Color.GRAY
                }
                canvas.drawText("$percent %", left + 230f * scale, top + 1180f * scale, paint)
            }
        }
    }
}