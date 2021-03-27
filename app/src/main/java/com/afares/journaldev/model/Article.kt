package com.afares.journaldev.model


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("results")
    val results: List<Result>
)