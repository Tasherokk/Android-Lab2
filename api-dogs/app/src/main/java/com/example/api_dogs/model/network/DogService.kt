package com.example.api_dogs.model.network

import com.example.api_dogs.model.entity.Dog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DogService {
    @GET("dogs?x-api-key=wYXuDguepifuxo9lKxY1eQ==DXdOSaZcNjOFfC6N")
    fun fetchDogList(@Query("name")name: String): Call<List<Dog>>

}
