package com.example.digitalcafelogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailField = findViewById<EditText>(R.id.edit_email)
        val passwordField = findViewById<EditText>(R.id.edit_password)
        val validateButton = findViewById<Button>(R.id.btn_validate)

        validateButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (validateInputs(email, password)) {
                Toast.makeText(this, "Validation Successful!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {
        if (email.isEmpty() || password.isEmpty()) {
            showToast("Fields cannot be empty")
            return false
        }

        val emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z]+\\.edu+\\.in".toRegex()
        if (!email.matches(emailRegex)) {
            showToast("Enter a valid college email ID")
            return false
        }

        val passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,}$".toRegex()
        if (!password.matches(passwordRegex)) {
            showToast("Password must be at least 8 characters, include letters, numbers, and special characters")
            return false
        }
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
