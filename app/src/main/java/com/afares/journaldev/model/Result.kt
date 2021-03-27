package com.afares.journaldev.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("abstract")
    val abstract: String,
    @SerializedName("byline")
    val byline: String,
    @SerializedName("media")
    val media: List<Media>,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("section")
    val section: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("title")
    val title: String
)