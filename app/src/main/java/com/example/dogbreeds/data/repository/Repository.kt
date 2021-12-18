package com.example.dogbreeds.data.repository

import com.example.dogbreeds.data.api.ApiService

class Repository(private val apiService: ApiService) {

    suspend fun getMainBreeds() = apiService.getMainBreeds()
    suspend fun getSubBreeds() = apiService.getSubBreeds()
    suspend fun getMainBreedImages(breed: String) = apiService.getMainBreedImages(breed)
    suspend fun getSubBreedImages(breed: String, subBreed: String) =
        apiService.getSubBreedImages(breed, subBreed)
}