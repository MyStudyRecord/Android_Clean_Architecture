package com.study.android_clean_architecture.di

import com.study.android_clean_architecture.data.repository.ProductRepositoryImpl
import com.study.android_clean_architecture.data.datasource.RemoteProductDataSource
import com.study.android_clean_architecture.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        remoteProductDataSource: RemoteProductDataSource
    ) : ProductRepository {
        return ProductRepositoryImpl(remoteProductDataSource)
    }

}
