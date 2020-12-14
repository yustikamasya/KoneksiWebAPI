package com.example.pcs_tab_0114.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pcs_tab_0114.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlayingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View
        view = inflater.inflate(R.layout.fragment_playing, container, false)

        var rvMovie : RecyclerView
        rvMovie = view.findViewById(R.id.rv_movie)

        rvMovie.setHasFixedSize(true)
        rvMovie.layoutManager = LinearLayoutManager(context)

        val service = ApiClient.create()
        service.getPlayingMovie("d58845c9d53da3e216a0a21300e1e90a").enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movieList:ArrayList<Movie>
                if (response.isSuccessful){
                    movieList = response.body()?.results!!
                    val movieAdapter = MovieAdapter(movieList)
                    rvMovie.adapter = movieAdapter

                }

            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("tag","errornya ${t.message}")
            }
        })


        return view
    }


}