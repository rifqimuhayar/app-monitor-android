package com.alqudri.appmontor.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.appmontor.R
import kotlinx.android.synthetic.main.content_component.view.*

class ComponentAdapter(var listData: List<String>) : RecyclerView.Adapter<ComponentAdapter.ViewHolder>(){
   inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: String){
            view.nama.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_component, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(listData.get(position))
    }

}