package com.magicminds.filmifriday.Core;

import android.view.animation.Animation;

/**
 * Created by saaddar on 3/26/18.
 */

public class FragmentBase extends android.support.v4.app.Fragment {

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (FragmentUtility.sDisableFragmentAnimations) {
            Animation a = new Animation() {};
            a.setDuration(0);
            return a;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }
}
