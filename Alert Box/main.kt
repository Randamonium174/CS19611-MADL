package com.example.alertbox

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.displayButton)
        button.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("Do you want to proceed?")
        builder.setPositiveButton("OK") { dialog, _ ->
            Toast.makeText(this, "You clicked OK", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            Toast.makeText(this, "You clicked Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.show()
    }
}
