package com.example.mobile_zelzele_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(internal var context: Context,private var newsList:List<News>) :RecyclerView.Adapter<RecycleAdapter.ZelzeleVH>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZelzeleVH {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return ZelzeleVH(itemView)
    }

    override fun onBindViewHolder(holder: ZelzeleVH, position: Int) {
        holder.recyclerViewCityName.text=newsList[position].cityName
        holder.recyclerViewCityDistrictName.text=newsList[position].districtName
        holder.recyclerViewMagnitude.text=newsList[position].magnitude
        holder.recyclerViewDepth.text=newsList[position].depth
        holder.recyclerViewTime.text=newsList[position].time
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class ZelzeleVH(itemView:View):RecyclerView.ViewHolder(itemView) {
        val recyclerViewCityName: TextView = itemView.findViewById(R.id.cityName)
        val recyclerViewCityDistrictName: TextView = itemView.findViewById(R.id.cityDistrictName)
        val recyclerViewMagnitude: TextView = itemView.findViewById(R.id.magnitude)
        val recyclerViewDepth: TextView = itemView.findViewById(R.id.depth)
        val recyclerViewTime: TextView = itemView.findViewById(R.id.time)
    }


}