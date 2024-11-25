package com.example.projectbootcampkotlinpdptalent.model

import com.google.gson.annotations.SerializedName

data class UserSchedule(
    @SerializedName("scheduleId") val scheduleId: Int,
    @SerializedName("startDate") val startDate: String,
    @SerializedName("endDate") val endDate: String,
    @SerializedName("duration") val duration: Int,
    @SerializedName("programName") val programName: String,
    @SerializedName("groupName") val groupName: String,
    @SerializedName("userEmail") val userEmail: String,
    @SerializedName("batchName") val batchName: String,
    @SerializedName("unitName") val unitName: String

)