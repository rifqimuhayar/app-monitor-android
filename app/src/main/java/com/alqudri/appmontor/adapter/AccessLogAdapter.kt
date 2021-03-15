package com.alqudri.appmontor.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.appmontor.R
import com.alqudri.appmontor.helper.Static
import kotlinx.android.synthetic.main.content_detail_log.view.*
import kotlinx.android.synthetic.main.content_log_error.view.*

class AccessLogAdapter(var dataItem: List<List<String>>, var mode: String) : RecyclerView.Adapter<AccessLogAdapter.ViewHolder>(){
   lateinit var view: View
    inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: List<String>){
            when(mode){
                Static.ACCESS_LOG ->{
                    view.ip.text = data.get(1)
                    view.acces_time.text = data.get(4)
                    view.type_request.text = data.get(5)
                    view.access_url.text = data.get(6)
                    view.response_code.text = "Response Code : "+data.get(8)
                }

                Static.ERROR_LOG ->{
                    view.acces_time_error.text = data.get(1)
                    view.case_time.text = data.get(2)
                    view.pid_loc.text = data.get(3)
                    view.message.text = data.get(4)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        when(mode){
            Static.ACCESS_LOG ->{
                view = LayoutInflater.from(parent.context).inflate(R.layout.content_detail_log, parent, false)
            }

            Static.ERROR_LOG ->{
                view = LayoutInflater.from(parent.context).inflate(R.layout.content_log_error, parent, false)
            }
        }
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataItem.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(dataItem.get(position))
    }

}