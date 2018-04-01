package com.magicminds.webserviceclient.controllers;

import com.magicminds.webserviceclient.api.APIClient;
import com.magicminds.webserviceclient.api.APIInterface;
import com.magicminds.webserviceclient.models.WebServiceResponse;
import com.magicminds.webserviceclient.models.search.Search;
import com.magicminds.webserviceclient.shared.Constants;
import com.magicminds.webserviceclient.shared.WebServiceInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by saaddar on 3/18/18.
 */

public class SearchMovies implements Callback<Search> {

    private String keyword = "";
    private WebServiceInterface callBack;

    public SearchMovies(String keyword, WebServiceInterface callBack){
        this.keyword = keyword;
        this.callBack = callBack;
    }

    public void start(){

        Retrofit client = APIClient.getInstance().getClient();
        APIInterface apiInterface = client.create(APIInterface.class);

        Call<Search> call = apiInterface.searchMovies(keyword);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Search> call, Response<Search> response) {

        callBack.webServiceCallBack(Constants.CallBackType.SEARCH_MOVIE, new WebServiceResponse(response.isSuccessful(),response.body(), response.errorBody().toString()));

    }

    @Override
    public void onFailure(Call<Search> call, Throwable t) {

        callBack.webServiceCallBack(Constants.CallBackType.SEARCH_MOVIE, new WebServiceResponse(false,null, t.getLocalizedMessage()));

    }
}
