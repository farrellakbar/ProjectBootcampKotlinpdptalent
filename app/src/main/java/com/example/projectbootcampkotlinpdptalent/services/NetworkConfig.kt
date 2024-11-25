package com.example.projectbootcampkotlinpdptalent.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    private const val BASE_URL = "https://3a61-2404-c0-5c40-00-3ac0-10ba.ngrok-free.app/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
