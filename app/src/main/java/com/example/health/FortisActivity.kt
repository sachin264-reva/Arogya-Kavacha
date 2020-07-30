package com.example.health

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_apollo.*
import kotlinx.android.synthetic.main.activity_fortis.*

class FortisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fortis)

        locationFortis.setOnClickListener{
            var loc = Intent(Intent.ACTION_VIEW, Uri.parse("geo:12.9883,77.5944"))
            startActivity(loc)
        }
        emailFortis.setOnClickListener{
            var mail = Intent(Intent.ACTION_SEND, Uri.parse("mailto:reachus@fortishealthcare.com"))
            startActivity(mail)
        }
        callFortis.setOnClickListener{
            var call = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+91 124 4921021"))
            startActivity(call)
        }

        CardiacFortis.setOnClickListener {
            val popMenu = PopupMenu(this,CardiacFortis)
            popMenu.menuInflater.inflate(R.menu.fortis_pop1,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.adfortis -> Toast.makeText(this@FortisActivity,"Adult CTVS", Toast.LENGTH_SHORT).show()
                        R.id.paeFortis -> Toast.makeText(this@FortisActivity,"Paediatrics CTVS", Toast.LENGTH_SHORT).show()
                        R.id.interfortis -> Toast.makeText(this@FortisActivity,"Interventional Cardiology", Toast.LENGTH_SHORT).show()
                        R.id.invasiveFortis -> Toast.makeText(this@FortisActivity,"Invasive Cardiology", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }

        DiaFortis.setOnClickListener {
            val popMenu = PopupMenu(this,DiaFortis)
            popMenu.menuInflater.inflate(R.menu.fortis_pop2,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.metafortis -> Toast.makeText(this@FortisActivity,"Metabolic Surgery", Toast.LENGTH_SHORT).show()
                        R.id.footfortis -> Toast.makeText(this@FortisActivity,"Diabetic Footcare", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }

        PaediaFortis.setOnClickListener {
            val popMenu = PopupMenu(this,PaediaFortis)
            popMenu.menuInflater.inflate(R.menu.fortis_pop3,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.paeOnco -> Toast.makeText(this@FortisActivity,"Paediatrics Oncology", Toast.LENGTH_SHORT).show()
                        R.id.paeEndo -> Toast.makeText(this@FortisActivity,"Paediatrics Endocrinology", Toast.LENGTH_SHORT).show()
                        R.id.neoFortis -> Toast.makeText(this@FortisActivity,"Neonatology", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }

        TransFortis.setOnClickListener {
            val popMenu = PopupMenu(this,TransFortis)
            popMenu.menuInflater.inflate(R.menu.fortis_pop4,popMenu.menu)
            popMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?):Boolean{
                    when(item!!.itemId){
                        R.id.bmt -> Toast.makeText(this@FortisActivity,"Bone Marrow Transplant", Toast.LENGTH_SHORT).show()
                        R.id.kt -> Toast.makeText(this@FortisActivity,"Kidney Transplant", Toast.LENGTH_SHORT).show()
                        R.id.ht -> Toast.makeText(this@FortisActivity,"Heart Transplant", Toast.LENGTH_SHORT).show()
                        R.id.lt -> Toast.makeText(this@FortisActivity,"Liver Transplant", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popMenu.show()
        }
    }
}