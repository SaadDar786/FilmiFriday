package com.magicminds.filmifriday.Home.Presenter;

import com.magicminds.filmifriday.Home.Model.HomeModel;
import com.magicminds.webserviceclient.models.WebServiceResponse;
import com.magicminds.webserviceclient.models.discover.Discover;

import javax.inject.Inject;

/**
 * Created by saaddar on 3/24/18.
 */

public class HomePresenter implements  HomeContract.HomePresenter, HomeContract.HomeInteractor {

    private HomeContract.HomeView homeView;
    private HomeModel homeModel;
    private int pageCount = 1;


    @Inject
    public HomePresenter(HomeModel model){
        this.homeModel = model;
    }

    @Override
    public void performDiscoverMovies() {

        homeView.showProgress();
        homeModel.performDiscoverMovies(pageCount,this);
    }

    public void bind(HomeContract.HomeView view){
        this.homeView = view;
    }

    public void unbind(){
        this.homeView = null;
    }

    @Override
    public void discoverMovies(WebServiceResponse response) {

        homeView.hideProgress();
        if(response.isResponseSuccessful()){
            Discover discoverMovieResponse = ((Discover)response.getResult());
            homeView.updateDiscoverMovies(discoverMovieResponse.results);
        }
        else {

            homeView.showMessage(response.getErrorMessage());
        }


    }
}
