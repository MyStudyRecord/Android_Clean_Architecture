package com.study.android_clean_architecture.data.datasource

import com.study.android_clean_architecture.data.api.ProductApi
import com.study.android_clean_architecture.data.api.model.AlbumProductRemote
import retrofit2.Response
import javax.inject.Inject

class RemoteProductDataSource @Inject constructor(
    private val api: ProductApi
) {
    suspend fun getProducts(): List<AlbumProductRemote> {
        return api.getAlbumsProducts().verify()
    }

    //서버에서 가져온 데이터를 kotlin 확장 함수를 통해 검증
    fun Response<List<AlbumProductRemote>>.verify(): List<AlbumProductRemote> {
        if (this.isSuccessful && this.code() in 200..299) {
            return this.body() ?: listOf()
        } else {
            throw Exception("${this.code()}")
        }
    }
}