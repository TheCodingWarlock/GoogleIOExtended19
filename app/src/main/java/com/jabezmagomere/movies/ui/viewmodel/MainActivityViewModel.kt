package com.jabezmagomere.movies.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jabezmagomere.movies.data.db.Movie
import com.jabezmagomere.movies.data.repository.MovieRepository
import com.jabezmagomere.movies.ui.view.Category
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    suspend fun getTrendingMoviesToday(): Flow<List<Movie>> = movieRepository.getTrendingMoviesToday()

    suspend fun getTrendingMoviesThisWeek(): Flow<List<Movie>> = movieRepository.getTrendingMoviesThisWeek()

    suspend fun getActionMovies(): Flow<List<Movie>> = movieRepository.discoverActionMovies()

    suspend fun getComedyMovies(): Flow<List<Movie>> = movieRepository.discoverComedyMovies()

    val allCategory = MutableLiveData<ArrayList<Category>>()
    val isLoading = MutableLiveData<Boolean>()
}