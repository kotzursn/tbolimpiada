package com.example.myapplication.classes

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ItemActivity
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class CustomRecyclerAdapter(private val data: ArrayList<HashMap<String, String>>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgV: ImageView = itemView.findViewById(R.id.imgItemLogo)
        val tvName: TextView = itemView.findViewById(R.id.tvItemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //стоит переписать..
        var item = holder.itemView
        item.setOnClickListener(){
            val activity = item.context as Activity
            val intent = Intent(activity, ItemActivity::class.java)

            intent.putExtra("name", data[position]["name"])
            intent.putExtra("description", data[position]["description"])
            intent.putExtra("icon_url", data[position]["icon_url"])
            intent.putExtra("service_url", data[position]["service_url"])

            activity!!.startActivity(intent)
        }

        holder.tvName.text = data[position]["name"]
        Picasso.get()
            .load(data[position]["icon_url"])
            .placeholder(R.drawable.icon_placeholder) // заглушка
            .error(R.drawable.icon_error) // заглушка для ошибки
            .into(holder.imgV)
    }


    override fun getItemCount() = data.size


}