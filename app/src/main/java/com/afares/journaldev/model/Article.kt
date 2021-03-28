package com.afares.journaldev.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Article(
    @SerializedName("abstract")
    val abstract: String,
    @SerializedName("byline")
    val byline: String,
    @SerializedName("media")
    val media: @RawValue List<Media>,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("title")
    val title: String
) : Parcelable