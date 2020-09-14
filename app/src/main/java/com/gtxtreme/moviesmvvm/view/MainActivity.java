package com.gtxtreme.moviesmvvm.view;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gtxtreme.moviesmvvm.R;
import com.gtxtreme.moviesmvvm.adapter.MoviesAdapter;
import com.gtxtreme.moviesmvvm.databinding.ActivityMainBinding;
import com.gtxtreme.moviesmvvm.model.Movie;
import com.gtxtreme.moviesmvvm.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movies;
    RecyclerView recyclerView;
    MoviesAdapter moviesAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    MainActivityViewModel mainActivityViewModel;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        //mainActivityViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainActivityViewModel.class);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        Objects.requireNonNull(getSupportActionBar()).setTitle("Popular Movies");
        getPopularMovies();
        swipeRefreshLayout = activityMainBinding.swipeRefreshLayout;

//        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
//        swipeRefreshLayout.setColorSchemeColors(this.getColor(R.color.colorPrimary));
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                getPopularMovies();
//            }
//        });
    }

    private void getPopularMovies() {
        mainActivityViewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                movies = (ArrayList<Movie>)moviesFromLiveData;
                showRecyclerView();
            }
        });


    }

    public void showRecyclerView() {
        recyclerView = activityMainBinding.rvMovies;
        moviesAdapter = new MoviesAdapter(this, movies);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        else
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);
        moviesAdapter.notifyDataSetChanged();
    }


}