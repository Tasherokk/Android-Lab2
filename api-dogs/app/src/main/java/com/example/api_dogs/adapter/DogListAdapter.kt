package com.example.api_dogs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_dogs.databinding.ItemDogBinding
import com.example.api_dogs.model.diffutil.DogItemCallback
import com.example.api_dogs.model.entity.Dog

class DogListAdapter : ListAdapter<Dog, DogListAdapter.ViewHolder>(DogItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogListAdapter.ViewHolder {
        return ViewHolder(
            ItemDogBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemDogBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dog: Dog) {
            with(binding) {

                Glide
                    .with(root.context)
                    .load(dog.img)
                    .into(dogImage)

                dogName.text = dog.name
                dogEnergy.text = dog.energy.toString()
                dogGoodWithChildren.text = dog.goodWithChildren.toString()

            }
        }

    }


}