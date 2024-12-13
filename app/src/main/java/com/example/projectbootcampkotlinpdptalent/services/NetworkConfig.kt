package com.example.projectbootcampkotlinpdptalent.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    private const val BASE_URL = "https://b32f-2404-c0-2120-00-45f-b88a.ngrok-free.app/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
