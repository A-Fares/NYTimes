package com.afares.journaldev.model


import com.google.gson.annotations.SerializedName

data class MediaMetadata(
    @SerializedName("url")
    val url: String
)