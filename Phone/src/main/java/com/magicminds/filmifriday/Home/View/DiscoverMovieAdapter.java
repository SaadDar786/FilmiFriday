package com.magicminds.filmifriday.Home.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.magicminds.filmifriday.R;
import com.magicminds.webserviceclient.models.discover.Result;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by saaddar on 3/31/18.
 */

public class DiscoverMovieAdapter extends ArrayAdapter<List<Result>> {

    private List<Result> mData = new ArrayList<>();

    public DiscoverMovieAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        Result movie = mData.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.discover_movie_listview_item, null);
            holder = new ViewHolder();

            holder.movieImage = (ImageView) convertView.findViewById(R.id.movieImage);
            holder.movieName = (TextView) convertView.findViewById(R.id.movieName);
            holder.movieShortDescription = (TextView) convertView.findViewById(R.id.movieShortDescription);
            holder.movieRating = (TextView) convertView.findViewById(R.id.movieRating);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if(movie != null){
            //holder.movieImage
            holder.movieName.setText(movie.title);
            holder.movieShortDescription.setText(movie.overview);
            holder.movieRating.setText(movie.releaseDate);
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    static class ViewHolder {

        public TextView movieName;
        public TextView movieShortDescription;
        public TextView movieRating;
        public ImageView movieImage;
        public int position;
    }

    public void updateMovieList(List<Result> list){
        mData.addAll(list);
        this.notifyDataSetChanged();
    }
}
