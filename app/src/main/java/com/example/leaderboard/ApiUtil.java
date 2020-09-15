package com.example.leaderboard;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ApiUtil {
    public ApiUtil(){}

    public static final String BASE_API_URL = "https://gadsapi.herokuapp.com/api/";
    public static final String NAME = "name";
    public static final String HOURS = "hours";
    public static final String COUNTRY = "country";
    public static final String SCORE = "score";


    public static URL buildUrl(String title){

        URL url = null;
        Uri uri = Uri.parse(BASE_API_URL).buildUpon()
                .appendPath(title).build();
        try {
            url = new URL(uri.toString());
        }
        catch( Exception e){
            e.printStackTrace();
        }
        return url;
    }
    public static String getJson(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            InputStream stream = connection.getInputStream();
            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\\A");
            boolean hasData = scanner.hasNext();
            if (hasData) {
                return scanner.next();
            } else {
                return null;
            }
        }catch (Exception e){
            Log.d("Error", e.toString());
            return null;
        }
        finally{
            connection.disconnect();
        }
    }
    public static ArrayList<Hours> getHoursFromJson(String json){



        ArrayList<Hours> hours = new ArrayList<Hours>();
        try{
            JSONArray arrayHours = new JSONArray(json);
            int numberLearners = arrayHours.length();
            for(int i=0; i<numberLearners; i++){
                JSONObject learnerHours = arrayHours.getJSONObject(i);
                Hours learner = new Hours(
                        String.valueOf(i),
                        learnerHours.getString(NAME),
                        learnerHours.getString(HOURS),
                        learnerHours.getString(COUNTRY)
                );
              hours.add(learner);
            }

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return hours;
    }

    public static ArrayList<Scores> getScoresFromJson(String json){
        ArrayList<Scores> scores = new ArrayList<Scores>();
        try{
            JSONArray arrayScores = new JSONArray(json);
            int numberLearners = arrayScores.length();
            for(int i=0; i<numberLearners; i++){
                JSONObject learnerScores = arrayScores.getJSONObject(i);
                Scores learner = new Scores(
                        String.valueOf(i),
                        learnerScores.getString(NAME),
                        learnerScores.getString(SCORE),
                        learnerScores.getString(COUNTRY)
                );
                scores.add(learner);
            }

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return scores;

    }

}
