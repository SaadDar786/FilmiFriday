package com.magicminds.filmifriday.Home.Model;

import com.magicminds.filmifriday.Home.Presenter.HomeContract;
import com.magicminds.webserviceclient.facade.MovieFacade;
import com.magicminds.webserviceclient.models.WebServiceResponse;
import com.magicminds.webserviceclient.shared.Constants;
import com.magicminds.webserviceclient.shared.WebServiceInterface;

/**
 * Created by saaddar on 3/24/18.
 */

public class HomeModel implements HomeContract.HomeModel, WebServiceInterface {


    private HomeContract.HomeInteractor callBack;

    @Override
    public void performDiscoverMovies(int page, HomeContract.HomeInteractor callBack) {

        this.callBack = callBack;
        MovieFacade.getInstance().discoverMovies(page, this);
    }

    @Override
    public void webServiceCallBack(Constants.CallBackType callBackType, Object o) {

        if(callBackType == Constants.CallBackType.DISCOVER_MOVIE) {
            this.callBack.discoverMovies((WebServiceResponse)o);
        }
    }
}
