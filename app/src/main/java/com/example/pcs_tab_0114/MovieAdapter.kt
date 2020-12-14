package com.example.pcs_tab_0114

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class MovieAdapter(private val listMovie:ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (movie: Movie){
            with(itemView){
                txtTitle.text = movie.title
                txtYear.text= movie.release_date
                txtOverview.text = movie.overview

                Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w200/"+movie.poster_path)
                    .into(imgPoster)
            }
        }

    }
}