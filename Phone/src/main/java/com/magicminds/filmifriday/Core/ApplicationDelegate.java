package com.magicminds.filmifriday.Core;

import android.app.Application;
import android.content.res.Configuration;

import com.magicminds.webserviceclient.shared.Constants;
import com.magicminds.webserviceclient.shared.WebServiceInterface;

/**
 * Created by saaddar on 3/18/18.
 */

public class ApplicationDelegate extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here!
    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}
