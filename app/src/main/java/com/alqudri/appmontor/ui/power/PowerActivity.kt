package com.alqudri.appmontor.ui.power

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alqudri.appmontor.R
import com.alqudri.appmontor.ui.log.LogViewModel
import com.alqudri.appmontor.utill.hideView
import kotlinx.android.synthetic.main.activity_power.*

class PowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_power)

        val powerViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(PowerViewModel::class.java)


        cardView2.setOnClickListener {
            powerViewModel.restart()
        }

        cardView.setOnClickListener {
            powerViewModel.shutdown()
        }
        with(powerViewModel){
            restart.observe(this@PowerActivity, Observer {
                Log.d("wtf", "sdjhsd")
            })

            shutdown.observe(this@PowerActivity, Observer {
                Log.d("wtf", "sdjhsd")
            })
        }
    }



    override fun onPause() {
        super.onPause()
        Log.d("asasa", "pause")
        v.hideView(false)
//        data_table.hideView(true)
    }

    override fun onResume() {
        super.onResume()
        Log.d("asasa", "resume")
        v.hideView(true)
//        data_table.hideView(false)
    }
}