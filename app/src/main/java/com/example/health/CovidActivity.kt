package com.example.health

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class CovidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        var listview = findViewById<ListView>(R.id.listview)
        var list = mutableListOf<Model>()
        list.add(Model("Bangalore", "Bowring Medical College","Shivajinagara, Bengaluru - 560001","Number of Beds = 260"))
        list.add(Model("Bagalkote","District Hospital","DH Navanagar Bagalkot","Number of Beds = 257" ))
        list.add(Model("Ballari","District Hospital","Modaliar DH Rajkumar Road, Sangam Circle","Number of Beds = 210"))
        list.add(Model("Bangalore","RR Medical College","Kengeri, Bengaluru","Number of Beds = 800"))
        list.add(Model("Bangalore","Victoria Hospital","BMCRI Fort Road near city market, Bengaluru","Number of Beds = 900"))
        list.add(Model("Davangere","Chigateri Hospital","PJ Extension, Shamnur Road, Davangere","Number of Beds = 930"))
        list.add(Model("Gadag","GIMS","Mallasamudra Mulagund Road Gadag","Number of Beds = 250"))
        list.add(Model("Hassan","HIMS","City centre, Hassan","Number of Beds = 750"))
        list.add(Model("Kodagu","KIMS, Kodagu","Near Toll Gate, Kodagu","Number of Beds = 300"))
        list.add(Model("Mysore","District Hospital","Ed Hospital Peremises, Metgalli, Mysore","Number of Beds = 300"))



        listview.adapter = MyListAdapter(this, R.layout.hospitals, list)
        listview.setOnItemClickListener { parent, view, position, id -> }
    }
}