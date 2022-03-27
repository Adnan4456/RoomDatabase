package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var  database: ContactDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext ,
            ContactDatabase::class.java,
            "contactDB").build()
        //we are calling suspend function.from coroutine to run this code in background.
         GlobalScope.launch {
             //insert record into  your database using abstract fun.
             database.contactDao().insertContact(Contact(0  , "Khan" ,"87542422"))
         }
    }

    fun getdata(v: View){
        database.contactDao().getContact().observe(this,{

            Log.d("MainActivty", it.toString())
        })
    }
}