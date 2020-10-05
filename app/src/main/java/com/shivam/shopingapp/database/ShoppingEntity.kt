package com.shivam.shopingapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping")
data class ShoppingEntity(@ColumnInfo(name = "name")val name:String
,@ColumnInfo(name="amount") var amount:Int


)
{
    @PrimaryKey(autoGenerate = true)var id:Int=0
}

