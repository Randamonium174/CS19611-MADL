package com.example.alarmapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var timePicker: TimePicker
    private lateinit var setAlarmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timePicker = findViewById(R.id.timePicker)
        setAlarmButton = findViewById(R.id.setAlarmButton)

        setAlarmButton.setOnClickListener {
            val hour = timePicker.hour
            val minute = timePicker.minute

            val calendar = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, hour)
                set(Calendar.MINUTE, minute)
                set(Calendar.SECOND, 0)
            }

            val intent = Intent(this, AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                this, 0, intent, PendingIntent.FLAG_IMMUTABLE
            )

            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )

            Toast.makeText(this, "Alarm set for $hour:$minute", Toast.LENGTH_SHORT).show()
        }
    }
}
