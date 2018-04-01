package com.magicminds.filmifriday.Home.DI;
import com.magicminds.filmifriday.Home.View.HomeViewFragment;

import dagger.Component;

/**
 * Created by saaddar on 3/24/18.
 */

@Component(modules = {HomeModule.class})
public interface HomeComponent {

    void inject(HomeViewFragment viewFragment);
}
