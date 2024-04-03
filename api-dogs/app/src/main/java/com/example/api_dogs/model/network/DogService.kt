package com.example.api_dogs.model.network

import com.example.api_dogs.model.entity.Dog
import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("dogs?barking=1&x-api-key=wYXuDguepifuxo9lKxY1eQ==DXdOSaZcNjOFfC6N")
    fun fetchDogList(): Call<List<Dog>>
}