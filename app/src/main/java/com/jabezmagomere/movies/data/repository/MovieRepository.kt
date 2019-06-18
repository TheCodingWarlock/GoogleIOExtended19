package com.jabezmagomere.movies.data.repository

import com.jabezmagomere.movies.data.db.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getTrendingMoviesThisWeek(): Flow<List<Movie>>
    suspend fun getTrendingMoviesToday(): Flow<List<Movie>>
    suspend fun discoverActionMovies(): Flow<List<Movie>>
    suspend fun discoverComedyMovies(): Flow<List<Movie>>
}