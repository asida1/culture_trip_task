package com.example.asi.imagegallery.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.asi.imagegallery.R
import com.example.asi.imagegallery.data.Article
import de.hdodenhof.circleimageview.CircleImageView

class ArticleViewHolder(
    rootView: View
) : RecyclerView.ViewHolder(rootView) {
    private val galleryImage: ImageView = rootView.findViewById(R.id.galleryImage)
    private val likedIcon: ImageView = rootView.findViewById(R.id.likedIcon)
    private val savedIcon: ImageView = rootView.findViewById(R.id.savedIcon)
    private val avatar: CircleImageView = rootView.findViewById(R.id.avatar)
    private val likedCounterTv: TextView = rootView.findViewById(R.id.likedCounterTv)
    private val categoryTv: TextView = rootView.findViewById(R.id.categoryTv)
    private val titleTv: TextView = rootView.findViewById(R.id.titleTv)
    private val authorTv: TextView = rootView.findViewById(R.id.authorTv)
    private val createdTv: TextView = rootView.findViewById(R.id.createdTv)

    fun bind(item: Article) {
        setImages(item)

        setIcons(item)

        setTexts(item)
    }

    private fun setTexts(item: Article) {
        likedCounterTv.text = item.likesCount.toString()
        categoryTv.text = item.category
        titleTv.text = item.title
        authorTv.text = item.author?.authorName
        createdTv.text = item.metaData?.creationTime
    }

    private fun setIcons(item: Article) {
        val likeDrawable =
            if (item.isLiked!!) itemView.context.getDrawable(R.drawable.liked) else itemView.context.getDrawable(
                R.drawable.like
            )
        likedIcon.setImageDrawable(likeDrawable)

        val saveDrawable =
            if (item.isSaved!!) itemView.context.getDrawable(R.drawable.saved) else itemView.context.getDrawable(
                R.drawable.save
            )
        savedIcon.setImageDrawable(saveDrawable)
    }

    private fun setImages(item: Article) {
        Glide.with(itemView.context).load(item.imageUrl).centerCrop().into(galleryImage)
        Glide.with(itemView.context).load(item.author?.authorAvatar?.imageUrl).centerCrop()
            .into(avatar)
    }
}
