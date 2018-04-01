package com.magicminds.filmifriday.Home.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.magicminds.filmifriday.Core.FragmentBase;
import com.magicminds.filmifriday.Home.DI.DaggerHomeComponent;
import com.magicminds.filmifriday.Home.Presenter.HomeContract;
import com.magicminds.filmifriday.Home.Presenter.HomePresenter;
import com.magicminds.filmifriday.R;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by saaddar on 3/24/18.
 */

public class HomeViewFragment extends FragmentBase implements HomeContract.HomeView {

    @Inject
    HomePresenter homePresenter;

    private ListView movieList;
    private ProgressBar progressBar;
    private TextView errorMessage;
    private DiscoverMovieAdapter movieAdpter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);
        return view;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        errorMessage.setText(message);
        errorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateDiscoverMovies(List movies) {

        movieAdpter.updateMovieList(movies);
    }

    private void initView(View view){
        DaggerHomeComponent.create().inject(this);
        homePresenter.bind(this);


        movieList = (ListView) view.findViewById(R.id.listView);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        errorMessage = (TextView) view.findViewById(R.id.errView);
        movieAdpter = new DiscoverMovieAdapter(getContext(),-1);
        movieList.setAdapter(movieAdpter);

        homePresenter.performDiscoverMovies();
    }

    @Override
    public void onDestroy() {
        homePresenter.unbind();
        super.onDestroy();
    }
}
