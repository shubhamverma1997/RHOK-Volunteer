package com.example.android.volunteer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by shubham on 7/15/17.
 */

public class Utilities {


    public static ArrayList<ngo> parse(String json) {
        ArrayList<ngo> values = new ArrayList<ngo>();

        try {
            JSONArray mess = new JSONArray(json);
            for (int i = 0; i < mess.length(); i++) {
                JSONObject obj = mess.optJSONObject(i);
                String title = obj.getString("title");
                String desc = obj.getString("description");
                JSONObject ngoInfo = obj.getJSONObject("ngo");
                String ngoName = ngoInfo.getString("name");
                String eventDate = obj.getString("eventDate");
                int id=obj.getInt("id");

                SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                long dateInMilli = dateParser.parse(eventDate).getTime();
                long posixDate = dateInMilli/1000;

                String imageUrl = obj.getString("image");
                //for (int j=0;j<10;j++)
                values.add(new ngo(title, desc, imageUrl, ngoName, 10, new String[]{""}
                        , new int[]{0}, posixDate,System.currentTimeMillis() / 1000L,id));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return values;
    }
}
