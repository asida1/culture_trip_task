package com.example.asi.imagegallery.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.asi.imagegallery.data.Article
import com.example.asi.imagegallery.repository.ImageRepository

class ImageViewModel(private val imageRepository: ImageRepository) : ViewModel(), ImageRepository.ImageResponseListener {

    val imageLiveArticle: MutableLiveData<List<Article>?> = MutableLiveData()

    init {
        imageRepository.imageResponseListener = this
    }


    fun fetchImages() = imageRepository.fetchImages()

    override fun onResponse(articles: List<Article>?) {
        imageLiveArticle.postValue(articles)
    }

    override fun onError(error: String?) {
        error?.let {
            Log.e(ImageViewModel::class.simpleName, "response failed: $error")
            imageLiveArticle.postValue(null)
        }
    }

    override fun onCleared() {
        imageRepository.imageResponseListener = null
    }
}
