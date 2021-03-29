package com.alqudri.appmontor.model.power

import com.google.gson.annotations.SerializedName

data class Power(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)
