package com.example.asi.imagegallery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asi.imagegallery.R
import com.example.asi.imagegallery.ui.ImageGalleryFragment

class ArticlesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, ImageGalleryFragment(), ImageGalleryFragment::class.simpleName)
                .commit()
        }
    }
}