package com.gtxtreme.moviesmvvm.services;
import com.gtxtreme.moviesmvvm.model.MovieDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {

    @GET("movie/popular")
    Call<MovieDBResponse> getPopular(@Query("api_key")String apiKey);

}
