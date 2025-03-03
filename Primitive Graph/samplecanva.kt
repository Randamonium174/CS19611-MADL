package com.exapple.primitivegrph

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class samplecanvas @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Set background color
        paint.color = Color.YELLOW
        canvas.drawPaint(paint)

        // Grid Layout Positions
        val leftX = 100f
        val rightX = 400f
        val topY = 100f
        val bottomY = 400f
        val secondRowY = 450f
        val secondRowBottomY = 750f

        // Draw Circle (Red) - Top Left
        paint.color = Color.RED
        canvas.drawCircle(leftX + 150f, topY + 150f, 100f, paint)
        paint.color = Color.BLACK
        paint.textSize = 50f
        canvas.drawText("Circle", leftX + 90f, topY + 320f, paint)

        // Draw Rectangle (Green) - Top Right
        paint.color = Color.GREEN
        canvas.drawRect(rightX, topY, rightX + 300f, bottomY, paint)
        paint.color = Color.BLACK
        canvas.drawText("Rectangle", rightX + 50f, bottomY + 50f, paint)

        // Draw Square (Blue) - Bottom Left
        paint.color = Color.BLUE
        canvas.drawRect(leftX, secondRowY, leftX + 300f, secondRowBottomY, paint)
        paint.color = Color.BLACK
        canvas.drawText("Square", leftX + 90f, secondRowBottomY + 50f, paint)

        // Draw Line (Black) - Bottom Right (VERTICAL)
        paint.color = Color.BLACK
        paint.strokeWidth = 10f
        canvas.drawLine(rightX + 150f, secondRowY, rightX + 150f, secondRowBottomY, paint)
        canvas.drawText("Line", rightX + 100f, secondRowBottomY + 50f, paint)
    }
}
