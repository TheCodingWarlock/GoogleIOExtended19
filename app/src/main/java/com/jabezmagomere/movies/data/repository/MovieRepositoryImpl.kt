package com.jabezmagomere.movies.data.repository

import androidx.lifecycle.LiveData
import com.jabezmagomere.movies.data.db.MoviesDao
import com.jabezmagomere.movies.data.db.Movie
import com.jabezmagomere.movies.data.network.AppDataSource
import com.jabezmagomere.movies.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(private val appDataSource: AppDataSource, private val moviesDao: MoviesDao) :
    MovieRepository {
    override suspend fun getTrendingMoviesThisWeek(): LiveData<List<Movie>> {
        if (moviesDao.getAllMovies(Constants.TRENDING_THIS_WEEK).value.isNullOrEmpty()) {
            val movieResponse = appDataSource.fetchTrendingMoviesThisWeek()
            movieResponse.collect { response ->
                if (response.isSuccessful) {
                    response.body()?.results?.forEach { movie ->
                        movie.category = Constants.TRENDING_THIS_WEEK
                        moviesDao.insertMovie(movie)
                    }
                }

            }
        }
        return moviesDao.getAllMovies(Constants.TRENDING_THIS_WEEK)
    }

    override suspend fun getTrendingMoviesToday(): LiveData<List<Movie>> {
        if (moviesDao.getAllMovies(Constants.TRENDING_TODAY).value.isNullOrEmpty()) {
            val movieResponse = appDataSource.fetchTrendingMoviesToday()
            movieResponse.collect { response ->
                if (response.isSuccessful) {
                    response.body()?.results?.forEach { movie ->
                        movie.category = Constants.TRENDING_TODAY
                        moviesDao.insertMovie(movie)
                    }
                }
            }
        }
        return moviesDao.getAllMovies(Constants.TRENDING_TODAY)

    }

    override suspend fun discoverActionMovies(): LiveData<List<Movie>> {
        val movieResponse = appDataSource.fetchActionMovies()
        movieResponse.collect { response ->
            if (response.isSuccessful) {
                response.body()?.results?.forEach { movie ->
                    movie.category = Constants.ACTION
                    moviesDao.insertMovie(movie)
                }
            }
        }

        return moviesDao.getAllMovies(Constants.ACTION)
    }

    override suspend fun discoverComedyMovies(): LiveData<List<Movie>> {
        val movieResponse = appDataSource.fetchComedyMovies()
        movieResponse.collect { response ->
            if (response.isSuccessful) {
                response.body()?.results?.forEach { movie ->
                    movie.category = Constants.COMEDY
                    moviesDao.insertMovie(movie)
                }
            }
        }

        return moviesDao.getAllMovies(Constants.COMEDY)
    }


}