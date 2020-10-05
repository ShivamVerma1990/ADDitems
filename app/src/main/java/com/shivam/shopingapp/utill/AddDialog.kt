package com.shivam.shopingapp.utill

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.shivam.shopingapp.R
import com.shivam.shopingapp.database.ShoppingEntity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.customdialog.*

class AddDialog(context: Context, private val addListener:AddListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
setContentView(R.layout.customdialog)
    txtAdd.setOnClickListener{
        val name=etName.text.toString()
    val amount=etAmount.text.toString()
    if(name.isEmpty()||amount.isEmpty())
    {
        Toast.makeText(context,"All Field Required",Toast.LENGTH_LONG).show()


        return@setOnClickListener
    }
        val item=ShoppingEntity(name,amount.toInt()  )
        addListener.onAddClickButton(item)

        dismiss()
    }

txtCancel.setOnClickListener{
    cancel()
}

    }

}