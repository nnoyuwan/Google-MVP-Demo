package com.example.jy.google_mvp_demo.util;

import android.support.test.espresso.IdlingResource;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/9/27 14:43
 * Created by JY
 */

public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";

    private static SimpleCountingIdlingResource mCountingIdlingResource =
            new SimpleCountingIdlingResource(RESOURCE);

    public static void increment() {
        mCountingIdlingResource.increment();
    }

    public static void decrement() {
        mCountingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource() {
        return mCountingIdlingResource;
    }
}
