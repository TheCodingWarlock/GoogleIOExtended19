package com.jabezmagomere.movies.data.network

import com.jabezmagomere.movies.data.models.MovieApiResponse

interface AppDataSource {
    suspend fun fetchTrendingMoviesThisWeek(): retrofit2.Response<MovieApiResponse>
    suspend fun fetchTrendingMoviesToday(): retrofit2.Response<MovieApiResponse>
    suspend fun fetchActionMovies(): retrofit2.Response<MovieApiResponse>
    suspend fun fetchComedyMovies(): retrofit2.Response<MovieApiResponse>
}