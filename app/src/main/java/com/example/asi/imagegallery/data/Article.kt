package com.example.asi.imagegallery.data
import com.google.gson.annotations.SerializedName

data class Article (

	@SerializedName("metaData") val metaData : MetaData?,
	@SerializedName("id") val id : String?,
	@SerializedName("title") val title : String?,
	@SerializedName("imageUrl") val imageUrl : String?,
	@SerializedName("isSaved") val isSaved : Boolean?,
	@SerializedName("isLiked") val isLiked : Boolean?,
	@SerializedName("likesCount") val likesCount : Int?,
	@SerializedName("category") val category : String?,
	@SerializedName("author") val author : Author?
)