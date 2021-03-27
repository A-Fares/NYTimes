package com.afares.journaldev.data

import com.afares.journaldev.data.network.ArticleApi
import com.afares.journaldev.model.Article
import com.afares.journaldev.util.Constants.Companion.API_KEY
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val articleApi: ArticleApi
) {

    suspend fun getArticles(period: String): Response<Article> {
        return articleApi.getArticles(period, API_KEY)
    }
}