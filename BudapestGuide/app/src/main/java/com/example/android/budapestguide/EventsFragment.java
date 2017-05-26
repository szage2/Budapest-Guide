package com.example.android.budapestguide;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link Fragment} displays a list of events.
 */
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guidance_list, container, false);

        //Create a list of Guidances (and month) for tour guide
        final ArrayList<Guidance> guidances = new ArrayList<>();
        guidances.add(new Guidance(getString(R.string.january), getString(R.string.new_years_concerts), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.january), getString(R.string.folk_music), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.february), getString(R.string.farsang), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.february), getString(R.string.day_of_eating), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.march), getString(R.string.easter), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.march), getString(R.string.st_patric), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.april), getString(R.string.palinka_fest), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.april), getString(R.string.spring_fest), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.april), getString(R.string.cherry_blossom), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.may), getString(R.string.gourmet), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.may), getString(R.string.labor_day), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.may), getString(R.string.may_fest), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.may), getString(R.string.beer_fest), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.may), getString(R.string.jazz), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.june), getString(R.string.open_museums), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.june), getString(R.string.carnival), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.june), getString(R.string.wagner_fest), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.july), getString(R.string.air_race), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.july), getString(R.string.summer_fest), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.july), getString(R.string.pride), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.july), getString(R.string.hungaroring), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.august), getString(R.string.sziget), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.august), getString(R.string.stephen), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.september), getString(R.string.jewish_fest), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.september), getString(R.string.half_marathon), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.september), getString(R.string.gallop), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.october), getString(R.string.halloween), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.october), getString(R.string.organ_concert), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.october), getString(R.string.whisky), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.november), getString(R.string.gastro_fair), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.november), getString(R.string.wine_and_cheese_fest), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.december), getString(R.string.christmas_markets), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.december), getString(R.string.gipsy_band), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.december), getString(R.string.new_year), R.drawable.basic));

        // Create an {@link GuidanceAdapter}, whose data source is a list of {@link Guidance}s. The
        // adapter knows how to create list items for each item in the list.
        GuidanceAdapter adapter = new GuidanceAdapter(getActivity(), guidances, R.color.list_item_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // guidance_list.xml layout file.
        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link GuidanceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Guidance} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to initiate a search with the guidance when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Find the main layout(Relative Layout) based on the position of the Item Click
                RelativeLayout mainLayout = (RelativeLayout) parent.getChildAt(position);
                // Find the Linear layout within the main Layout as it's second Child element
                LinearLayout secondaryLayout = (LinearLayout) mainLayout.getChildAt(1);
                // Find the desired TextView within the Linear Layout as it's first Child element.
                TextView guidanceTextView = (TextView) secondaryLayout.getChildAt(0);
                // Make it possible to use it (the guidance) as a String variable.
                String query = guidanceTextView.getText().toString();

                // Create an intent to initiate a search through browser or search app
                Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                // Using the Search Manager.QUERY to be able to use the guidance as the query for the search
                searchIntent.putExtra(SearchManager.QUERY, query);
                // Start the activity.
                startActivity(searchIntent);
            }
        });

        return rootView;
    }

}
