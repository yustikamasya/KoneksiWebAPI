package com.example.pcs_tab_0114

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/now_playing")
    fun getPlayingMovie(@Query("api_key") apiKey: String?): Call<MovieResponse>
}