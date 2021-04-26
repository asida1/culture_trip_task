package com.example.asi.imagegallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.asi.imagegallery.repository.ImageRepository


class ViewModelFactory(private val imageRepository: ImageRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageViewModel(imageRepository) as T
    }
}
