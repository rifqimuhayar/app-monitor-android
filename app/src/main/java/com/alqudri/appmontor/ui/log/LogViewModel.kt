package com.alqudri.appmontor.ui.log

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alqudri.appmontor.model.log.LogList
import com.alqudri.appmontor.model.log.access.AccessLog
import com.alqudri.appmontor.model.log.nonparselog.NonParseLog
import com.alqudri.appmontor.network.ApiBuilder
import com.alqudri.appmontor.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LogViewModel : ViewModel() {
    private val request: Service = ApiBuilder.buildService(
        Service::class.java
    )
    private val _listLog = MutableLiveData<LogList>()
    val listLog: LiveData<LogList> get() = _listLog
    private val _listAccess = MutableLiveData<AccessLog>()
    val listAcces: LiveData<AccessLog> get() = _listAccess
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error


    private val _listNonParse = MutableLiveData<NonParseLog>()
    val listNonParse: LiveData<NonParseLog> get() = _listNonParse
    fun getLogList() {
        val requestData = request.getServerLog()
        requestData.enqueue(object : Callback<LogList> {
            override fun onFailure(call: Call<LogList>, t: Throwable) {
                Log.d("model",""+ t.message)
                _error.postValue(t.message)
            }

            override fun onResponse(call: Call<LogList>, response: Response<LogList>) {
                if (response.isSuccessful) {
                    Log.d("model", "sukses")
                    _listLog.postValue(response.body())
                }else{
                    Log.d("model", "ggaal")
                }
            }

        })
    }

    fun getAccess(mode: String) {
        val requestData = request.getAccess(mode)
        requestData.enqueue(object : Callback<AccessLog> {
            override fun onFailure(call: Call<AccessLog>, t: Throwable) {
                Log.d("model",""+ t.message)
                _error.postValue(t.message)
            }

            override fun onResponse(call: Call<AccessLog>, response: Response<AccessLog>) {
                if (response.isSuccessful) {
                    Log.d("model", "sukses")
                    _listAccess.postValue(response.body())
                }else{
                    Log.d("model", "ggaal")
                }
            }

        })
    }

    fun getNonParse(mode: String) {
        val requestData = request.getNonParse(mode)
        requestData.enqueue(object : Callback<NonParseLog> {
            override fun onFailure(call: Call<NonParseLog>, t: Throwable) {
                Log.d("model",""+ t.message)
                _error.postValue(t.message)
            }

            override fun onResponse(call: Call<NonParseLog>, response: Response<NonParseLog>) {
                if (response.isSuccessful) {
                    Log.d("model", "sukses")
                    _listNonParse.postValue(response.body())
                }else{
                    Log.d("model", "ggaal")
                }
            }

        })
    }
}