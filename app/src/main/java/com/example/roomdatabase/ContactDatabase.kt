package com.example.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

//database have more than one entity.Therefore we use list
@Database(entities = [Contact::class] , version = 1)
abstract class ContactDatabase : RoomDatabase(){

    //link interface ConatctDao with this database.using fununction
    abstract fun contactDao(): ContactDAO // return type is interface ContactDAO.

    //If you have more than one DAO .Then use more functions to link with database.
}