package com.alqudri.appmontor.ui.log

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alqudri.appmontor.R
import com.alqudri.appmontor.adapter.LogListAdapter
import com.alqudri.appmontor.model.log.DataItem
import kotlinx.android.synthetic.main.activity_log_list_actvity.*

class LogListActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_list_actvity)

        val logViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(LogViewModel::class.java)

        logViewModel.getLogList()

        logViewModel.listLog.observe(this, Observer {
            rv_log.layoutManager = LinearLayoutManager(this)
            rv_log.adapter = LogListAdapter(it.data as List<DataItem>)
        })
    }
}