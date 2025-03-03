package com.example.scientificcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentInput: String = ""
    private var operator: String = ""
    private var firstValue: Double = 0.0
    private var secondValue: Double = 0.0
    private var isOperatorSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)
    }

    // Handling Number Clicks
    fun onNumberClick(view: View) {
        val button = view as Button
        currentInput += button.text
        display.text = currentInput
    }

    // Handling Operator Clicks (+, -, *, /, mod, x^y, n√x)
    fun onOperatorClick(view: View) {
        val button = view as Button
        if (currentInput.isNotEmpty()) {
            firstValue = currentInput.toDouble()
            operator = button.text.toString()
            currentInput = ""
            isOperatorSelected = true
        }
    }

    // Handling Scientific Function Clicks
    fun onFunctionClick(view: View) {
        val button = view as Button
        if (currentInput.isNotEmpty()) {
            val value = currentInput.toDouble()
            currentInput = when (button.text.toString()) {
                "sin" -> sin(Math.toRadians(value)).toString()
                "cos" -> cos(Math.toRadians(value)).toString()
                "tan" -> tan(Math.toRadians(value)).toString()
                "asin" -> Math.toDegrees(asin(value)).toString()
                "acos" -> Math.toDegrees(acos(value)).toString()
                "atan" -> Math.toDegrees(atan(value)).toString()
                "sinh" -> sinh(value).toString()
                "cosh" -> cosh(value).toString()
                "tanh" -> tanh(value).toString()
                "sqrt" -> sqrt(value).toString()
                "log" -> log10(value).toString()
                "e^x" -> exp(value).toString()
                "x!" -> factorial(value.toInt()).toString()
                else -> "Error"
            }
            display.text = currentInput
        }
    }

    // Handling Equal Click (=)
    fun onEqualClick(view: View) {
        if (currentInput.isNotEmpty() && isOperatorSelected) {
            secondValue = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstValue + secondValue
                "-" -> firstValue - secondValue
                "*" -> firstValue * secondValue
                "/" -> if (secondValue != 0.0) firstValue / secondValue else "Error"
                "mod" -> firstValue % secondValue
                "x^y" -> firstValue.pow(secondValue)
                "n√x" -> secondValue.pow(1 / firstValue) // nth root (e.g., 3√8 = 2)
                else -> "Error"
            }
            display.text = result.toString()
            currentInput = result.toString()
            isOperatorSelected = false
        }
    }

    // Handling Clear Button (C)
    fun onClearClick(view: View) {
        currentInput = ""
        firstValue = 0.0
        secondValue = 0.0
        operator = ""
        isOperatorSelected = false
        display.text = "0"
    }

    // Factorial Function
    private fun factorial(n: Int): Long {
        return if (n == 0 || n == 1) 1 else n * factorial(n - 1)
    }
}
