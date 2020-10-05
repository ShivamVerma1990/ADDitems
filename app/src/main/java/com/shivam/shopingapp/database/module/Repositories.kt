package com.shivam.shopingapp.database.module

import com.shivam.shopingapp.database.ShoppingDatabase
import com.shivam.shopingapp.database.ShoppingEntity

class Repositories(val db:ShoppingDatabase) {

suspend fun insert(shoppingEntity: ShoppingEntity)= db.getDao().insert(shoppingEntity)
suspend fun delete(shoppingEntity: ShoppingEntity)=db.getDao().delete(shoppingEntity)
fun getAll()=db.getDao().getAll()

}