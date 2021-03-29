package com.alqudri.appmontor.ui.power

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alqudri.appmontor.model.log.LogList
import com.alqudri.appmontor.model.log.access.AccessLog
import com.alqudri.appmontor.model.log.nonparselog.NonParseLog
import com.alqudri.appmontor.model.power.Power
import com.alqudri.appmontor.network.ApiBuilder
import com.alqudri.appmontor.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PowerViewModel : ViewModel() {
    private val request: Service = ApiBuilder.buildService(
        Service::class.java
    )
    private val _timeoutState = MutableLiveData<Boolean>()
    val listLog: LiveData<Boolean> get() = _timeoutState

    private val _restart = MutableLiveData<Power>()
    val restart: LiveData<Power> get() = _restart

    private val _koneksi = MutableLiveData<Power>()
    val koneksi: LiveData<Power> get() = _koneksi

    private val _shutdown = MutableLiveData<Power>()
    val shutdown: LiveData<Power> get() = _shutdown

    fun restart() {
        val requestData = request.restart()

        requestData.enqueue(object : Callback<Power>{
            override fun onFailure(call: Call<Power>, t: Throwable) {
                Log.d("alijs", "" + t.message)
            }

            override fun onResponse(call: Call<Power>, response: Response<Power>) {
                _restart.postValue(response.body())
            }

        })
    }

    fun cekKoneksi() {
        val requestData = request.restart()

        requestData.enqueue(object : Callback<Power>{
            override fun onFailure(call: Call<Power>, t: Throwable) {
                Log.d("alijs", "" + t.message)
            }

            override fun onResponse(call: Call<Power>, response: Response<Power>) {
                _koneksi.postValue(response.body())
            }

        })
    }

    fun shutdown() {
        val requestData = request.shutdown()

        requestData.enqueue(object : Callback<Power>{
            override fun onFailure(call: Call<Power>, t: Throwable) {
                Log.d("alijs", "" + t.message)
            }

            override fun onResponse(call: Call<Power>, response: Response<Power>) {
                _shutdown.postValue(response.body())
            }

        })
    }
}