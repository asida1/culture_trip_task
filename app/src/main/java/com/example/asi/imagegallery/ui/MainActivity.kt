package com.example.asi.imagegallery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.asi.imagegallery.R
import com.example.asi.imagegallery.ui.ImageGalleryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.get_articles_btn).setOnClickListener {
            startArticlesActivity()
        }
    }

    private fun startArticlesActivity() {
        Intent(this, ArticlesActivity::class.java).apply {
            startActivity(this)
        }
    }
}