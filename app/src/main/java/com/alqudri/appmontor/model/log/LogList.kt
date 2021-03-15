package com.alqudri.appmontor.model.log

import com.google.gson.annotations.SerializedName

data class LogList(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class DataItem(

	@field:SerializedName("last_time_modified")
	val lastTimeModified: Int? = null,

	@field:SerializedName("file_name")
	val fileName: String? = null,

	@field:SerializedName("file_type")
	val fileType: String? = null,

	@field:SerializedName("file_size")
	val fileSize: Int? = null
)
