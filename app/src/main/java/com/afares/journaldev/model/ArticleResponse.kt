package com.afares.journaldev.model


import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("results")
    val articles: List<Article>
)