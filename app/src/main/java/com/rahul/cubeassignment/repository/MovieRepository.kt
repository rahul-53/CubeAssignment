package com.rahul.cubeassignment.repository

import androidx.lifecycle.LiveData
import com.rahul.cubeassignment.model.Result
import com.rahul.cubeassignment.network.ApiService
import com.rahul.cubeassignment.network.NetworkCall

class MovieRepository {

    private fun getService(): ApiService = NetworkCall.getRetrofit().create(ApiService::class.java)
    suspend fun getMovies(): List<Result> {
        return getService().getMovies().results
    }
}