package com.study.android_clean_architecture.data.api

import com.study.android_clean_architecture.data.api.model.AlbumProductRemote
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("albums")
    suspend fun getAlbumsProducts() : Response<List<AlbumProductRemote>>
}