package com.example.asi.imagegallery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.asi.imagegallery.R
import com.example.asi.imagegallery.data.Article
import com.example.asi.imagegallery.viewholders.ArticleViewHolder

class ImageGalleryAdapter :
    ListAdapter<Article, ArticleViewHolder>(GalleryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.image_gallery_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val galleryImage = getItem(position)
        galleryImage?.let {
            holder.bind(galleryImage)
        }
    }
}

private class GalleryDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id.equals(newItem.id)
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}
