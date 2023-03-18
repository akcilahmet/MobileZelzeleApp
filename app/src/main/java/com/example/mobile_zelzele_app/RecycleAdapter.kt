package com.example.mobile_zelzele_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_zelzele_app.util.DateUtil


class RecycleAdapter(internal var context: Context,private var newsList:List<News>) :RecyclerView.Adapter<RecycleAdapter.ZelzeleVH>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZelzeleVH {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return ZelzeleVH(itemView)
    }

    override fun onBindViewHolder(holder: ZelzeleVH, position: Int) {
        holder.recyclerViewCityName.text=newsList[position].cityName
        holder.recyclerViewCityDistrictName.text=newsList[position].districtName
        holder.recyclerViewMagnitude.text=newsList[position].magnitude.toString()
        holder.recyclerViewDepth.text=newsList[position].depth.toString()+"km"

        holder.recyclerViewTime.text=DateUtil.formatDateTime(newsList[position].time)

        val floatValue=newsList[position].magnitude.toFloat()
        val color = when {
            floatValue >= 4 -> ContextCompat.getColor(holder.itemView.context, R.color.red)
            floatValue >= 2 -> ContextCompat.getColor(holder.itemView.context, R.color.orange)
            floatValue >= 1 -> ContextCompat.getColor(holder.itemView.context, R.color.yellow)
            else -> R.color.yellow
        }
        holder.setColor(color)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun updateData(newData: List<News>) {
        newsList = newData
        notifyDataSetChanged() // Verilerin güncellendiğini bildirir
    }

    class ZelzeleVH(itemView:View):RecyclerView.ViewHolder(itemView) {
        val recyclerViewCityName: TextView = itemView.findViewById(R.id.cityName)
        val recyclerViewCityDistrictName: TextView = itemView.findViewById(R.id.cityDistrictName)
        val recyclerViewMagnitude: TextView = itemView.findViewById(R.id.magnitude)
        val recyclerViewDepth: TextView = itemView.findViewById(R.id.depth)
        val recyclerViewTime: TextView = itemView.findViewById(R.id.time)
        private val linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)

        fun setColor(color: Int) {
            linearLayout.setBackgroundColor(color)
        }

    }


}