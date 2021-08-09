package com.alqudri.appmontor.ui.log

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alqudri.appmontor.R
import com.alqudri.appmontor.adapter.LogListAdapter
import com.alqudri.appmontor.model.log.DataItem
import com.alqudri.appmontor.utill.hideView
import kotlinx.android.synthetic.main.activity_log.*
import kotlinx.android.synthetic.main.activity_log_list_actvity.*
import kotlinx.android.synthetic.main.activity_log_list_actvity.rv_log

class LogListActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_list_actvity)

        val logViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(LogViewModel::class.java)

        logViewModel.getLogList()

        with(logViewModel) {
            listLog.observe(this@LogListActvity, Observer {
                rv_log.layoutManager = LinearLayoutManager(this@LogListActvity)
                rv_log.adapter = LogListAdapter(it.data as List<DataItem>)
                lay_lis.hideView(false)
                pg_list.hideView(true)
            })
            error.observe(this@LogListActvity, Observer {
                pg_list.hideView(true)
                Toast.makeText(this@LogListActvity, it, Toast.LENGTH_SHORT).show()
                finish()
            })
        }
    }
}