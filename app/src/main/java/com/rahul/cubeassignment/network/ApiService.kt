package com.rahul.cubeassignment.network

import com.rahul.cubeassignment.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
      @GET("3/movie/now_playing?api_key=9d0e3e33437b228d3184927838d32b9b&language=en-US&page=1")
    suspend fun getMovies(): MovieResponse
}