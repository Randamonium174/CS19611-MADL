package com.example.randomnumbergenerator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var etMin: EditText
    private lateinit var etMax: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMin = findViewById(R.id.etMin)
        etMax = findViewById(R.id.etMax)
        tvResult = findViewById(R.id.tvResult)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)

        btnGenerate.setOnClickListener {
            val minInput = etMin.text.toString()
            val maxInput = etMax.text.toString()

            if (minInput.isNotEmpty() && maxInput.isNotEmpty()) {
                val min = minInput.toInt()
                val max = maxInput.toInt()

                if (min < max) {
                    val randomNumber = Random.nextInt(min, max + 1)
                    tvResult.text = "Random Number: $randomNumber"
                } else {
                    Toast.makeText(this, "Min should be less than Max", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
