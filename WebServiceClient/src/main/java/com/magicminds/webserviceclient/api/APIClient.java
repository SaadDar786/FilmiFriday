package com.magicminds.webserviceclient.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.magicminds.webserviceclient.shared.Constants.BaseURL;

/**
 * Created by saaddar on 3/18/18.
 */

public class APIClient {
    private static final APIClient ourInstance = new APIClient();
    private static Retrofit retrofit = null;

    public static APIClient getInstance() {
        return ourInstance;
    }

    private APIClient() {
    }

    public Retrofit getClient() {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        return retrofit;
    }
}
