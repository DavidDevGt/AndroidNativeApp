package com.example.retrofit_jetpackcompose_api.models

data class Country(
    val name: Name,
    val translations: Translations?,
    val capital: List<String>?,
    val region: String,
    val population: Int,
    val flags: Flags
)

data class Name(
    val common: String,
    val official: String
)

data class Translations(
    val spa: Translation
)

data class Translation(
    val official: String,
    val common: String
)

data class Flags(
    val png: String,
    val svg: String
)
