package com.colonialclub.example.crashexample;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.LoaderManager;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    /** Specifies tab structure. */
    private final TabSpectification[] tabs = {new TabSpectification(FooFragment.class, "Foo"),
            new TabSpectification(BazFragment.class, "Baz"),
            new TabSpectification(BarFragment.class, "Bar"),};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoaderManager.enableDebugLogging(true);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new TabPageAdapter(fragmentManager));
        viewPager.setOnPageChangeListener(new ActionBarPageChangeListener());

        ViewPagerTabListener tabListener = new ViewPagerTabListener(viewPager);

        // Add tabs.
        for (int i = 0; i < tabs.length; i++) {
            actionBar.addTab(tabs[i].createTab().setTabListener(tabListener));
        }
    }

    /** Class to specify individual tab attributes and create tabs. */
    private class TabSpectification {
        final private Class<? extends Fragment> fragmentClass;
        final private String text;

        public TabSpectification(Class<? extends Fragment> fragmentClass, String text) {
            this.fragmentClass = fragmentClass;
            this.text = text;
        }

        /** @return A tab created according to this specification. */
        public ActionBar.Tab createTab() {
            return getActionBar().newTab().setText(text);
        }
    }

    /** Wires pages to fragments according to tab specifications. */
    private class TabPageAdapter extends FragmentPagerAdapter {
        private final Fragment[] fragments;

        public TabPageAdapter(FragmentManager fm) {
            super(fm);
            fragments = new Fragment[tabs.length];
            for (int i = 0; i < tabs.length; i++) {
                fragments[i] =
                        Fragment.instantiate(MainActivity.this, tabs[i].fragmentClass.getName());
            }
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }
    }

    /** Maps page changes (swipes) to tab selections on the action bar. */
    private class ActionBarPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            getActionBar().setSelectedNavigationItem(position);
        }
    }

    /** Makes tab selections display the corresponding page. */
    private class ViewPagerTabListener implements ActionBar.TabListener {
        private final ViewPager viewPager;

        public ViewPagerTabListener(ViewPager viewPager) {
            this.viewPager = viewPager;
        }

        @Override
        public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {}

        @Override
        public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {}
    }

}
