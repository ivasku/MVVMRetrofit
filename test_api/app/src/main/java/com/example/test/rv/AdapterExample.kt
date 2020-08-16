package com.example.test.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.models.User
import kotlinx.android.synthetic.main.item.view.*

class AdapterExample (val data: List<User>) : RecyclerView.Adapter<AdapterExample.ExampleViewHolder>() {


    class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val button: Button = itemView.button
        val text: TextView = itemView.textView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = data[position]

        holder.button.text = currentItem.username
        holder.text.text = currentItem.adress.suite
    }


}