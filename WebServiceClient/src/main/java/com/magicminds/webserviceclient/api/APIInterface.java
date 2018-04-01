package com.magicminds.webserviceclient.api;

import com.magicminds.webserviceclient.models.discover.Discover;
import com.magicminds.webserviceclient.models.movie.Movie;
import com.magicminds.webserviceclient.models.search.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.magicminds.webserviceclient.shared.Constants.APIKey;
import static com.magicminds.webserviceclient.shared.Constants.DiscoverMovie;
import static com.magicminds.webserviceclient.shared.Constants.DiscoverMovieFullPath;
import static com.magicminds.webserviceclient.shared.Constants.MovieDetail;
import static com.magicminds.webserviceclient.shared.Constants.MovieDetailFullPath;
import static com.magicminds.webserviceclient.shared.Constants.SearchMovie;
import static com.magicminds.webserviceclient.shared.Constants.SearchMovieFullPath;

/**
 * Created by saaddar on 3/18/18.
 */

public interface APIInterface {

    @GET(DiscoverMovie+APIKey+DiscoverMovieFullPath)
    Call<Discover> discoverMovies(@Query("page") String number);

    @GET(SearchMovie+APIKey+SearchMovieFullPath)
    Call<Search> searchMovies(@Path("keyword") String keyword);

    @GET(MovieDetail+APIKey+MovieDetailFullPath)
    Call<Movie> movieDetail(@Path("movie_id") String id);
}
