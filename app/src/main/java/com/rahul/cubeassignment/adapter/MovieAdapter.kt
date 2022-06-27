package com.rahul.cubeassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.cubeassignment.databinding.MovieItemLayoutBinding
import com.rahul.cubeassignment.model.Result

class MovieAdapter(private val context: Context, private val movieList:List<Result>)
    :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       val itemLayoutBinding = MovieItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MovieViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieResponseItem = movieList[position]
        val str = "https://image.tmdb.org/t/p/"
        holder.movieItemLayoutBinding.apply {
            val str2 = str+movieResponseItem.poster_path
            tvMovieName.text = movieResponseItem.title
            releaseDate.text = movieResponseItem.release_date
            tvPopularity.text =movieResponseItem.popularity.toString()
            rating.text = movieResponseItem.vote_average.toString()
            Glide.with(context).load("https://image.tmdb.org/t/p/original"+movieResponseItem.poster_path).into(posterImg)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MovieViewHolder( val movieItemLayoutBinding: MovieItemLayoutBinding)
        :RecyclerView.ViewHolder(movieItemLayoutBinding.root){

    }
}