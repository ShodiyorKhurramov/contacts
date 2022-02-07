package com.example.contacts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.model.Item

class Adapter(var context: Context, var items : ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_cpntacts,parent,false)
        return  MemberVievHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item=items[position]
        if(holder is MemberVievHolder){
//            val number=holder.number
            val name=holder.name

            name.text=item.name
//            number.text=item.number

        }
    }
    class MemberVievHolder(view : View) :RecyclerView.ViewHolder(view){
        var name :  TextView
//        var number :TextView


        init {
//          number=view.findViewById(R.id.number)
            name=view.findViewById(R.id.name)
        }

    }
}