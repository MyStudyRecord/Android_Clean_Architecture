package com.study.android_clean_architecture.di

import com.study.android_clean_architecture.data.api.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideProductApi() : ProductApi = Retrofit.Builder()
        .baseUrl("https://some-base-url")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductApi::class.java)
}