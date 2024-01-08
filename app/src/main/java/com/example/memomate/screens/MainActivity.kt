package com.example.memomate.screens

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.memomate.screens.home.Navigate_HomeToCreateNote

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Navigate_HomeToCreateNote()
//            Navigate_HomeToDetailNote()
        }
    }
}