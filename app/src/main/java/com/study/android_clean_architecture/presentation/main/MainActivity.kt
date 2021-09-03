package com.study.android_clean_architecture.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.study.android_clean_architecture.R
import com.study.android_clean_architecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity constructor(): AppCompatActivity() {

    companion object{
        const val TAG = "로그"
    }
    private val mainViewModel by viewModels<MainViewModel>()
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        observeViewModel()
        mainViewModel.getProducts()
    }
    private fun observeViewModel(){
        mainViewModel.product.observe(this, Observer {
            Log.d(TAG, "$it")
        })
    }
}