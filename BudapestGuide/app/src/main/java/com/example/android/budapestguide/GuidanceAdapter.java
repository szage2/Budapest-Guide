package com.example.android.budapestguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * {@link GuidanceAdapter} is an {@link ArrayAdapter} which is able to provide the layout for each list item
 * according to the data source, what is an actual list of {@link Guidance} objects.
 */

public class GuidanceAdapter extends ArrayAdapter<Guidance>{

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link GuidanceAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param guidances is the list of {@link Guidance}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of guidances.
     */
    public GuidanceAdapter(Activity context, ArrayList<Guidance> guidances, int colorResourceId) {
        super(context, 0, guidances);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Get the {@link Guidance} object located at this position in the list
        Guidance currentGuidance = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID attraction_or_phrase_text_view.
        TextView guidanceTextView = (TextView) listItemView.findViewById(R.id.attraction_or_phrase_text_view);

        // Get the attractions/places/events/phrases from the currentGuidance object and set this text on
        // the guidance TextView.
        guidanceTextView.setText(currentGuidance.getGuidance());

        // Find the TextView in the list_item.xml layout with the ID month_or_phrase_text_view.
        TextView monthOrPhraseTextView = (TextView)  listItemView.findViewById(R.id.month_or_phrase_text_view);

        //Get the month/phrase from the currentGuidance object and set this text on
        // the monthOrPhrase TextView.
        monthOrPhraseTextView.setText(currentGuidance.getMonth());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //Display the image (associated with the guidance) based on the resource ID.
        imageView.setImageResource(currentGuidance.getImageResourceID());
        // Make sure the view is visible
        imageView.setVisibility(View.VISIBLE);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the list item layout so that it can be shown in the ListView.
        return listItemView;
    }
}
