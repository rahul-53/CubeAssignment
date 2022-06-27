package com.rahul.cubeassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.cubeassignment.adapter.MovieAdapter
import com.rahul.cubeassignment.databinding.ActivityMainBinding
import com.rahul.cubeassignment.model.Result
import com.rahul.cubeassignment.network.NetworkHelper
import com.rahul.cubeassignment.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var moviesViewModel: MovieViewModel
    lateinit var moviesAdapter: MovieAdapter
    var movieList = mutableListOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        moviesViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        getMovies()

    }
    private fun setAdapter(){
        moviesAdapter = MovieAdapter(this, movieList)
        val gridLayoutManager = GridLayoutManager(this,2)
        binding.rvMovies.apply {
            adapter = moviesAdapter
            layoutManager = gridLayoutManager
        }

    }

    private fun getMovies(){

        moviesViewModel.callMovieApi()

        moviesViewModel.liveData.observe(this){
            it.let {
                when(it){
                    is NetworkHelper.OnSuccess ->{
                        movieList= it.responseList as ArrayList<Result>
                        setAdapter()
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "Error occurred", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}