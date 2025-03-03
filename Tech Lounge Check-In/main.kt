package com.example.techloungecheckin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvStudentCount: TextView
    private var studentCount = 0 // Initial count

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStudentCount = findViewById(R.id.tvStudentCount)
        val btnCheckIn = findViewById<Button>(R.id.btnCheckIn)
        val btnCheckOut = findViewById<Button>(R.id.btnCheckOut)

        // Check-In Button Click
        btnCheckIn.setOnClickListener {
            studentCount++  // Increase count
            updateStudentCount()
        }

        // Check-Out Button Click
        btnCheckOut.setOnClickListener {
            studentCount--  // Decrease count (can go negative)
            updateStudentCount()
        }
    }

    private fun updateStudentCount() {
        tvStudentCount.text = "Students Inside: $studentCount"
    }
}
