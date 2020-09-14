package com.gtxtreme.moviesmvvm.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.gtxtreme.moviesmvvm.R;
import com.gtxtreme.moviesmvvm.services.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRespository {

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRespository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        Call<MovieDBResponse> call = RetrofitInstance.getInstance().getPopular(application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<MovieDBResponse>() {
            @Override
            public void onResponse(Call<MovieDBResponse> call, Response<MovieDBResponse> response) {
                MovieDBResponse movieDBResponse = response.body();
                if (movieDBResponse!=null && movieDBResponse.getMovies()!=null){
                    movies = (ArrayList<Movie>)movieDBResponse.getMovies();
                }
                mutableLiveData.setValue(movies);
            }

            @Override
            public void onFailure(Call<MovieDBResponse> call, Throwable t) {

            }
        });

        return mutableLiveData;

    }
}
