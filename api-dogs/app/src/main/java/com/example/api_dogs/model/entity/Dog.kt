package com.example.api_dogs.model.entity

import com.google.gson.annotations.SerializedName

data class Dog (

    val name: String,
    @SerializedName("image_link") val img: String,
    val energy: Int,
    @SerializedName("good_with_children") val goodWithChildren: Int,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: String

)