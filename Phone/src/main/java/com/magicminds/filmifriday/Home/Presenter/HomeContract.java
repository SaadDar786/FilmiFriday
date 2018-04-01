package com.magicminds.filmifriday.Home.Presenter;

import com.magicminds.webserviceclient.models.WebServiceResponse;

import java.util.List;

/**
 * Created by saaddar on 3/24/18.
 */

public interface HomeContract {

    interface HomePresenter {

        void performDiscoverMovies();
    }

    interface HomeView {

        void showProgress();
        void hideProgress();
        void showMessage(String message);
        void updateDiscoverMovies(List movies);

    }

    interface HomeModel {

        void performDiscoverMovies(int page, HomeInteractor callBack);
    }

    interface HomeInteractor {

        void discoverMovies(WebServiceResponse response);
    }
}
