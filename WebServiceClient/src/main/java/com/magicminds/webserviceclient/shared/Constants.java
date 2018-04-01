package com.magicminds.webserviceclient.shared;

/**
 * Created by saaddar on 3/18/18.
 */

public class Constants {

    public static final String BaseURL = "https://api.themoviedb.org/";

    public static final String APIKey = "?api_key=6e4787401a7d41a5f4f52795177dc76a";

    public static final String SearchMovie = "3/search/movie";
    public static final String SearchMovieFullPath = "&language=en-US&query={keyword}&page=1&include_adult=false";

    public static final String DiscoverMovie = "3/discover/movie";
    public static final String DiscoverMovieFullPath = "&language=en-US&sort_by=popularity.desc&include_adult=false&ß";

    public static final String MovieDetail = "3/movie/{movie_id}";
    public static final String MovieDetailFullPath = "&language=en-US";


    public enum CallBackType {
        DISCOVER_MOVIE,
        SEARCH_MOVIE,
        DETAIL_MOVIE
    }
}
