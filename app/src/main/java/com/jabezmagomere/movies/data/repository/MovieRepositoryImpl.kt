package com.jabezmagomere.movies.data.repository

import com.jabezmagomere.movies.data.db.MoviesDao
import com.jabezmagomere.movies.data.db.Movie
import com.jabezmagomere.movies.data.network.AppDataSource
import com.jabezmagomere.movies.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(private val appDataSource: AppDataSource, private val moviesDao: MoviesDao) :
    MovieRepository {
    override fun getTrendingMoviesThisWeek(): Flow<List<Movie>> {
        return appDataSource.fetchTrendingMoviesThisWeek()
            .map { response ->
                val movies = response.body()!!.results
                for (movie in movies) {
                    movie.category = Constants.TRENDING_THIS_WEEK
                    moviesDao.insertMovie(movie)
                }
                movies
            }.flowOn(Dispatchers.IO)
    }

    override fun getTrendingMoviesToday(): Flow<List<Movie>> {
        return appDataSource.fetchTrendingMoviesToday()
            .map { response ->
                val movies = response.body()!!.results
                for (movie in movies) {
                    movie.category = Constants.TRENDING_TODAY
                    moviesDao.insertMovie(movie)
                }
                movies
            }.flowOn(Dispatchers.IO)
    }

    override fun discoverActionMovies(): Flow<List<Movie>> {
        return appDataSource.fetchActionMovies()
            .map { response ->
                val movies = response.body()!!.results
                for (movie in movies) {
                    movie.category = Constants.ACTION
                    moviesDao.insertMovie(movie)
                }
                movies
            }
            .flowOn(Dispatchers.IO)
    }

    override fun discoverComedyMovies(): Flow<List<Movie>> {
        return appDataSource.fetchComedyMovies()
            .map { response ->
                val movies = response.body()!!.results
                for (movie in movies) {
                    movie.category = Constants.ACTION
                    moviesDao.insertMovie(movie)
                }
                movies
            }
            .flowOn(Dispatchers.IO)
    }


}