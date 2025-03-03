package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        tvResult = findViewById(R.id.tvResult)

        // Basic Operations
        findViewById<Button>(R.id.btnAdd).setOnClickListener { calculate('+') }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { calculate('-') }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { calculate('*') }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { calculate('/') }

        // Advanced Math Operations
        findViewById<Button>(R.id.btnSqrt).setOnClickListener { calculate('√') }
        findViewById<Button>(R.id.btnPower).setOnClickListener { calculate('^') }
        findViewById<Button>(R.id.btnLog).setOnClickListener { calculate('l') }

        // Trigonometric Operations
        findViewById<Button>(R.id.btnSin).setOnClickListener { calculate('s') }
        findViewById<Button>(R.id.btnCos).setOnClickListener { calculate('c') }
        findViewById<Button>(R.id.btnTan).setOnClickListener { calculate('t') }
    }

    private fun calculate(operation: Char) {
        val num1 = etNumber1.text.toString().toDoubleOrNull()
        val num2 = etNumber2.text.toString().toDoubleOrNull()

        if (num1 == null) {
            Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            '+' -> num1 + (num2 ?: 0.0)
            '-' -> num1 - (num2 ?: 0.0)
            '*' -> num1 * (num2 ?: 1.0)
            '/' -> if (num2 != null && num2 != 0.0) num1 / num2 else "Cannot divide by zero"
            '√' -> sqrt(num1)
            '^' -> num1.pow(num2 ?: 1.0)
            'l' -> log10(num1)
            's' -> sin(Math.toRadians(num1))
            'c' -> cos(Math.toRadians(num1))
            't' -> tan(Math.toRadians(num1))
            else -> "Invalid"
        }

        tvResult.text = "Result: $result"
    }
}
