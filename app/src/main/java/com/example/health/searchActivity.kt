package com.example.health

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search.*

class searchActivity : AppCompatActivity() {

    lateinit var mAlertButton : Button
    val specializations = arrayOf("Cardiology","Oncology","Neurology","Urology","Gynaelogy") //,"Corneal Replacement","Endocrinology","General Surgery","IVF","Neonatology","Neuro Modulation","Neurosurgery","Orthopedics")
    var checkedItem = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        hospitals.setOnClickListener()
        {
            var shift = Intent(this,MainActivity2::class.java)
            startActivity(shift)
        }


        mAlertButton = findViewById(R.id.specialisation)
        mAlertButton.setOnClickListener {
            val mAlterDialogBuilder = AlertDialog.Builder(this@searchActivity)
            mAlterDialogBuilder.setTitle("Select...")
            mAlterDialogBuilder.setCancelable(false)
            mAlterDialogBuilder.setSingleChoiceItems(specializations,checkedItem){dialog, which ->
                when(which){
                    which -> {
                        Toast.makeText(this,specializations[which],Toast.LENGTH_SHORT).show()
                    }
                }
            }

            mAlterDialogBuilder.setPositiveButton("Yes"){_, _->
                //finish()
                var shift2 = Intent(this,MsrActivity::class.java)
                startActivity(shift2)
            }
            mAlterDialogBuilder.setNegativeButton("NO"){_,_ ->
                //Toast.makeText(this,"Clicked No Buttoon",Toast.LENGTH_LONG).show()
            }
            mAlterDialogBuilder.setNeutralButton("Cancel"){_,_ ->
                //Toast.makeText(this,"Clicked cancel button",Toast.LENGTH_LONG).show()
            }

            val mAlertDialog = mAlterDialogBuilder.create()
            mAlertDialog.show()
        }

    }

}