package com.alqudri.appmontor.model.log.nonparselog

import com.google.gson.annotations.SerializedName

data class NonParseLog(

	@field:SerializedName("data")
	val data: List<List<String>?>? = null
)
