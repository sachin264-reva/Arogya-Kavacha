package com.example.health

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context,"Health.db",null,1)
{
    companion object {

        val TABLE_NAME = "USERDATA"
        val EMAIL_COL = "USERMAIL"
        val PWD_COL = "PWD"
        val COL_ID = "USERID"
        val TABLE_NAME2 = "HOSPITALS"
        val HOSNAME_COL = "NAMES"
        val CN_COL = "CONTACT"
        val SPEC_COL= "SPECIALIZATIONS"
        val ADD_COL = "ADDRESS"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE USERDATA(USERID INTEGER PRIMARY KEY AUTOINCREMENT, USERMAIL TEXT, PWD TEXT)")
        db!!.execSQL("INSERT INTO USERDATA(USERMAIL,PWD) VALUES('test@gmail.com','test123')")
        db!!.execSQL("CREATE TABLE HOSPITALS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, NAMES TEXT, CONTACT INT,SPECIALIZATIONS TEXT,ADDRESS TEXT)")
        db!!.execSQL("INSERT INTO HOSPITALS(NAMES,CONTACT,SPECIALIZATIONS,ADDRESS) VALUES('Sapthagiri Hospitals',08028393392,'Internal Medicine','ChikkaBanavara')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME2")
    }

    fun insertData(email:String, password:String):Boolean
    {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(EMAIL_COL,email)
        contentValues.put(PWD_COL,password)
        val insert_data = db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return !insert_data.equals(-1)
    }

    fun checkUserLogin(username: String, password: String): Boolean {
        val db = this.writableDatabase
        val whereclause = "$EMAIL_COL =? and $PWD_COL=?" //<<<<<<<<<< ?'s will be replaced according to whereargs on a 1 by 1 basis
        val whereargs = arrayOf(username, password)
        val cursor: Cursor = db.query(TABLE_NAME, arrayOf(EMAIL_COL, PWD_COL), whereclause, whereargs, null, null, null)
        val count: Int = cursor.getCount()
        cursor.close()
        return count > 0
    }

    fun checkEmail(username: String): Boolean {
        val db = this.writableDatabase
        val whereclause = "$EMAIL_COL =?" //<<<<<<<<<< ?'s will be replaced according to whereargs on a 1 by 1 basis
        val whereargs = arrayOf(username)
        val cursor: Cursor = db.query(TABLE_NAME, arrayOf(EMAIL_COL), whereclause, whereargs, null, null, null)
        val count: Int = cursor.getCount()
        cursor.close()
        return count > 0
    }
}