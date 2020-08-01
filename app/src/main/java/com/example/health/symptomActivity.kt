package com.example.health

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_symptom.*

class symptomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptom)

        cardiacBtn.setOnClickListener {
            var cardiac = Intent(this,JaydevaActivity::class.java)
            startActivity(cardiac)
        }

        oncoBtn.setOnClickListener {
            var oncology = Intent(this,KidwaiActivity::class.java)
            startActivity(oncology)
        }

        uroBtn.setOnClickListener {
            var uro = Intent(this,FortisuroActivity::class.java)
            startActivity(uro)
        }

        neuroBtn.setOnClickListener {
            var neurology = Intent(this,NimhansActivity::class.java)
            startActivity( neurology)
        }

    }
}


