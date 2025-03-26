package com.example.telephonyservices

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val PERMISSION_REQUEST_CODE = 627
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) !=
            PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_PHONE_STATE),PERMISSION_REQUEST_CODE)
        }


        val ntname : EditText = findViewById(R.id.ntname)
        val ntcountry : EditText = findViewById(R.id.ntcountry)
        val etphone : EditText = findViewById(R.id.etphone)
        val etsim : EditText = findViewById(R.id.etsim)
        val etnetwork :EditText = findViewById(R.id.etnetwork)
        val btget : Button = findViewById(R.id.btget)

        btget.setOnClickListener {
            ntname.setText(telephonyManager.networkOperatorName)
            ntcountry.setText(telephonyManager.networkCountryIso)

            val phonetype = when (telephonyManager.phoneType){
                TelephonyManager.PHONE_TYPE_GSM -> "ready"
                TelephonyManager.PHONE_TYPE_CDMA -> "CDMA"
                else -> "others"
            }
           etphone.setText(phonetype)
            val simstate = when (telephonyManager.simState){
                TelephonyManager.SIM_STATE_READY -> "ready"
                TelephonyManager.SIM_STATE_ABSENT -> "absent"
                else -> "others"
            }
            etsim.setText(simstate)
            val networktype = when(telephonyManager.networkType){
                TelephonyManager.NETWORK_TYPE_LTE -> "4G"
                TelephonyManager.NETWORK_TYPE_NR -> "5G"
                else -> "others"
            }
            etnetwork.setText(networktype)

        }
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
