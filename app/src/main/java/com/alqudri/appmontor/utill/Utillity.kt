package com.alqudri.appmontor.utill

import android.view.View

fun View.hideView(state: Boolean){
    if(state){
        this.visibility = View.GONE
    }else{
        this.visibility = View.VISIBLE
    }
}