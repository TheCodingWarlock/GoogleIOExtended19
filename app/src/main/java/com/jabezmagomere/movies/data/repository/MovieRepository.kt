package com.jabezmagomere.movies.data.repository

import androidx.lifecycle.LiveData
import com.jabezmagomere.movies.data.db.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getTrendingMoviesThisWeek(): Flow<List<Movie>>
    fun getTrendingMoviesToday(): Flow<List<Movie>>
    fun discoverActionMovies(): Flow<List<Movie>>
    fun discoverComedyMovies(): Flow<List<Movie>>
}