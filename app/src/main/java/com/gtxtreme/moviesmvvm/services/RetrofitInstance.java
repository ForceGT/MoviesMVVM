package com.gtxtreme.moviesmvvm.services;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    public static MovieDataService  getInstance(){
        if(retrofit == null){
            String BASE_URL = "https://api.themoviedb.org/3/";
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MovieDataService.class);
    }
}
