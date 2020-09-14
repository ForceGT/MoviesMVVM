package com.gtxtreme.moviesmvvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gtxtreme.moviesmvvm.R;
import com.gtxtreme.moviesmvvm.databinding.MoviesRvItemBinding;
import com.gtxtreme.moviesmvvm.model.Movie;
import com.gtxtreme.moviesmvvm.view.MovieDetail;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{

    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MoviesAdapter(Context context, ArrayList<Movie> movies){
        this.context = context;
        movieArrayList = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate();
        MoviesRvItemBinding moviesRvItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.movies_rv_item,parent,false);
        return new MovieViewHolder(moviesRvItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {


        Movie movie =movieArrayList.get(position);
        holder.moviesRvItemBinding.setMovie(movie);
//        holder.movieRating.setText(Double.toString(movieArrayList.get(position).getVoteAverage()));
//        holder.movieTitle.setText(movieArrayList.get(position).getOriginalTitle());
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        private MoviesRvItemBinding moviesRvItemBinding;


        public MovieViewHolder(MoviesRvItemBinding moviesRvItemBinding) {
            super(moviesRvItemBinding.getRoot());
            this.moviesRvItemBinding = moviesRvItemBinding;
//            movieBanner = itemView.findViewById(R.id.ivMovie);
//            movieTitle = itemView.findViewById(R.id.tvTitle);
//            movieRating = itemView.findViewById(R.id.tvRating);

            moviesRvItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position!=RecyclerView.NO_POSITION){
                        Movie movie = movieArrayList.get(position);

                        Intent intent = new Intent(context, MovieDetail.class);
                        intent.putExtra("movie",movie);
                        context.startActivity(intent);
                    }


                }
            });



        }
    }
}
