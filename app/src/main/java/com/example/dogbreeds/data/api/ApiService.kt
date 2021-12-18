package com.example.dogbreeds.data.api

import com.example.dogbreeds.utils.Const.MAIN_BREEDS
import com.example.dogbreeds.utils.Const.MAIN_BREED_IMAGES
import com.example.dogbreeds.utils.Const.SUB_BREEDS
import com.example.dogbreeds.utils.Const.SUB_BREED_IMAGES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(MAIN_BREEDS)
    suspend fun getMainBreeds(): Response<com.example.dogbreeds.data.model.Response>

    @GET(SUB_BREEDS)
    suspend fun getSubBreeds():
            Response<com.example.dogbreeds.data.model.SubBreedsResponse>

    @GET(MAIN_BREED_IMAGES)
    suspend fun getMainBreedImages(@Path("breed") breed: String):
            Response<com.example.dogbreeds.data.model.Response>

    @GET(SUB_BREED_IMAGES)
    suspend fun getSubBreedImages(@Path("breed") breed: String,
                                  @Path("breed2") breed2: String):
            Response<com.example.dogbreeds.data.model.Response>
}