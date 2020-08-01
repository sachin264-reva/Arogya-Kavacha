package com.example.health

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView

class JaydevaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jaydeva)

        val marquee = findViewById<TextView>(R.id.marquee)
        marquee.text = "About 1000 Open Heart surgeries, 8000 Coronary Angiograms, 2000 Procedures including Angioplasties and Valvuloplasties are done in this hospital"
        marquee.setSingleLine()
        marquee.ellipsize = TextUtils.TruncateAt.MARQUEE
        marquee.marqueeRepeatLimit = -1
        marquee.isSelected = true
    }
}