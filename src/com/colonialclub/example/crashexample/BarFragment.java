package com.colonialclub.example.crashexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;

public class BarFragment extends Fragment implements LoaderCallbacks<Bar> {

    public BarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Bar> onCreateLoader(int id, Bundle args) {
        return new BarLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Bar> loader, Bar response) {
        Log.d("BarFragment", "Finished loading.");
    }

    @Override
    public void onLoaderReset(Loader<Bar> loader) {}
}
