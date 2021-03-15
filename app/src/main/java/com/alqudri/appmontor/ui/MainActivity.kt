package com.alqudri.appmontor.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alqudri.appmontor.R
import com.alqudri.appmontor.ui.log.LogActivity
import com.alqudri.appmontor.ui.log.LogListActvity
import com.alqudri.appmontor.ui.process.ProcessActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, LogListActvity::class.java))
    }
}

