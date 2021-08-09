package com.alqudri.appmontor.ui.process


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alqudri.appmontor.model.process.GetProcess
import com.alqudri.appmontor.network.ApiBuilder
import com.alqudri.appmontor.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProcessViewModel : ViewModel() {
    val request: Service = ApiBuilder.buildService(
        Service::class.java
    )
    private val _listProcess = MutableLiveData<GetProcess>()
    val listProcess: LiveData<GetProcess> get() = _listProcess

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error
    fun getProcess() {
        val requestData = request.getProcess()
        requestData.enqueue(object : Callback<GetProcess> {
            override fun onFailure(call: Call<GetProcess>, t: Throwable) {
                Log.d("model",""+ t.message)
                _error.postValue(t.message)
            }

            override fun onResponse(call: Call<GetProcess>, response: Response<GetProcess>) {
                if (response.isSuccessful) {
                    Log.d("model", "sukses")
                    _listProcess.postValue(response.body())
                }else{
                    Log.d("model", "ggaal")
                }
            }

        })
    }
}