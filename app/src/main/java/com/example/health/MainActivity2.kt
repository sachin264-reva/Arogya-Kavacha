package com.example.health

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val listView =  findViewById<ListView>(R.id.list) as ListView
        val hospital = arrayOf("RAMAIAH Memorial Hospitals","APOLLO Hospitals","FORTIS Hospitals","SAPTHAGIRI Hospitals")
        val adp : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,hospital)
        listView.adapter = adp
        listView.setOnItemClickListener(){ parent,view,position,id ->
            if(position==0)
            {
                var msr = Intent(this, MsrActivity::class.java)
                startActivity(msr)
            }
            if(position==1)
            {
                var apollo = Intent(this, ApolloActivity::class.java)
                startActivity(apollo)
            }
            if(position==2)
            {
                var fortis = Intent(this, FortisActivity::class.java)
                startActivity(fortis)
            }
            if(position==3)
            {
                var sapthagiri = Intent(this, sapActivity::class.java)
                startActivity(sapthagiri)
            }
        }
    }
}