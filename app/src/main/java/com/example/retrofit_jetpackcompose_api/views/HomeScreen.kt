package com.example.retrofit_jetpackcompose_api.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onNavigateToCountries: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Home", modifier = Modifier.padding(bottom = 16.dp))
            Text(text = "JOSUE DAVID VARGAS LOPEZ")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "22000599")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToCountries) {
                Text(text = "Cargar")
            }
        }
    }
}
