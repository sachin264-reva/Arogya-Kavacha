package com.example.health

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import java.util.regex.Pattern

class registerActivity : AppCompatActivity() {

    companion object {
        var confirmPass: String = ""
        var EditTextEmptyHolder: Boolean = false
        var password: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        textview_login.setOnClickListener() {
            var login = Intent(this, MainActivity::class.java)
            startActivity(login)
        }

        btn_register.setOnClickListener() {
            checkEditBox()
            insertCredentials()
        }
    }

    fun checkEditBox()
    {
        val email = edit_email.text.toString()
        password = edit_password.text.toString()
        confirmPass = edit_confirmpassword.text.toString()

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ||  TextUtils.isEmpty(confirmPass))
        {
            EditTextEmptyHolder = false
        }
        else
        {
            EditTextEmptyHolder = true
        }
    }

    fun validEmail(email : String):Boolean
    {
        val email_pattern = "^[_A-Za-z0-9-]+(\\.[_A-za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern : Pattern = Pattern.compile(email_pattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    private fun insertCredentials()
    {
        val email = edit_email.text.toString()
        val password = edit_password.text.toString()
        val confirmPassword = edit_confirmpassword.text.toString()

        if(EditTextEmptyHolder)
        {
            if(!validEmail(email))
            {
                edit_email.error = "Invalid ID"
            }
            else if(!(password==confirmPassword))
            {
                edit_confirmpassword.error = "Password Doesn't Match"
            }
            else
            {
//                insertData()
                checkExistence(email,password)
            }
        }
        else
        {
            Toast.makeText(applicationContext,"Please Fill All The Fields", Toast.LENGTH_SHORT).show()
        }

    }

//    private fun insertData()
//    {
//        val email = edit_email.text.toString()
//        password = edit_password.text.toString()
//        var helper = DataBaseHelper(applicationContext)
//        val result: Boolean = helper.insertData(email,password)
//        when
//        {
//             result -> Toast.makeText(applicationContext,"Registered Successfully",Toast.LENGTH_SHORT).show()
//             else -> Toast.makeText(applicationContext,"Registration Failed",Toast.LENGTH_SHORT).show()
//        }
//    }

    fun checkExistence(email:String , password:String)
    {
        var helper = DataBaseHelper(applicationContext)

        if (helper.checkEmail(email))
        {
            Toast.makeText(applicationContext, "Email already exists", Toast.LENGTH_LONG).show()
        }
        else
        {
            insertData(email,password)
        }
    }

    private fun insertData(email:String , password:String)
    {
        var helper = DataBaseHelper(applicationContext)
        val result: Boolean = helper.insertData(email,password)
        when
        {
             result -> Toast.makeText(applicationContext,"Registered Successfully",Toast.LENGTH_SHORT).show()
             else -> Toast.makeText(applicationContext,"Registration Failed",Toast.LENGTH_SHORT).show()
        }
    }
}