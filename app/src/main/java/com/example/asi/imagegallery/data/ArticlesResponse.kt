package com.example.asi.imagegallery.data
import com.google.gson.annotations.SerializedName

data class ArticlesResponse (
	@SerializedName("data") val articles : List<Article>
)