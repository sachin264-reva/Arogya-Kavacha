package com.example.health

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hlist.*

class HlistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hlist)

        msrBtn.setOnClickListener {
            var msr = Intent(this,MsrActivity::class.java)
            startActivity(msr)
        }
        fortisBtn.setOnClickListener {
            var fortis = Intent(this,FortisActivity::class.java)
            startActivity(fortis)
        }
        apolloBtn.setOnClickListener {
            var apollo = Intent(this,ApolloActivity::class.java)
            startActivity(apollo)
        }
        sapthagiriBtn.setOnClickListener {
            var sapthagiri = Intent(this,sapActivity::class.java)
            startActivity(sapthagiri)
        }
    }
}