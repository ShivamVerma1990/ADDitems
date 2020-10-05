package com.shivam.shopingapp.utill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.shivam.shopingapp.R
import com.shivam.shopingapp.database.ShoppingEntity
import com.shivam.shopingapp.database.module.ShoppingViewModel
import kotlinx.android.synthetic.main.item_recycle.view.*

class RecyclerDashboard(var item:List<ShoppingEntity>, val viewModel:ShoppingViewModel):RecyclerView.Adapter<RecyclerDashboard.RecyclerViewHolder>() {
class RecyclerViewHolder(view: View):RecyclerView.ViewHolder(view)
{
    val txtName:TextView=view.findViewById(R.id.txtName)
val txtAmount:TextView=view.findViewById(R.id.txtAmount)
val imgAdd:ImageView=view.findViewById(R.id.imgAdd)
val imgCancel:ImageView=view.findViewById(R.id.imgCancel)
val imgDelete:ImageView=view.findViewById(R.id.imgDelete)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_recycle,parent,false)
    return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
    val cool=item[position]
    holder.txtName.text=cool.name
    holder.txtAmount.text="${cool.amount}"
   holder.imgDelete.setOnClickListener {
       viewModel.delete(cool)

   }
   holder.imgAdd.setOnClickListener{
       cool.amount++
viewModel.insert(cool)
   }
holder.imgCancel.setOnClickListener {
    cool.amount--
if(cool.amount>0)
{
    viewModel.insert(cool)
}
}

    }

}