package com.example.flixsterplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies, Context context) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.movieTitleView.setText(movie.getTitle());
        holder.descriptionView.setText(movie.getDescription());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath())
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        TextView movieTitleView;
        TextView descriptionView;
        ImageView poster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitleView = itemView.findViewById(R.id.movie_title_text);
            descriptionView = itemView.findViewById(R.id.movie_overview_text);
            poster = itemView.findViewById(R.id.imageView);
        }
    }
}
