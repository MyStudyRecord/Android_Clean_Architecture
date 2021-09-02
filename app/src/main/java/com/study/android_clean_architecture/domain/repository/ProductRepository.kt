package com.study.android_clean_architecture.domain.repository

import com.study.android_clean_architecture.domain.AlbumProduct

interface ProductRepository {
    //data 레이어에서 구현했던(사용했던) repository
    suspend fun getAlbumsProducts() : List<AlbumProduct>
}