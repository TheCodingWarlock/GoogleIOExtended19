package com.jabezmagomere.movies.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jabezmagomere.movies.data.db.Movie
import com.jabezmagomere.movies.data.repository.MovieRepository
import com.jabezmagomere.movies.ui.view.Category
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    lateinit var trendingMoviesToday: Flow<List<Movie>>
    lateinit var trendingMoviesThisWeek: Flow<List<Movie>>
    lateinit var actionMovies: Flow<List<Movie>>
    lateinit var comedyMovies: Flow<List<Movie>>

    val allCategory = MutableLiveData<ArrayList<Category>>()
    val isLoading = MutableLiveData<Boolean>()

    suspend fun initTrendingMoviesToday() {
        trendingMoviesToday = movieRepository.getTrendingMoviesToday()
    }

    suspend fun initTrendingMoviesThisWeek() {
        trendingMoviesThisWeek = movieRepository.getTrendingMoviesThisWeek()
    }

    suspend fun initActionMovies() {
        actionMovies = movieRepository.discoverActionMovies()
    }

    suspend fun initComedyMovies() {
        comedyMovies = movieRepository.discoverComedyMovies()
    }

}