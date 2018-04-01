package com.magicminds.webserviceclient.controllers;

import com.magicminds.webserviceclient.api.APIClient;
import com.magicminds.webserviceclient.api.APIInterface;
import com.magicminds.webserviceclient.models.discover.Discover;
import com.magicminds.webserviceclient.models.WebServiceResponse;
import com.magicminds.webserviceclient.shared.Constants;
import com.magicminds.webserviceclient.shared.WebServiceInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by saaddar on 3/18/18.
 */

public class DiscoverMovies implements Callback<Discover> {

    private int pageNumber = 0;
    private WebServiceInterface callBack;

    public DiscoverMovies(int page, WebServiceInterface callBack){
        this.pageNumber = page;
        this.callBack = callBack;
    }

    public void start(){


        Retrofit client = APIClient.getInstance().getClient();
        APIInterface apiInterface = client.create(APIInterface.class);
        Call<Discover> call = apiInterface.discoverMovies(pageNumber+"");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Discover> call, Response<Discover> response) {

        if(response.isSuccessful())
            callBack.webServiceCallBack(Constants.CallBackType.DISCOVER_MOVIE, new WebServiceResponse(response.isSuccessful(),response.body(), null));
        else
            callBack.webServiceCallBack(Constants.CallBackType.DISCOVER_MOVIE, new WebServiceResponse(false,null, response.errorBody().toString()));

    }

    @Override
    public void onFailure(Call<Discover> call, Throwable t) {

        callBack.webServiceCallBack(Constants.CallBackType.DISCOVER_MOVIE, new WebServiceResponse(false,null, t.getLocalizedMessage()));

    }
}
