package com.jabezmagomere.movies.data.network

import com.jabezmagomere.movies.data.db.Movie
import com.jabezmagomere.movies.data.models.Response
import kotlinx.coroutines.flow.Flow

interface AppDataSource {
    fun fetchTrendingMoviesThisWeek(): Flow<retrofit2.Response<Response>>
    fun fetchTrendingMoviesToday(): Flow<retrofit2.Response<Response>>
    fun fetchActionMovies(): Flow<retrofit2.Response<Response>>
    fun fetchComedyMovies(): Flow<retrofit2.Response<Response>>
}