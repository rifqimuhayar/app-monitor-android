package com.alqudri.appmontor.ui.log

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alqudri.appmontor.R
import com.alqudri.appmontor.adapter.AccessLogAdapter
import com.alqudri.appmontor.helper.Static
import com.alqudri.appmontor.utill.hideView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_log.*

class LogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        val logViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(LogViewModel::class.java)

        val mode = intent.getStringExtra("mode")
        mode?.let { logViewModel.getAccess(it) }
        name_app.text = mode
        when (mode) {
            Static.ERROR_LOG -> {
                mode?.let { logViewModel.getAccess(it) }
            }

            Static.ACCESS_LOG -> {
                mode?.let { logViewModel.getAccess(it) }
            }

            else -> {
                mode?.let { logViewModel.getNonParse(it) }
            }
        }

        with(logViewModel) {
            listAcces.observe(this@LogActivity, Observer {
                val gson = Gson()
                when (mode) {
                    Static.ERROR_LOG -> {
                        rv_log.layoutManager = LinearLayoutManager(this@LogActivity)
                        rv_log.adapter =
                            AccessLogAdapter(it.data as List<List<String>>, Static.ERROR_LOG)
                    }

                    Static.ACCESS_LOG -> {
                        rv_log.layoutManager = LinearLayoutManager(this@LogActivity)
                        rv_log.adapter =
                            AccessLogAdapter(it.data as List<List<String>>, Static.ACCESS_LOG)
                    }
                }
                Log.d("ahajs", gson.toJson(it))
            })

            listNonParse.observe(this@LogActivity, Observer {
                rv_log.hideView(true)
                content_hide.hideView(false)
                Log.d("ahajs", "gson.toJson(it)")
                non_parse_message.text = it.data?.get(0)?.get(0)
            })
        }

    }
}