package com.example.dogbreeds.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreeds.data.repository.Repository
import com.example.dogbreeds.utils.NetworkHelper
import com.example.dogbreeds.utils.Resource
import kotlinx.coroutines.launch

class BreedDetailsViewModel(private val repository: Repository,
                            private val networkHelper: NetworkHelper): ViewModel()  {

    val breedImages = MutableLiveData<Resource<List<String>>>()

    fun getMainBreedImages(breed: String) {
        viewModelScope.launch {
            breedImages.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                repository.getMainBreedImages(breed).let {
                    if (it.isSuccessful) {
                        breedImages.postValue(Resource.success(it.body()!!.message))
                    } else {
                        breedImages.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else {
                breedImages.postValue(Resource.error("No Internet Connection!", null))
            }
        }
    }

    fun getSubBreedImages(mainBreed: String, subBreed: String) {
        viewModelScope.launch {
            breedImages.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                repository.getSubBreedImages(mainBreed, subBreed).let {
                    if (it.isSuccessful) {
                        breedImages.postValue(Resource.success(it.body()!!.message))
                    } else {
                        breedImages.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else {
                breedImages.postValue(Resource.error("No Internet Connection!", null))
            }
        }
    }
}