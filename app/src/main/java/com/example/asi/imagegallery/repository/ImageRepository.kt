package com.example.asi.imagegallery.repository

import com.example.asi.imagegallery.api.ArticlesService
import com.example.asi.imagegallery.data.ArticlesResponse
import com.example.asi.imagegallery.data.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://cdn.theculturetrip.com/"

class ImageRepository {

    var imageResponseListener: ImageResponseListener? = null
    
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val articlesService = retrofit.create(ArticlesService::class.java)

    fun fetchImages() {
        articlesService.fetchArticles()
            .enqueue(object : Callback<ArticlesResponse> {
                override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                    imageResponseListener?.onError(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ArticlesResponse>,
                    response: Response<ArticlesResponse>
                ) {
                    imageResponseListener?.onResponse(response.body()?.articles)
                }

            })
    }

    interface ImageResponseListener {
        fun onResponse(articles: List<Article>?)
        fun onError(error: String?)
    }
}