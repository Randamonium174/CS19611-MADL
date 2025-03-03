package com.example.guicomponents

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guicomponents.R.id.layout

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var layout: LinearLayout

    private var fontSizeIndex = 0
    private var colorIndex = 0
    private var bgColorIndex = 0

    // Font sizes
    private val fontSizes = floatArrayOf(16f, 20f, 24f, 28f, 32f)

    // Font colors
    private val fontColors = intArrayOf(Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA)

    // Background colors
    private val bgColors = intArrayOf(Color.YELLOW, Color.BLUE, Color.WHITE, Color.CYAN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        layout = findViewById(R.id.layout)

        val btnFontSize: Button = findViewById(R.id.btnFontSize)
        val btnFontColor: Button = findViewById(R.id.btnFontColor)
        val btnBgColor: Button = findViewById(R.id.btnBgColor)

        // Change Font Size
        btnFontSize.setOnClickListener {
            fontSizeIndex = (fontSizeIndex + 1) % fontSizes.size
            textView.textSize = fontSizes[fontSizeIndex]
            showToast("Font size changed")
        }

        // Change Font Color
        btnFontColor.setOnClickListener {
            colorIndex = (colorIndex + 1) % fontColors.size
            textView.setTextColor(fontColors[colorIndex])
            showToast("Font color changed")
        }

        // Change Background Color
        btnBgColor.setOnClickListener {
            bgColorIndex = (bgColorIndex + 1) % bgColors.size
            layout.setBackgroundColor(bgColors[bgColorIndex])
            showToast("Background color changed")
        }
    }

    // Function to show Toast messages
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
