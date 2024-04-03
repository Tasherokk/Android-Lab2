package com.example.api_dogs.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance = retrofit.create(DogService::class.java)

}