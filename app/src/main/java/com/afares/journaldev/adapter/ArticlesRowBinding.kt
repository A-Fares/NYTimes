package com.afares.journaldev.adapter

import android.util.Log
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.afares.journaldev.R
import com.afares.journaldev.model.Article
import com.afares.journaldev.ui.fragments.articles.ArticlesFragmentDirections

class ArticlesRowBinding {
    companion object {

        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
            imageView.load(imageUrl) {
                crossfade(600)
                error(R.drawable.ic_error_placeholder)
            }
        }


        @BindingAdapter("setArticleData", "imageUrl", requireAll = true)
        @JvmStatic
        fun onArticleClickListener(
            articleRowLayout: ConstraintLayout,
            article: Article,
            imageUrl: String
        ) {
            articleRowLayout.setOnClickListener {
                try {
                    val action =
                        ArticlesFragmentDirections.actionArticlesFragmentToArticleDetailsFragment(
                            article,
                            imageUrl
                        )
                    articleRowLayout.findNavController().navigate(action)
                } catch (e: Exception) {
                    Log.d("onRecipeClickListener", e.toString())
                }
            }
        }

    }
}