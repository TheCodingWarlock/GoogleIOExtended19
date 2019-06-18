package com.jabezmagomere.movies.data.repository

import com.jabezmagomere.movies.data.db.Movie
import com.jabezmagomere.movies.data.db.MoviesDao
import com.jabezmagomere.movies.data.network.AppDataSource
import com.jabezmagomere.movies.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.reactive.flow.asFlow

class MovieRepositoryImpl(
    private val appDataSource: AppDataSource,
    private val moviesDao: MoviesDao
) : MovieRepository {

    override suspend fun getTrendingMoviesThisWeek(): Flow<List<Movie>> {
        if (moviesDao.getNumberOfMovies(Constants.TRENDING_THIS_WEEK) == 0) {
            val response = appDataSource.fetchTrendingMoviesThisWeek()
            if (response.isSuccessful) {
                val movies = response.body()!!.results
                for (movie in movies) {
                    movie.category = Constants.TRENDING_THIS_WEEK
                    moviesDao.insertMovie(movie)
                }
            }
        }
        return moviesDao.getAllMovies(Constants.TRENDING_THIS_WEEK).asFlow().flowOn(Dispatchers.IO)
    }

    override suspend fun getTrendingMoviesToday(): Flow<List<Movie>> {
        if (moviesDao.getNumberOfMovies(Constants.TRENDING_TODAY) == 0) {
            val response = appDataSource.fetchTrendingMoviesToday()
            if (response.isSuccessful) {
                val movies = response.body()!!.results
                for (movie in movies) {
                    movie.category = Constants.TRENDING_TODAY
                    moviesDao.insertMovie(movie)
                }
            }
        }
        return moviesDao.getAllMovies(Constants.TRENDING_TODAY).asFlow().flowOn(Dispatchers.IO)
    }

    override suspend fun discoverActionMovies(): Flow<List<Movie>> {
        if (moviesDao.getNumberOfMovies(Constants.ACTION) == 0) {
            val response = appDataSource.fetchActionMovies()
            if (response.isSuccessful) {
                val movies = response.body()!!.results
                for (movie in movies) {
                    movie.category = Constants.ACTION
                    moviesDao.insertMovie(movie)
                }
            }
        }
        return moviesDao.getAllMovies(Constants.ACTION).asFlow().flowOn(Dispatchers.IO)
    }

    override suspend fun discoverComedyMovies(): Flow<List<Movie>> {
        if (moviesDao.getNumberOfMovies(Constants.ACTION) == 0) {
            val response = appDataSource.fetchComedyMovies()
            if (response.isSuccessful) {
                val movies = response.body()!!.results
                for (movie in movies) {
                    movie.category = Constants.ACTION
                    moviesDao.insertMovie(movie)
                }
            }
        }
        return moviesDao.getAllMovies(Constants.ACTION).asFlow().flowOn(Dispatchers.IO)
    }

}