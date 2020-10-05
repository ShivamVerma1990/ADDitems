package com.shivam.shopingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [ShoppingEntity::class],version = 1)
abstract class ShoppingDatabase:RoomDatabase() {
abstract fun getDao():ShoppingDao
companion object {
    @Volatile
    private var instance:ShoppingDatabase?=null
private val Lock=Any()
operator fun invoke(context: Context)= instance?: synchronized(Lock){
instance?: buildDatabase(context).also {
    instance=it
}

    }
private fun buildDatabase(context: Context)= Room.databaseBuilder(context.applicationContext,ShoppingDatabase::class.java,"res_db").build()


}



}