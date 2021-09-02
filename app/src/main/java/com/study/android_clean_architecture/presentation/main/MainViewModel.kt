package com.study.android_clean_architecture.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.android_clean_architecture.domain.AlbumProduct
import com.study.android_clean_architecture.domain.usecase.GetProductsUseCase
import com.study.android_clean_architecture.domain.usecase.utils.data
import com.study.android_clean_architecture.domain.usecase.utils.succeeded
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _products = MutableLiveData<List<AlbumProduct>>()
    val product : LiveData<List<AlbumProduct>> get() = _products

    init {
        getProducts()
    }

    fun getProducts() {
        // viewModelScope을 이용하여 ViewModel의 생명주기에 따라 현재 실행 중인 Coroutine을 안전하게 종료
        viewModelScope.launch {

            val result = getProductsUseCase(Unit)
            if (result.succeeded) {
                _products.value = result.data
            } else {
                //handle error
            }
        }
    }
}