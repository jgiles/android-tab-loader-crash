package com.colonialclub.example.crashexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;

public class BazFragment extends Fragment implements LoaderCallbacks<Baz> {

    public BazFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Baz> onCreateLoader(int id, Bundle args) {
        return new BazLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Baz> loader, Baz response) {
        Log.d("BazFragment", "Finished loading.");
    }

    @Override
    public void onLoaderReset(Loader<Baz> loader) {}
}
