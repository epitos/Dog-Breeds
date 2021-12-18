package com.example.dogbreeds.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreeds.data.model.Message
import com.example.dogbreeds.data.repository.Repository
import com.example.dogbreeds.utils.NetworkHelper
import com.example.dogbreeds.utils.Resource
import kotlinx.coroutines.launch

class BreedListViewModel(private val repository: Repository,
                         private val networkHelper: NetworkHelper): ViewModel() {

    val mainBreeds = MutableLiveData<Resource<ArrayList<String>>>()
    val subBreeds = MutableLiveData<Resource<Message>>()

    private val mainBreedList = arrayListOf<String>()

    init {
        getBreeds()
    }

    private fun getBreeds() {
        viewModelScope.launch {
            mainBreeds.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                repository.getMainBreeds().let {
                    if (it.isSuccessful) {
                        getSubBreeds()
                        mainBreedList.addAll(it.body()!!.message)
                    } else {
                        mainBreeds.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else {
                mainBreeds.postValue(Resource.error("No Internet Connection!", null))
            }
        }
    }

    private fun getSubBreeds() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                repository.getSubBreeds().let {
                    if (it.isSuccessful) {
                        subBreeds.postValue(Resource.success(it.body()!!.message))
                        mainBreeds.postValue((Resource.success(mainBreedList)))
                    } else {
                        subBreeds.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else {
                subBreeds.postValue(Resource.error("No Internet Connection!", null))
            }
        }
    }
}