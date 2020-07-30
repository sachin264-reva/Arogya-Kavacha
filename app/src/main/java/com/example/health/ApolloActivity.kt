package com.example.health

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_apollo.*
import kotlinx.android.synthetic.main.activity_msr.*

class ApolloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apollo)

        locationAp.setOnClickListener{
            var loc = Intent(Intent.ACTION_VIEW, Uri.parse("geo:12.8960,77.5995"))
            startActivity(loc)
        }
        emailAp.setOnClickListener{
            var mail = Intent(Intent.ACTION_SEND, Uri.parse("mailto:pavankumar_bs@apollohospitals.com"))
            startActivity(mail)
        }
        callAp.setOnClickListener{
            var call = Intent(Intent.ACTION_DIAL, Uri.parse("tel:1860-500-1066"))
            startActivity(call)
        }

        ApMed.setOnClickListener {
            val popMenu = PopupMenu(this,ApMed)
            popMenu.menuInflater.inflate(R.menu.ap_pop1,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.generalMed -> Toast.makeText(this@ApolloActivity,"General Medicine",
                            Toast.LENGTH_SHORT).show()
                        R.id.elderlyCare -> Toast.makeText(this@ApolloActivity,"Elderly Care", Toast.LENGTH_SHORT).show()
                        R.id.renalDiseases -> Toast.makeText(this@ApolloActivity,"Renal Diseases",
                            Toast.LENGTH_SHORT).show()
                        R.id.hematology -> Toast.makeText(this@ApolloActivity,"Hematology", Toast.LENGTH_SHORT).show()
                        R.id.rheumatology -> Toast.makeText(this@ApolloActivity,"Rheumatology",
                            Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }

        ApSurg.setOnClickListener {
            val popMenu = PopupMenu(this,ApSurg)
            popMenu.menuInflater.inflate(R.menu.ap_pop2,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.colorectalSurgery -> Toast.makeText(this@ApolloActivity,"Colorectal Surgery",
                            Toast.LENGTH_SHORT).show()
                        R.id.genSurgery -> Toast.makeText(this@ApolloActivity,"General and GI Surgery",
                            Toast.LENGTH_SHORT).show()
                        R.id.uroSurgery -> Toast.makeText(this@ApolloActivity,"Urology and Andrology", Toast.LENGTH_SHORT).show()
                        R.id.vascular -> Toast.makeText(this@ApolloActivity,"Vascular and Endovascular Surgery", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }

        ApWomen.setOnClickListener {
            val popMenu = PopupMenu(this,ApWomen)
            popMenu.menuInflater.inflate(R.menu.ap_pop3,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.gynecology -> Toast.makeText(this@ApolloActivity,"Obstetrics and Gynecology", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }

        ApCos.setOnClickListener {
            val popMenu = PopupMenu(this,ApCos)
            popMenu.menuInflater.inflate(R.menu.ap_pop4,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.derma -> Toast.makeText(this@ApolloActivity,"Dermatology", Toast.LENGTH_SHORT).show()
                        R.id.plasSurgery -> Toast.makeText(this@ApolloActivity,"Plastic Surgery", Toast.LENGTH_SHORT).show()

                    }
                    return true
                }
            })
            popMenu.show()
        }
    }
}
