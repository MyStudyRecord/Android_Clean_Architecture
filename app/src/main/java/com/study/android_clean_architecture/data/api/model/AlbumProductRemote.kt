package com.study.android_clean_architecture.data.api.model

import com.study.android_clean_architecture.domain.AlbumProduct

data class AlbumProductRemote(
    val id: Int,
    val title: String,
    val userId: Int
)

//domain에서 사용하는 model class로 매핑해주는 확장 함수
fun List<AlbumProductRemote>.toDomainModel(): List<AlbumProduct> {
    return this.map {
        it.toDomainModel()
    }
}

fun AlbumProductRemote.toDomainModel(): AlbumProduct {
    return AlbumProduct(
        id = this.id,
        title = this.title,
        userId = this.userId
    )
}