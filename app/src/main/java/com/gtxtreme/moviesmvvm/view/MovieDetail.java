package com.gtxtreme.moviesmvvm.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.gtxtreme.moviesmvvm.R;
import com.gtxtreme.moviesmvvm.databinding.ActivityMovieDetailBinding;
import com.gtxtreme.moviesmvvm.model.Movie;


public class MovieDetail extends AppCompatActivity {
    Movie movie;
    ActivityMovieDetailBinding activityMovieDetailBinding;
//    private ImageView movieBannerLarge;
//    private String imagePath;
//    private TextView movieTitle, movieRating, movieSynopsis, movieReleaseDte;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        activityMovieDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie_detail);
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Intent intent = getIntent();
        if (intent.hasExtra("movie")) {
            movie = intent.getParcelableExtra("movie");
            activityMovieDetailBinding.setMovie(movie);
//            if (movie != null) {
//                imagePath = "https://image.tmdb.org/t/p/w500/".concat(movie.getPosterPath());
//                Glide.with(this)
//                        .load(imagePath)
//                        .into(movieBannerLarge);
//                Objects.requireNonNull(getSupportActionBar()).setTitle(movie.getTitle());
//                movieSynopsis.setText(movie.getOverview());
//                movieTitle.setText(movie.getOriginalTitle());
//                movieRating.setText(Double.toString(movie.getVoteAverage()));
//                movieReleaseDte.setText(movie.getReleaseDate());
//            }
        }

    }
}
