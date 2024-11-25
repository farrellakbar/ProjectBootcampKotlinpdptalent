package com.example.projectbootcampkotlinpdptalent.services

import com.example.projectbootcampkotlinpdptalent.model.UserSchedule
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("user/schedule/{userId}")
    fun getUserSchedules(@Path("userId") userId: Int): Call<List<UserSchedule>>
}