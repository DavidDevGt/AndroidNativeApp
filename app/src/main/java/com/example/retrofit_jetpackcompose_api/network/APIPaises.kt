package com.example.retrofit_jetpackcompose_api.network

import com.example.retrofit_jetpackcompose_api.models.Country
import retrofit2.http.GET

interface APIService {
    @GET("all?fields=name,translations,capital,region,population,flags")
    suspend fun getCountries(): List<Country>
}
