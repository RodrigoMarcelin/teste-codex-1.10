package org.example.repository.model

import com.google.gson.annotations.SerializedName

data class WorldClockResponse(
    @SerializedName("currentDateTime") val currentDateTime: String
)

