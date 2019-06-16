package com.jabezmagomere.movies.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.airbnb.lottie.L
import com.jabezmagomere.movies.data.db.Movie
import com.jabezmagomere.movies.data.repository.MovieRepository
import com.jabezmagomere.movies.ui.view.Category
import kotlinx.coroutines.*
import java.lang.Exception

class MainActivityViewModel(movieRepository: MovieRepository) : ViewModel() {

    val trendingMoviesToday = movieRepository.getTrendingMoviesThisWeek()

    val trendingMoviesThisWeek = movieRepository.getTrendingMoviesThisWeek()

    val actionMovies = movieRepository.discoverActionMovies()

    val comedyMovies = movieRepository.discoverComedyMovies()

    val allCategory = MutableLiveData<ArrayList<Category>>()
    val isLoading = MutableLiveData<Boolean>()
}