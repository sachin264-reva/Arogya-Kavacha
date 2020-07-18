package com.example.health

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    companion object
    {
        var EditTextEmptyHolder : Boolean = false
        var password: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview_register.setOnClickListener()
        {
            var registration = Intent(this, registerActivity::class.java)
            startActivity(registration)
        }

        btn_login.setOnClickListener()
        {
            checkEditBox()
            login()
        }
    }

    fun checkEditBox()
    {
        val email = edittext_username.text.toString()
        password = edittext_password.text.toString()

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
        {
            EditTextEmptyHolder = false
        }
        else
        {
            EditTextEmptyHolder = true
        }
    }

    fun login()
    {

        val email = edittext_username.text.toString()
        val password = edittext_password.text.toString()

        if (EditTextEmptyHolder)
        {
            if (!validEmail(email))
            {
                edittext_username.error = "Invalid Email"
            }
            else
            {
                var helper = DataBaseHelper(applicationContext)

                if (helper.checkUserLogin(email, password))
                {
                    var log = Intent(this,searchActivity::class.java)
                    startActivity(log)
                }
                else
                {
                    Toast.makeText(applicationContext, "Wrong Username or Password", Toast.LENGTH_LONG).show()
                }
            }
        }
        else
        {
            Toast.makeText(this,"Please enter email or password", Toast.LENGTH_LONG).show()
        }
    }

    fun validEmail(email: String): Boolean
    {
        val email_pattern = "^[_A-Za-z0-9-]+(\\.[_A-za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern : Pattern = Pattern.compile(email_pattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

}