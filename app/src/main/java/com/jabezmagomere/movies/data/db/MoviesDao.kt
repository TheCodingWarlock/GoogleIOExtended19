package com.jabezmagomere.movies.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface MoviesDao {
    @Query("SELECT * FROM Movies WHERE category=:category")
    fun getAllMovies(category:String): Flowable<List<Movie>>

    @Query("DELETE FROM Movies")
    suspend fun clearMovies()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Insert
    suspend fun insertMovies(movie: List<Movie>)

    @Query("SELECT COUNT(*) FROM Movies WHERE category =:category")
    suspend fun getNumberOfMovies(category: String): Int

}