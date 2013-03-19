package com.colonialclub.example.crashexample;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class BazLoader extends AsyncTaskLoader<Baz> {

    Baz response;

    public BazLoader(Context context) {
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
    public Baz loadInBackground() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Log.e("BazLoader", e.toString());
        }
        response = new Baz();
        return response;
    }
}
