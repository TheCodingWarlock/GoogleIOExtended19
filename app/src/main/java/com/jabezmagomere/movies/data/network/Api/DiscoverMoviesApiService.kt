package com.jabezmagomere.movies.data.network.Api

import com.jabezmagomere.movies.data.models.MovieApiResponse
import com.jabezmagomere.movies.data.network.FlowCallAdapterFactory
import com.jabezmagomere.movies.data.network.Interceptors.Connectivity.ConnectivityInterceptor
import com.jabezmagomere.movies.data.network.Interceptors.Authentication.DiscoverAuthenticatorInterceptor
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DiscoverMoviesApiService {

    @GET("discover/movie?with_genres=28&sort_by=vote_average.desc&vote_count.gte=10")
    fun fetchActionMovies():Flow<retrofit2.Response<MovieApiResponse>>

    @GET("discover/movie?with_genres=35&sort_by=vote_average.desc&vote_count.gte=10")
    fun fetchComedyMovies():Flow<retrofit2.Response<MovieApiResponse>>

    companion object {
        operator fun invoke(discoverAuthenticatorInterceptor: DiscoverAuthenticatorInterceptor, connectivityInterceptor: ConnectivityInterceptor): DiscoverMoviesApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(discoverAuthenticatorInterceptor)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.themoviedb.org/3/")
                .addCallAdapterFactory(FlowCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DiscoverMoviesApiService::class.java)
        }
    }
}