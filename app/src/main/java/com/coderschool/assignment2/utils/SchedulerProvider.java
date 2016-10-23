package com.coderschool.assignment2.utils;

import android.support.annotation.NonNull;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by duongthoai on 10/23/16.
 */

public class SchedulerProvider implements BaseSchedulerProvider {

    private static SchedulerProvider instance = null;

    public static SchedulerProvider makeInstance() {
        if (instance == null) {
            instance = new SchedulerProvider();
        }
        return instance;
    }

    private SchedulerProvider() {

    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
