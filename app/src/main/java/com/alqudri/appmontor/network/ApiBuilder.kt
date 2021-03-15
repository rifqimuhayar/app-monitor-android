package com.alqudri.appmontor.network


import android.annotation.SuppressLint
import com.alqudri.appmontor.helper.Static
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiBuilder {
    lateinit var request: Request
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    val headerInterceptor = object : Interceptor {
        @SuppressLint("ConstantLocale")
        override fun intercept(chain: Interceptor.Chain): Response {
            request = chain.request()

            request = request.newBuilder().addHeader("h", "sk").build()

            val response = chain.proceed(request)

            return response
        }
    }

    private val okhttp = OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)

    private val builder = Retrofit.Builder().baseUrl(Static.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T{
        return retrofit.create(serviceType)
    }

}