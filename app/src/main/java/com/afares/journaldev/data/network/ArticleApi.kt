package com.afares.journaldev.data.network

import com.afares.journaldev.model.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleApi {

    @GET("mostpopular/v2/viewed/{period}.json")
    suspend fun getArticles(
        @Path("period") period: String,
        @Query("api-key") apiKey: String
    ): Response<ArticleResponse>

}