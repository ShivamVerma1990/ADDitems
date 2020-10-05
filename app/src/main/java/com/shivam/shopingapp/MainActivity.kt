package com.shivam.shopingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivam.shopingapp.database.ShoppingDatabase
import com.shivam.shopingapp.database.ShoppingEntity
import com.shivam.shopingapp.database.module.Repositories
import com.shivam.shopingapp.database.module.ShoppingViewModel
import com.shivam.shopingapp.database.module.ViewModelRepositories
import com.shivam.shopingapp.utill.AddDialog
import com.shivam.shopingapp.utill.AddListener
import com.shivam.shopingapp.utill.RecyclerDashboard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database=ShoppingDatabase(this)
        val repositories=Repositories(database)
        val factory=ViewModelRepositories(repositories )
       val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)
        val adapter=RecyclerDashboard(listOf(),viewModel)

        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=adapter
viewModel.getAll().observe(this, Observer {
    adapter.item=it
adapter.notifyDataSetChanged()
})
floatAdd.setOnClickListener{
    AddDialog(this,object :AddListener{
        override fun onAddClickButton(shoppingEntity: ShoppingEntity) {

        viewModel.insert(shoppingEntity)

        }

    }).show()
}


    }


}
