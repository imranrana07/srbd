package com.imran.srdb.data.home


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PhotosModel(
    @SerializedName("albumId")
    val albumId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
)