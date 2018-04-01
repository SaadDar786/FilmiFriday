package com.magicminds.filmifriday.Home.DI;

import com.magicminds.filmifriday.Home.Model.HomeModel;
import com.magicminds.filmifriday.Home.Presenter.HomeContract;
import com.magicminds.filmifriday.Home.Presenter.HomePresenter;
import com.magicminds.filmifriday.Home.View.HomeViewFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by saaddar on 3/24/18.
 */

@Module
public class HomeModule {

    @Provides
    HomeModel provideHomeModel() {
        return new HomeModel();
    }

}
