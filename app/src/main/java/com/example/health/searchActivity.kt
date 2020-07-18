package com.example.health

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search.*

class searchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        hospitals.setOnClickListener()
        {
            var shift = Intent(this,MainActivity2::class.java)
            startActivity(shift)
        }
    }
}