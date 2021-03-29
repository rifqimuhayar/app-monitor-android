package com.alqudri.appmontor.ui.process

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alqudri.appmontor.R
import com.alqudri.appmontor.model.process.DataItem
import com.alqudri.appmontor.utill.hideView
import ir.androidexception.datatable.model.DataTableHeader
import ir.androidexception.datatable.model.DataTableRow
import kotlinx.android.synthetic.main.activity_process.*

class ProcessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)

        val processViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ProcessViewModel::class.java)


        val header = DataTableHeader.Builder()
            .item("Image Name", 1)
            .item("PID", 1)
            .item("Session Name", 1)
            .item("Session", 1)
            .item("Memory", 1)
            .build();

        processViewModel.getProcess()
        var rows = ArrayList<DataTableRow>();
        with(processViewModel) {
            listProcess.observe(this@ProcessActivity, Observer {
                Log.d("jjhjh", "aghsahgsas : " + it.data?.size)
                for (i in it.data!!.indices) {
                    var data = it.data.get(i)
                    var row = DataTableRow.Builder()
                        .value(data?.imageName)
                        .value(data?.pid)
                        .value(data?.sessionName)
                        .value(data?.session)
                        .value(data?.memory)
                        .build();

                    rows.add(row)
                }
                data_table.setTypeface(Typeface.SANS_SERIF);
                data_table.setHeader(header);
                data_table.setRows(rows);
                data_table.inflate(this@ProcessActivity)
            })
        }
        data_table.setTypeface(Typeface.SANS_SERIF);
        data_table.setHeader(header);
        data_table.setRows(rows);
        data_table.inflate(this)
    }



//    override fun onPause() {
//        super.onPause()
//        Log.d("asasa", "pause")
//        v.hideView(false)
//        j.hideView(true)
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("asasa", "resume")
//        v.hideView(true)
//        j.hideView(false)
//    }

}