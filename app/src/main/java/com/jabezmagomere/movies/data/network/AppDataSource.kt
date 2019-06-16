package com.jabezmagomere.movies.data.network

import com.jabezmagomere.movies.data.models.MovieApiResponse
import kotlinx.coroutines.flow.Flow

interface AppDataSource {
    fun fetchTrendingMoviesThisWeek(): Flow<retrofit2.Response<MovieApiResponse>>
    fun fetchTrendingMoviesToday(): Flow<retrofit2.Response<MovieApiResponse>>
    fun fetchActionMovies(): Flow<retrofit2.Response<MovieApiResponse>>
    fun fetchComedyMovies(): Flow<retrofit2.Response<MovieApiResponse>>
}