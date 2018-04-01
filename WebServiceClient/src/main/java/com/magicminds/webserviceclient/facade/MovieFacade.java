package com.magicminds.webserviceclient.facade;


import com.magicminds.webserviceclient.controllers.DiscoverMovies;
import com.magicminds.webserviceclient.controllers.MovieDetail;
import com.magicminds.webserviceclient.controllers.SearchMovies;
import com.magicminds.webserviceclient.shared.WebServiceInterface;

/**
 * Created by saaddar on 3/18/18.
 */

public class MovieFacade {
    private static final MovieFacade ourInstance = new MovieFacade();
    public static MovieFacade getInstance() {
        return ourInstance;
    }

    private MovieFacade() {
    }

    public void discoverMovies(int page, WebServiceInterface callBack){

        DiscoverMovies discover = new DiscoverMovies(page,callBack);
        discover.start();

    }

    public void searchMovies(String key, WebServiceInterface callBack){

        SearchMovies search = new SearchMovies(key,callBack);
        search.start();

    }

    public void detailMovie(String id, WebServiceInterface callBack){

        MovieDetail detail = new MovieDetail(id,callBack);
        detail.start();

    }
}
