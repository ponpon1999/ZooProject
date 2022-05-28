package com.example.animal

import retrofit2.Call
import retrofit2.http.GET

interface apiterface {
    @GET("/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    fun getPosts1(): Call<animal>

    @GET("/api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14?scope=resourceAquire")
    fun getPosts2(): Call<Plant>
}