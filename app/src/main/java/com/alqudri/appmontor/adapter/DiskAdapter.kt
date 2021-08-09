package com.alqudri.appmontor.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.appmontor.R
import com.alqudri.appmontor.model.ossystem.DiskDrive
import kotlinx.android.synthetic.main.item_disk_drive.view.*

class DiskAdapter(var listData: List<DiskDrive>) : RecyclerView.Adapter<DiskAdapter.ViewHolder>(){
    inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: DiskDrive){
            val free = data.free!!.toInt() / 1000000000
            val total = data.total!!.toInt() / 1000000000
            val percentage = free/total
            view.diskName.text = data.name
            view.pg_disk.setProgress(percentage, true)
            view.disk.text = "$total GB"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_disk_drive, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(listData.get(position))
    }

}