package com.magicminds.webserviceclient.models.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.magicminds.webserviceclient.models.discover.Result;

import java.util.List;

/**
 * Created by saaddar on 3/18/18.
 */

public class Search {

    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("total_results")
    @Expose
    public Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("results")
    @Expose
    public List<Result> results = null;
}
