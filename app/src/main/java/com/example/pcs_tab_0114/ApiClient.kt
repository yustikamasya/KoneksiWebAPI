package com.example.pcs_tab_0114



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

        val BASE_URL = "https://api.themoviedb.org/"

        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
    }
    }
