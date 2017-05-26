package com.example.android.budapestguide;

/**
 * {@link Guidance} represents a list of guidance, containing attractions, events,
 * top places, hidden attractions and some local phrases (translation and audio file) for tourists.
 */

public class Guidance {


    //String resource ID for the (Guidance) attractions, events, top places and phrases
    private String mGuidance;
    //String resource ID for month in which an event is organized or phrase used by locals
    private String mMonthOrPhrase;
    //Image resource ID for Guidance
    private int mImageResourceID;
    //Audio resource ID for phrase (Guidance)
    private int mAudioResourceId;


    /**Create a new Guidance object
     *
     * @param guideline is an attraction, place, hidden attraction or event the user can visit within the City.
     * @param monthOrPhrase is the month in which the particular event is yearly organized or
     *              phrase as used by local people
     * @param imageResourceID is the resource id for picture associated with the guidance / phrase.
     */
    public Guidance(String monthOrPhrase, String guideline, int imageResourceID) {
        mGuidance = guideline;
        mMonthOrPhrase = monthOrPhrase;
        mImageResourceID = imageResourceID;
    }

    /**Create a new Guidance object
     *
     * @param guideline is an attraction, place, hidden attraction or event the user can visit within the City.
     * @param imageResourceID is the resource id for picture associated with the guidance / phrase.
     */
    public Guidance(String guideline, int imageResourceID) {
        mGuidance = guideline;
        mImageResourceID = imageResourceID;
    }

    /**Create a new Guidance object
     *
     * @param guideline is an attraction, place, hidden attraction or event the user can visit within the City.
     * @param monthOrPhrase is the month in which the particular event is yearly organized or
     *              phrase as used by local people
     * @param imageResourceID is the resource id for picture associated with the guidance / phrase.
     * @param audioResourceId is the resource id for audio file containing the particular phrase.
     */
    public Guidance(String monthOrPhrase, String guideline, int imageResourceID, int audioResourceId) {
        mGuidance = guideline;
        mMonthOrPhrase = monthOrPhrase;
        mImageResourceID = imageResourceID;
        mAudioResourceId = audioResourceId;
    }

    //Get the string resource ID for actual Guidance.

    public String getGuidance(){ return mGuidance; }

    //Returns the image resource ID for the Guidance.

    public int getImageResourceID() { return mImageResourceID; }

    //Get the string resource ID (actual month of the event) Guidance.

    public String getMonth() { return mMonthOrPhrase; }

    //Returns the audio resource ID for (phrase) the Guidance.

    public int getAudioResourceId () {return mAudioResourceId; }
}
