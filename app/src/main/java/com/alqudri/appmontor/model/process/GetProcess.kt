package com.alqudri.appmontor.model.process

import com.google.gson.annotations.SerializedName

data class GetProcess(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class DataItem(

	@field:SerializedName("image_name")
	val imageName: String? = null,

	@field:SerializedName("session_name")
	val sessionName: String? = null,

	@field:SerializedName("memory")
	val memory: String? = null,

	@field:SerializedName("session")
	val session: String? = null,

	@field:SerializedName("pid")
	val pid: String? = null
)
