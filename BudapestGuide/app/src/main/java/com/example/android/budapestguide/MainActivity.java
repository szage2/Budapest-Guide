package com.example.android.budapestguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.android.budapestguide.R.id.viewpager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        TabsAdapter adapter = new TabsAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tablayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager in order to respond for wiping, selection and setting tab names
        tablayout.setupWithViewPager(viewPager);
    }
}
