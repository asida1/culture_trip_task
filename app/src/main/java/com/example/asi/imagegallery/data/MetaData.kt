package com.example.asi.imagegallery.data
import com.google.gson.annotations.SerializedName


data class MetaData (

	@SerializedName("creationTime") val creationTime : String?,
	@SerializedName("updateTime") val updateTime : String?
)