package com.rohan.rohan_pal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rohan.rohan_pal.database.ProjectList


class HomeRecyclerAdapter(val context: Context, val itemList: ArrayList<ProjectList>): RecyclerView.Adapter<HomeRecyclerAdapter.recycleViewHolder> () {
    class recycleViewHolder(view: View):RecyclerView.ViewHolder(view){
     val itemName:TextView = view.findViewById(R.id.txt_homes_row)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recycleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_singlerow,parent, false)
        return recycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: recycleViewHolder, position: Int) {
         val  ids  = itemList[position]
        holder.itemName.text = ids.idList
    }

    override fun getItemCount(): Int {
return itemList.size
    }
}