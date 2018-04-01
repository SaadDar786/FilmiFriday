package com.magicminds.filmifriday.Core;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.magicminds.filmifriday.R;

/**
 * Created by saaddar on 3/26/18.
 */

public final class FragmentUtility {


    public static boolean sDisableFragmentAnimations = false;

    public static void replaceFragment(Fragment fragment, FragmentManager fragmentManager, int resourceId,
                                       String tag, boolean addtoBackStack ,boolean  animate){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(addtoBackStack)
            fragmentTransaction.addToBackStack(tag);

        if(animate)
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);

        fragmentTransaction.replace(resourceId,fragment,tag);
        fragmentTransaction.commit();


    }

    public static void replaceFragment(Fragment fragment, FragmentManager fragmentManager,
                                       String tag, boolean addtoBackStack){

        FragmentUtility.replaceFragment(fragment,fragmentManager,R.id.mainLayout, tag, addtoBackStack, true);
    }

    public static void popFragemnt(FragmentManager fragmentManager, String tag, boolean animate){

        if(animate)
            fragmentManager.popBackStack(tag,fragmentManager.POP_BACK_STACK_INCLUSIVE);
        else{
            FragmentUtility.popBackStackWithoutAnimation(fragmentManager);
        }
    }

    public static void popBackStackWithoutAnimation(FragmentManager fragmentManager){
        FragmentUtility.sDisableFragmentAnimations = true;
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentUtility.sDisableFragmentAnimations = false;
    }

}
