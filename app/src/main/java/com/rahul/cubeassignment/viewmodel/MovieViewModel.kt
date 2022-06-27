package com.rahul.cubeassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.rahul.cubeassignment.network.NetworkHelper
import com.rahul.cubeassignment.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MovieViewModel:ViewModel() {
    private val movieRepository = MovieRepository()
    private val mutableLiveData = MutableLiveData<NetworkHelper>()
    val liveData: LiveData<NetworkHelper> = mutableLiveData

    fun callMovieApi(){
        CoroutineScope(Dispatchers.IO).launch {
            val movies = movieRepository.getMovies()
            mutableLiveData.postValue(NetworkHelper.OnSuccess(movies))

        }
    }

}