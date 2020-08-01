package com.example.health

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_nimhans.*

class NimhansActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nimhans)

        val marquee = findViewById<TextView>(R.id.marquee2)
        marquee.text = "NIMHANS is opening the outpatient services for in-person visits from 1st June 2020. In order to reduce overcrowding and to ensure social distancing in the OPD premises, the outpatient services will be through appointment only."
        marquee.setSingleLine()
        marquee.ellipsize = TextUtils.TruncateAt.MARQUEE
        marquee.marqueeRepeatLimit = -1
        marquee.isSelected = true

        callNimhans.setOnClickListener {
            var call = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08026991699"))
            startActivity(call)
        }
    }
}