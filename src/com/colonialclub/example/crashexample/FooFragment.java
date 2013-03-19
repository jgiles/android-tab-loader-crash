package com.colonialclub.example.crashexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;

public class FooFragment extends Fragment implements LoaderCallbacks<Foo> {

    public FooFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Foo> onCreateLoader(int id, Bundle args) {
        return new FooLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Foo> loader, Foo response) {
        Log.d("FooFragment", "Finished loading.");
    }

    @Override
    public void onLoaderReset(Loader<Foo> loader) {}
}
