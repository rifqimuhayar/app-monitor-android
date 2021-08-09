package com.alqudri.appmontor.ui.power

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
            lay_lin.hideView(true)
            pg_power.hideView(false)
        }

        lay_lin.hideView(false)
        pg_power.hideView(true)
        cardView.setOnClickListener {
            powerViewModel.shutdown()
            lay_lin.hideView(true)
            pg_power.hideView(false)
        }
        with(powerViewModel){
            restart.observe(this@PowerActivity, Observer {
                Log.d("wtf", "sdjhsd")
                Toast.makeText(this@PowerActivity, it.message, Toast.LENGTH_SHORT).show()

                lay_lin.hideView(false)
            })

            shutdown.observe(this@PowerActivity, Observer {
                Log.d("wtf", "sdjhsd")
                Toast.makeText(this@PowerActivity, it.message, Toast.LENGTH_SHORT).show()
                lay_lin.hideView(false)
                pg_power.hideView(true)
            })
            error.observe(this@PowerActivity, Observer {
                pg_power.hideView(true)
                Toast.makeText(this@PowerActivity, it, Toast.LENGTH_SHORT).show()
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