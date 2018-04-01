package com.magicminds.webserviceclient.controllers;

import com.magicminds.webserviceclient.api.APIClient;
import com.magicminds.webserviceclient.api.APIInterface;
import com.magicminds.webserviceclient.models.WebServiceResponse;
import com.magicminds.webserviceclient.models.movie.Movie;
import com.magicminds.webserviceclient.shared.Constants;
import com.magicminds.webserviceclient.shared.WebServiceInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by saaddar on 3/18/18.
 */

public class MovieDetail implements Callback <Movie> {

    private String movieId = "";
    private WebServiceInterface callBack;

    public MovieDetail(String id, WebServiceInterface callBack){
        this.movieId = id;
        this.callBack = callBack;
    }

    public void start(){

        Retrofit client = APIClient.getInstance().getClient();
        APIInterface apiInterface = client.create(APIInterface.class);

        Call<Movie> call = apiInterface.movieDetail(movieId);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Movie> call, Response<Movie> response) {

        callBack.webServiceCallBack(Constants.CallBackType.DETAIL_MOVIE, new WebServiceResponse(response.isSuccessful(),response.body(), response.errorBody().toString()));

    }

    @Override
    public void onFailure(Call<Movie> call, Throwable t) {

        callBack.webServiceCallBack(Constants.CallBackType.DETAIL_MOVIE, new WebServiceResponse(false,null, t.getLocalizedMessage()));


    }
}
