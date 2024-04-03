package com.example.api_dogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.api_dogs.adapter.DogListAdapter
import com.example.api_dogs.databinding.ActivityMainBinding
import com.example.api_dogs.model.entity.Dog
import com.example.api_dogs.model.network.ApiClient
import com.example.api_dogs.model.network.DogDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: DogListAdapter by lazy {
        DogListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.instance
        val response = client.fetchDogList()
        binding.dogList.adapter = adapter


        response.enqueue(object : Callback<List<Dog>> {
            override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {
                println("HttpResponse: ${response.body()}")
                val dogs = response.body() ?: emptyList()
                DogDataSource.dogList = dogs as ArrayList<Dog>
                adapter.submitList(DogDataSource.dogList)
            }

            override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                println("HttpResponse: ${t.message}")
            }
        })


        binding.editText.addTextChangedListener {
            val searchQuery = it.toString()

            if (searchQuery.isEmpty()) {
                adapter.submitList(DogDataSource.dogList)
            } else {
                val list = DogDataSource.dogList.filter {
                    it.name.lowercase().contains(searchQuery)
                }
                adapter.submitList(ArrayList(list))
            }
        }

    }

}
