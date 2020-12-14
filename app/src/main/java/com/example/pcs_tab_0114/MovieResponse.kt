package com.example.pcs_tab_0114

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") val results : ArrayList<Movie>,
    @SerializedName("total_pages") val total_pages : Int,
    @SerializedName("page") val page : Int,
    @SerializedName("total_results") val overview : Int
)