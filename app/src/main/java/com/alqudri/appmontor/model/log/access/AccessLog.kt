package com.alqudri.appmontor.model.log.access

import com.google.gson.annotations.SerializedName

data class AccessLog(

	@field:SerializedName("data")
	val data: List<List<String>?>? = null
)
