package com.example.asi.imagegallery.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.asi.imagegallery.R
import com.example.asi.imagegallery.adapters.ImageGalleryAdapter
import com.example.asi.imagegallery.repository.ImageRepository
import com.example.asi.imagegallery.viewmodel.ImageViewModel
import com.example.asi.imagegallery.viewmodel.ViewModelFactory

class ImageGalleryFragment : Fragment() {

    private val imageViewModel: ImageViewModel by viewModels {
        ViewModelFactory(ImageRepository())
    }

    private lateinit var progressBar: ProgressBar

    private lateinit var imageGalleryAdapter: ImageGalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.image_gallery_fragment, container, false)

        progressBar = root.findViewById(R.id.progress)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initList(view)

        initViewModel()

        imageViewModel.fetchImages()

        showProgress()
    }

    private fun initViewModel() {
        imageViewModel.imageLiveArticle.observe(viewLifecycleOwner,
            Observer { articles ->
                articles?.let {
                    imageGalleryAdapter.submitList(it)
                }

                hideProgress()
            })
    }

    private fun initList(view: View) {
        val imageList = view.findViewById<RecyclerView>(R.id.imageList)

        imageGalleryAdapter = ImageGalleryAdapter()
        imageList.adapter = imageGalleryAdapter

    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
    }
}
