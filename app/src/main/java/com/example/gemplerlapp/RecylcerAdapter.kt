package com.example.gemplerlapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class RecylcerAdapter(private val serviceList: ArrayList<ServiceInfo>) :
    RecyclerView.Adapter<RecylcerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){

        val currentItem = serviceList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.serviceHeading.text = currentItem.heading.toString()

    }

    override fun getItemCount(): Int {

        return serviceList.size

    }

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val serviceHeading: TextView = itemView.findViewById(R.id.serviceHeading)


    }
}