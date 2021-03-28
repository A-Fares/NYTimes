package com.afares.journaldev.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.afares.journaldev.databinding.ArticlesRowLayoutBinding
import com.afares.journaldev.model.ArticleResponse
import com.afares.journaldev.model.Article

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.MyViewHolder>() {

    var articles = emptyList<Article>()

    class MyViewHolder(private val binding: ArticlesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, imageUrl: String) {
            binding.article = article
            binding.imageUrl = imageUrl
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ArticlesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = articles[position]
        var imageUrl = ""

        if (articles[position].media.isNotEmpty() && articles[position].media[0].mediaMetadata.isNotEmpty()
        ) {
            imageUrl = articles[position].media[0].mediaMetadata[2].url
        }
        holder.bind(currentItem, imageUrl)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun setData(newData: ArticleResponse) {
        val articlesDiffUtil = ArticlesDiffUtil(articles, newData.articles)
        val diffUtilResult = DiffUtil.calculateDiff(articlesDiffUtil)
        articles = newData.articles
        diffUtilResult.dispatchUpdatesTo(this)
    }

}