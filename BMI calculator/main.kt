package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var tvResult: TextView
    private lateinit var tvCategory: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvResult = findViewById(R.id.tvResult)
        tvCategory = findViewById(R.id.tvCategory)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val weightInput = etWeight.text.toString()
            val heightInput = etHeight.text.toString()

            if (weightInput.isNotEmpty() && heightInput.isNotEmpty()) {
                val weight = weightInput.toDouble()
                val height = heightInput.toDouble()

                if (height > 0) {
                    val bmi = weight / (height * height)
                    val category = getBMICategory(bmi)

                    tvResult.text = "BMI: %.2f".format(bmi)
                    tvCategory.text = "Category: $category"
                } else {
                    Toast.makeText(this, "Height must be greater than 0", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter weight and height", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi in 18.5..24.9 -> "Normal (Healthy)"
            bmi in 25.0..29.9 -> "Overweight"
            bmi in 30.0..34.9 -> "Obese Class 1 (Moderate)"
            bmi in 35.0..39.9 -> "Obese Class 2 (Severe)"
            else -> "Obese Class 3 (Very Severe)"
        }
    }
}
