package com.shivam.shopingapp.database.module

import androidx.lifecycle.ViewModel
import com.shivam.shopingapp.database.ShoppingEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repositories: Repositories):ViewModel()
{
fun insert(shoppingEntity: ShoppingEntity)= CoroutineScope(Dispatchers.Main).launch {
    repositories.insert(shoppingEntity)
}
fun delete(shoppingEntity: ShoppingEntity)= CoroutineScope(Dispatchers.Main).launch {
    repositories.delete(shoppingEntity)
}
fun getAll()=repositories.getAll()
}