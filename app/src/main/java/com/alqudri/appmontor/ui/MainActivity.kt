package com.alqudri.appmontor.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alqudri.appmontor.R
import com.alqudri.appmontor.ui.log.LogActivity
import com.alqudri.appmontor.ui.log.LogListActvity
import com.alqudri.appmontor.ui.power.PowerActivity
import com.alqudri.appmontor.ui.process.ProcessActivity
import com.alqudri.appmontor.ui.systeminfo.InfoActvity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        server.setOnClickListener {
            startActivity(Intent(this, PowerActivity::class.java))
        }
        
        log.setOnClickListener {
            startActivity(Intent(this, LogListActvity::class.java))
        }

        proses.setOnClickListener {
            startActivity(Intent(this, ProcessActivity::class.java))
        }

        systemInfo.setOnClickListener {
            startActivity(Intent(this, InfoActvity::class.java))
        }
    }
//    @Com
}

