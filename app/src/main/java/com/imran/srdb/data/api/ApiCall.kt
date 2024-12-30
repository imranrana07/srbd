package com.imran.srdb.data.api

import com.imran.srdb.data.home.PhotosModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    @GET("photos")
    suspend fun getPhotos(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int = 20,
    ): Response<MutableList<PhotosModel>>
}