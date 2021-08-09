package com.alqudri.appmontor.ui.systeminfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alqudri.appmontor.R
import com.alqudri.appmontor.adapter.ComponentAdapter
import com.alqudri.appmontor.utill.hideView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_info_actvity.*
import kotlinx.android.synthetic.main.include_system_info.view.*

class InfoActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_actvity)
        val systemInfoViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(SystemInfoViewModel::class.java)
        val lay = findViewById<LinearLayout>(R.id.lay)
        with(systemInfoViewModel){
            getSystemInfo()
            listSystemInfo.observe(this@InfoActvity, Observer {
                val totalRam = it.totalPhysicalMemory?.replace("MB", "")?.replace(" ", "")!!.toFloat()
                val partRam = it.availablePhysicalMemory?.replace("MB", "")?.replace(" ", "")!!.toFloat()
                val percentage = (partRam/totalRam)-100F
                with(lay){
                    hostname.text = it.hostName
                    osName.text = it.oSName
                    osVersion.text = it.oSVersion
                    owner.text = it.registeredOwner
                    systemType.text = it.systemType
                    val g = Gson()
                    Log.d("fuck",""+g.toJson(it))
                    procesor.layoutManager = LinearLayoutManager(this@InfoActvity)
                    procesor.adapter = ComponentAdapter(it.processorS as List<String>)
                    hotfix.layoutManager = LinearLayoutManager(this@InfoActvity)
                    hotfix.adapter = ComponentAdapter(it.hotfixS as List<String>)
                    pg_info_pg.setProgress(percentage.toInt(), true)
                    pg_info_pg_cpu.setProgress(it.loadPercentage.toInt(), true)
                    linearLayout2.hideView(false)
                    pg_info.hideView(true)
                }
            })

            error.observe(this@InfoActvity, Observer {
                pg_info.hideView(true)
               Toast.makeText(this@InfoActvity, it, Toast.LENGTH_SHORT).show()
                finish()
            })
        }
    }
}