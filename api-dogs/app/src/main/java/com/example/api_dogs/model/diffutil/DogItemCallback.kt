package com.example.api_dogs.model.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.api_dogs.model.entity.Dog

class DogItemCallback : DiffUtil.ItemCallback<Dog>() {

    override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem.energy == newItem.energy && oldItem.maxLifeExpectancy == newItem.maxLifeExpectancy
    }

}