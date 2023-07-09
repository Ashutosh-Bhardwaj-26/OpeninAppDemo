package com.example.openinappdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.openinappdemo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_OpeninAppDemo)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}