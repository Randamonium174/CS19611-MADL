package com.example.formvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameField = findViewById<EditText>(R.id.username)
        val userIDField = findViewById<EditText>(R.id.userID)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        loginButton.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val userID = userIDField.text.toString().trim()

            if (username.isEmpty() || userID.isEmpty()) {
                Toast.makeText(this, "Both fields must not be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!username.matches(Regex("^[a-zA-Z]+$"))) {
                Toast.makeText(this, "Username must contain only alphabets!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!userID.matches(Regex("^\\d{4}$"))) {
                Toast.makeText(this, "ID must be exactly 4 digits!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
        }

        clearButton.setOnClickListener {
            usernameField.text.clear()
            userIDField.text.clear()
            Toast.makeText(this, "Fields Cleared", Toast.LENGTH_SHORT).show()
        }
    }
}
