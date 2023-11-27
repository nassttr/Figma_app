package com.example.figma_app.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MainAPI {
    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): Response<User>
}