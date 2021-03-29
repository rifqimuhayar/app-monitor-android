package com.alqudri.appmontor.ui.systeminfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alqudri.appmontor.model.ossystem.OsSystem
import com.alqudri.appmontor.network.ApiBuilder
import com.alqudri.appmontor.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SystemInfoViewModel : ViewModel(){
    private val request = ApiBuilder.buildService(Service::class.java)
    private val _listSystemInfo = MutableLiveData<OsSystem>()
    val listSystemInfo: LiveData<OsSystem> get() = _listSystemInfo

    fun getSystemInfo(){
        val requestData = request.getSystemInfo()
        requestData.enqueue(object : Callback<OsSystem>{
            override fun onFailure(call: Call<OsSystem>, t: Throwable) {
                Log.d("fucky", ""+t.message)
            }

            override fun onResponse(call: Call<OsSystem>, response: Response<OsSystem>) {
                Log.d("fuckyy", ""+response.message())
                if(response.isSuccessful){
                    _listSystemInfo.postValue(response.body())
                }
            }

        })
    }
}