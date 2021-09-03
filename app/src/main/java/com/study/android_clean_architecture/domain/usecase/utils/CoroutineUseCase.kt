package com.study.android_clean_architecture.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import com.study.android_clean_architecture.domain.usecase.utils.Result

//CoroutineUseCase<>
abstract class CoroutineUseCase<P, R>(
    private val coroutineDispatcher: CoroutineDispatcher
) {
    protected abstract suspend fun execute(parameter: P) : R

    val arrayList = ArrayList<String>()

    //그리고 자식으로부터 받은 CoroutineDispatcher를 withContext를 사용하여 작업을 진행할 Thread를 변경할 수 있다
    suspend operator fun invoke(parameter: P) : Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                val result = execute(parameter)
                Result.Success(result)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}