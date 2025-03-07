package com.example.sdcardbookdetails

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etTitle: EditText = findViewById(R.id.bookTitle)
        val etAuthor: EditText = findViewById(R.id.bookAuthor)
        val etPublisher: EditText = findViewById(R.id.bookPublisher)
        val etPrice: EditText = findViewById(R.id.bookPrice)
        val btSave: Button = findViewById(R.id.btsave)
        val btLoad: Button = findViewById(R.id.btload)

        btSave.setOnClickListener {
            val title = etTitle.text.toString()
            val author = etAuthor.text.toString()
            val publisher = etPublisher.text.toString()
            val price = etPrice.text.toString()
            val file = File(getExternalFilesDir(null), "book.txt")
            val writer = FileWriter(file)
            writer.write("$title\n$author\n$publisher\n$price")
            writer.close()
            Toast.makeText(this, "Saved successfully!", Toast.LENGTH_LONG).show()
            etTitle.text.clear()
            etAuthor.text.clear()
            etPublisher.text.clear()
            etPrice.text.clear()
        }

        btLoad.setOnClickListener {
            val file = File(getExternalFilesDir(null), "book.txt")
            val reader = BufferedReader(FileReader(file))
            val title = reader.readLine()
            val author = reader.readLine()
            val publisher = reader.readLine()
            val price = reader.readLine()
            reader.close()
            Toast.makeText(this, "Loaded successfully!", Toast.LENGTH_LONG).show()
            etTitle.setText(title)
            etAuthor.setText(author)
            etPublisher.setText(publisher)
            etPrice.setText(price)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
