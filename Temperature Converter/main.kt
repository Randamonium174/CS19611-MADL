package com.example.temperatureconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etTemperature: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTemperature = findViewById(R.id.etTemperature)
        tvResult = findViewById(R.id.tvResult)
        val btnToFahrenheit = findViewById<Button>(R.id.btnToFahrenheit)
        val btnToCelsius = findViewById<Button>(R.id.btnToCelsius)

        // Convert to Fahrenheit
        btnToFahrenheit.setOnClickListener {
            val input = etTemperature.text.toString()
            if (input.isNotEmpty()) {
                val celsius = input.toDouble()
                val fahrenheit = (celsius * 9 / 5) + 32
                tvResult.text = "Result: $fahrenheit °F"
            } else {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
            }
        }

        // Convert to Celsius
        btnToCelsius.setOnClickListener {
            val input = etTemperature.text.toString()
            if (input.isNotEmpty()) {
                val fahrenheit = input.toDouble()
                val celsius = (fahrenheit - 32) * 5 / 9
                tvResult.text = "Result: $celsius °C"
            } else {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
