package com.example.retrofit_jetpackcompose_api.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retrofit_jetpackcompose_api.views.CountryListScreen
import com.example.retrofit_jetpackcompose_api.views.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNavigateToCountries = { navController.navigate("countries") })
        }
        composable("countries") {
            CountryListScreen()
        }
    }
}
