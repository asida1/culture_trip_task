package com.example.asi.imagegallery.api

import com.example.asi.imagegallery.data.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesService {
    @GET("home-assignment/response.json")
    fun fetchArticles(): Call<ArticlesResponse>
}
