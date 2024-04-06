package com.example.api_dogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import com.example.api_dogs.adapter.DogListAdapter
import com.example.api_dogs.databinding.ActivityMainBinding
import com.example.api_dogs.model.entity.Dog
import com.example.api_dogs.model.network.ApiClient
import com.example.api_dogs.model.network.DogDataBase
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
        binding.dogList.adapter = adapter

        binding.searchView.clearFocus()
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                binding.searchView.clearFocus()
                fetchDogs(query)
                return false
            }
        })

    }

    private fun fetchDogs(name: String) {
        val client = ApiClient.instance
        val response = client.fetchDogList(name)

        response.enqueue(object : Callback<List<Dog>> {
            override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {
                println("HttpResponse: ${response.body()}")
                val dogs = response.body() ?: emptyList()
                adapter.submitList(dogs)
            }

            override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                println("HttpResponse: ${t.message}")
                adapter.submitList(emptyList())
            }
        })
    }

}
