package com.jabezmagomere.movies.data.network

import com.jabezmagomere.movies.data.db.Movie
import com.jabezmagomere.movies.data.models.Response
import kotlinx.coroutines.flow.Flow

interface AppDataSource {
    suspend fun fetchTrendingMoviesThisWeek():Flow<retrofit2.Response<Response>>
    suspend fun fetchTrendingMoviesToday(): Flow<retrofit2.Response<Response>>
    suspend fun fetchActionMovies(): Flow<retrofit2.Response<Response>>
    suspend fun fetchComedyMovies(): Flow<retrofit2.Response<Response>>
}