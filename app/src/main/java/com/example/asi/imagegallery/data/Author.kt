package com.example.asi.imagegallery.data
import com.google.gson.annotations.SerializedName


data class Author (

	@SerializedName("id") val id : Int?,
	@SerializedName("authorName") val authorName : String?,
	@SerializedName("authorAvatar") val authorAvatar : AuthorAvatar?
)