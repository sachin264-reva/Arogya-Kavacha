package com.example.health

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fortis.*
import kotlinx.android.synthetic.main.activity_sap.*

class sapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sap)


        locationSap.setOnClickListener{
            var locSap = Intent(Intent.ACTION_VIEW, Uri.parse("geo:13.0706,77.5025"))
            startActivity(locSap)
        }
        emailSap.setOnClickListener{
            var mailSap = Intent(Intent.ACTION_SEND, Uri.parse("mailto:hospitalsapthagiri@gmail.com"))
            startActivity(mailSap)
        }
        callSap.setOnClickListener{
            var callSap = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08028393392"))
            startActivity(callSap)
        }
    }
}