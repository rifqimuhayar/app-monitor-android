package com.alqudri.appmontor.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.appmontor.R
import com.alqudri.appmontor.model.log.DataItem
import com.alqudri.appmontor.ui.log.LogActivity
import kotlinx.android.synthetic.main.content_process.view.*
import java.util.*

class LogListAdapter(var dataItem: List<DataItem>) : RecyclerView.Adapter<LogListAdapter.ViewHolder>(){
    inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: DataItem){
            val date = Date()
            val fullName = data.fileName +"."+data.fileType
            date.time = data.lastTimeModified!!.toLong()
            view.nama.text = data.fileName
            view.size.text = "Size : "+(data.fileSize?.div(1000)) +" Kb"
            view.last.text = "Last Modified : "+date.year +"/"+ date.month +"/"+ date.date +"|"+ date.hours +"-"+ date.minutes +"-"+ date.seconds

            view.content_view.setOnClickListener {
                val intent = Intent(view.context, LogActivity::class.java)
                intent.putExtra("mode", fullName)
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_process, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(dataItem.get(position))
    }

}