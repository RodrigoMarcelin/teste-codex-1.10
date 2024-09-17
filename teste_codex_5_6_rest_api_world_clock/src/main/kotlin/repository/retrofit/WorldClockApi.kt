package org.example.repository.retrofit

import org.example.repository.model.WorldClockResponse
import retrofit2.http.GET

interface WorldClockApi {
    @GET("api/json/utc/now")
    suspend fun getCurrentTime(): WorldClockResponse
}