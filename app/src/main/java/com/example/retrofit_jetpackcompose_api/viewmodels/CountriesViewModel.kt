package com.example.retrofit_jetpackcompose_api.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_jetpackcompose_api.models.Country
import com.example.retrofit_jetpackcompose_api.network.APIService
import com.example.retrofit_jetpackcompose_api.utils.Constantes
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor

class CountriesViewModel : ViewModel() {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("User-Agent", "Retrofit-Sample-App")
                .build()
            chain.proceed(request)
        }
        .connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(Constantes.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(APIService::class.java)

    val countries = mutableStateOf<List<Country>>(emptyList())
    val isLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)

    fun fetchCountries() {
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = null
            try {
                val response = apiService.getCountries()
                countries.value = response
            } catch (e: retrofit2.HttpException) {
                errorMessage.value = "Error HTTP: ${e.code()} - ${e.message()}"
            } catch (e: java.net.SocketTimeoutException) {
                errorMessage.value = "Tiempo de espera agotado. Intenta de nuevo."
            } catch (e: java.net.ProtocolException) {
                errorMessage.value = "Error de protocolo. Intenta de nuevo."
            } catch (e: Exception) {
                errorMessage.value = "Error inesperado: ${e.localizedMessage}"
            } finally {
                isLoading.value = false
            }
        }
    }
}
