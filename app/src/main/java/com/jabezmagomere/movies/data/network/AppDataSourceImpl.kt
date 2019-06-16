package com.jabezmagomere.movies.data.network

import com.jabezmagomere.movies.data.network.Api.DiscoverMoviesApiService
import com.jabezmagomere.movies.data.network.Api.MoviesApiService

class AppDataSourceImpl(
    private val moviesApiService: MoviesApiService,
    private val discoverMoviesApiService: DiscoverMoviesApiService
) : AppDataSource {
    override fun fetchActionMovies() = discoverMoviesApiService.fetchActionMovies()
    override fun fetchComedyMovies() = discoverMoviesApiService.fetchComedyMovies()
    override fun fetchTrendingMoviesThisWeek() = moviesApiService.fetchTrendingMoviesThisWeek()
    override fun fetchTrendingMoviesToday() = moviesApiService.fetchTrendingMoviesToday()
}