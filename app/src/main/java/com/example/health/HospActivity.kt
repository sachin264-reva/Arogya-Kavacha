package com.example.health

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import android.widget.ListAdapter
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View


class HospActivity : AppCompatActivity() {

    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hosp)
//
//        val listView =  findViewById<ListView>(R.id.listView)
//        val customlistdata = ArrayList<CList>()
//        val customlist = CListAdapter(this,customlistdata)
//
//        customlistdata.add(CList(R.drawable.msr_logo,"RAMAIAH Memorial Hospitals","Click here for more info..."))
//        customlistdata.add(CList(R.drawable.apollo,"APOLLO Hospitals","Click here for more info..."))
//        customlistdata.add(CList(R.drawable.fortis_logo,"FORTIS Hospitals","Click here for more info..."))
//        customlistdata.add(CList(R.drawable.sapthagiri,"SAPTHAGIRI Hospitals","Click here for more info..."))
//
//        listView.adapter = customlist
//
//        listView.onItemClickListener = AdapterView.OnItemClickListener{ parent,view,position,id ->
//            Toast.makeText(this@HospActivity , "Item Clicked:- $id",Toast.LENGTH_SHORT).show()
//        }

        listView = findViewById<ListView>(R.id.listView)

        var list = mutableListOf<Model>()
        list.add(Model("RAMAIAH Memorial Hospitals","Click here for more info...",R.drawable.msr_logo))
        list.add(Model("APOLLO Hospitals","Click here for more info...",R.drawable.apollo))
        list.add(Model("FORTIS Hospitals","Click here for more info...",R.drawable.fortis_logo))
        list.add(Model("SAPTHAGIRI Hospitals","Click here for more info...",R.drawable.sapthagiri))

        listView.adapter = MyAdapter(this,R.layout.row,list)

        listView.setOnItemClickListener{ parent , view , position, id ->
            if(position==0)
            {
                Toast.makeText(this@HospActivity , "MSR",Toast.LENGTH_SHORT).show()
            }
            if(position==1)
            {
                Toast.makeText(this@HospActivity , "APOLLO",Toast.LENGTH_SHORT).show()
            }
            if(position==2)
            {
                Toast.makeText(this@HospActivity , "FORTIS",Toast.LENGTH_SHORT).show()
            }
            if(position==3)
            {
                Toast.makeText(this@HospActivity , "SAPTHAGIRI",Toast.LENGTH_SHORT).show()
            }

        }
    }
}