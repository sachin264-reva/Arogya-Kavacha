package com.example.health

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_msr.*

class MsrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msr)

        location.setOnClickListener{
            var loc = Intent(Intent.ACTION_VIEW, Uri.parse("geo:13.027086,77.57174,16z"))
            startActivity(loc)
        }
        email.setOnClickListener{
            var mail = Intent(Intent.ACTION_VIEW)
        }
        call.setOnClickListener{
            var call = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08023608888"))
            startActivity(call)
        }

        surgical.setOnClickListener {
            val popMenu = PopupMenu(this,surgical)
            popMenu.menuInflater.inflate(R.menu.menu_pop,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                when(item!!.itemId){
                    R.id.generalSurgery -> Toast.makeText(this@MsrActivity,"General Surgery",Toast.LENGTH_SHORT).show()
                    R.id.neuroSurgery -> Toast.makeText(this@MsrActivity,"Neuro Surgery",Toast.LENGTH_SHORT).show()
                    R.id.dentalSurgery -> Toast.makeText(this@MsrActivity,"Dental Surgery",Toast.LENGTH_SHORT).show()
                    R.id.orthopedics -> Toast.makeText(this@MsrActivity,"Orthopedics",Toast.LENGTH_SHORT).show()
                    R.id.plasticSurgery -> Toast.makeText(this@MsrActivity,"Plastic Surgery",Toast.LENGTH_SHORT).show()
                }
                    return true
            }
            })
            popMenu.show()
        }

        medical.setOnClickListener {
            val popMenu = PopupMenu(this,medical)
            popMenu.menuInflater.inflate(R.menu.menu_pop2,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.generalMedicine -> Toast.makeText(this@MsrActivity,"General Medicine",Toast.LENGTH_SHORT).show()
                        R.id.respiratoryMedicine -> Toast.makeText(this@MsrActivity,"Respiratory Medicine",Toast.LENGTH_SHORT).show()
                        R.id.paediatrics -> Toast.makeText(this@MsrActivity,"Paediatrics",Toast.LENGTH_SHORT).show()
                        R.id.radiology -> Toast.makeText(this@MsrActivity,"Radiology",Toast.LENGTH_SHORT).show()
                        R.id.dermatology -> Toast.makeText(this@MsrActivity,"Dermatology",Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }

        superSpecial.setOnClickListener {
            val popMenu = PopupMenu(this,superSpecial)
            popMenu.menuInflater.inflate(R.menu.menu_pop3,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.cardiology -> Toast.makeText(this@MsrActivity,"Cardiology",Toast.LENGTH_SHORT).show()
                        R.id.urology -> Toast.makeText(this@MsrActivity,"Urology",Toast.LENGTH_SHORT).show()
                        R.id.endocrinology -> Toast.makeText(this@MsrActivity,"Endocrinology",Toast.LENGTH_SHORT).show()
                        R.id.oncology -> Toast.makeText(this@MsrActivity,"Oncology",Toast.LENGTH_SHORT).show()
                        R.id.neurology -> Toast.makeText(this@MsrActivity,"Neurology",Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }



    }
}

//add scroll view
//facilities available in bullet points
//mail function