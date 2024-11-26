package com.example.retrofit_jetpackcompose_api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.retrofit_jetpackcompose_api.navigation.AppNavigation
import com.example.retrofit_jetpackcompose_api.ui.theme.Retrofit_JetpackCompose_APITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit_JetpackCompose_APITheme {
                AppNavigation()
            }
        }
    }
}
