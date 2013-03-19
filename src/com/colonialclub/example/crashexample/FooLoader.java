package com.colonialclub.example.crashexample;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class FooLoader extends AsyncTaskLoader<Foo> {

    Foo response;

    public FooLoader(Context context) {
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
    public Foo loadInBackground() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Log.e("FooLoader", e.toString());
        }
        response = new Foo();
        return response;
    }
}
