package com.colonialclub.example.crashexample;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class BarLoader extends AsyncTaskLoader<Bar> {

    Bar response;

    public BarLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (response != null) {
            deliverResult(response);
        } else {
            forceLoad();
        }
    }

    @Override
    public Bar loadInBackground() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Log.e("BarLoader", e.toString());
        }
        response = new Bar();
        return response;
    }
}
