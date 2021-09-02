package com.study.android_clean_architecture.domain.usecase

import com.study.android_clean_architecture.di.IoDispatcher
import com.study.android_clean_architecture.domain.AlbumProduct
import com.study.android_clean_architecture.domain.CoroutineUseCase
import com.study.android_clean_architecture.domain.repository.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

//ProductRepository을 사용
class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
) : CoroutineUseCase<Unit, List<AlbumProduct>>(coroutineDispatcher) {

    override suspend fun execute(parameter: Unit): List<AlbumProduct> {
        return repository.getAlbumsProducts()
    }
}