package com.gtxtreme.moviesmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.gtxtreme.moviesmvvm.model.Movie;
import com.gtxtreme.moviesmvvm.model.MovieRespository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MovieRespository  movieRespository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        movieRespository = new MovieRespository(application);
    }

    public LiveData<List<Movie>> getAllMovies(){
        return movieRespository.getMutableLiveData();
    }
}
