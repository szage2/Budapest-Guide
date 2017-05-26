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
 * {@link Fragment} displays a list of top places.
 */
public class TopPlacesFragment extends Fragment {

    public TopPlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guidance_list, container, false);

        //Create a list of Guidances for tour guide
        final ArrayList<Guidance> guidances = new ArrayList<>();
        guidances.add(new Guidance(getString(R.string.szimpla_kert), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.sirius), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.onyx), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.gerbeaud), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.cafe_factory), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.hrabal), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.bors), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.vakeger), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.zeller), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.cserpes), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.frei), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.gundel), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.szimpla_bar), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.bagolyvar), R.drawable.basic));
        guidances.add(new Guidance(getString(R.string.kandallo), R.drawable.basic));

        // Create an {@link GuidanceAdapter}, whose data source is a list of {@link Guidance}s. The
        // adapter knows how to create list items for each item in the list.
        GuidanceAdapter adapter = new GuidanceAdapter(getActivity(), guidances, R.color.list_item_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // guidance_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

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
                // Find the desired TextView within the Linear Layout as it's second Child element.
                TextView guidanceTextView = (TextView) secondaryLayout.getChildAt(1);
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
