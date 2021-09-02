package com.study.android_clean_architecture.data.repository

import com.study.android_clean_architecture.data.api.model.toDomainModel
import com.study.android_clean_architecture.data.datasource.RemoteProductDataSource
import com.study.android_clean_architecture.domain.AlbumProduct
import com.study.android_clean_architecture.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val dataSource: RemoteProductDataSource
) : ProductRepository {
    //datasource에서 가져온 데이터를
    override suspend fun getAlbumsProducts(): List<AlbumProduct> {
        return dataSource.getProducts().toDomainModel()
    }
}