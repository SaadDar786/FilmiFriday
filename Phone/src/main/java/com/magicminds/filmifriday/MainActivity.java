package com.magicminds.filmifriday;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.magicminds.filmifriday.Common.Constants;
import com.magicminds.filmifriday.Core.FragmentUtility;
import com.magicminds.filmifriday.Home.View.HomeViewFragment;

/**
 * Created by saaddar on 4/1/18.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        HomeViewFragment homeViewFragment = new HomeViewFragment();
        FragmentUtility.replaceFragment(homeViewFragment, getSupportFragmentManager(),R.id.mainLayout, Constants.HomeViewFragment,true, true);
    }
}
