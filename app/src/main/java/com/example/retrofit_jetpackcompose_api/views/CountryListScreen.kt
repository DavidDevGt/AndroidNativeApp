package com.example.retrofit_jetpackcompose_api.views

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit_jetpackcompose_api.models.Country
import com.example.retrofit_jetpackcompose_api.viewmodels.CountriesViewModel
import kotlinx.coroutines.delay

@Composable
fun AnimatedLoadingText(
    text: String = "Cargando",
    color: Color = Color(0xFF87CEEB)
) {
    var dots by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        while (true) {
            dots = when (dots.length) {
                0 -> "."
                1 -> ".."
                2 -> "..."
                else -> ""
            }
            delay(500)
        }
    }

    Text(
        text = "$text$dots",
        color = color,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun CountryListScreen(
    modifier: Modifier = Modifier,
    viewModel: CountriesViewModel = viewModel()
) {
    val countries by remember { viewModel.countries }
    val isLoading by remember { viewModel.isLoading }
    val errorMessage by remember { viewModel.errorMessage }

    LaunchedEffect(Unit) {
        viewModel.fetchCountries() // Cargar datos
    }

    Box(modifier = modifier.fillMaxSize()) {
        when {
            isLoading && countries.isEmpty() -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier.fillMaxSize()
                ) {
                    AnimatedLoadingText(text = "Cargando datos")
                }
            }
            errorMessage != null -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier.fillMaxSize()
                ) {
                    Text(errorMessage!!)
                }
            }
            countries.isEmpty() -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier.fillMaxSize()
                ) {
                    Text("No hay datos disponibles.")
                }
            }
            else -> {
                Column(modifier = modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shadowElevation = 4.dp
                    ) {
                        Text(
                            text = "Países",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF87CEEB), // Azul claro
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    ) {
                        items(countries) { country ->
                            CountryItem(country)
                        }
                        item {
                            if (isLoading) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    AnimatedLoadingText(text = "Cargando más países")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = country.translations?.spa?.common ?: country.name.common,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = rememberAsyncImagePainter(country.flags.png),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .aspectRatio(4f/3f),
            contentScale = ContentScale.Crop
        )
    }
}
