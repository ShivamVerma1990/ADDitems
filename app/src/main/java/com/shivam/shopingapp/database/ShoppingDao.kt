package com.shivam.shopingapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao
{
@Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insert(shoppingEntity:ShoppingEntity)
@Delete
    suspend fun delete(shoppingEntity: ShoppingEntity)
@Query("SELECT*FROM shopping")
    fun getAll():LiveData<List<ShoppingEntity>>
}