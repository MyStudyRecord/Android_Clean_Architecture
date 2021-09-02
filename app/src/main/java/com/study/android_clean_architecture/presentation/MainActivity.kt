package com.study.android_clean_architecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.android_clean_architecture.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}