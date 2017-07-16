package com.example.android.volunteer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String TAG="Main Activity";

    public String JSONresponse;

    public ListView listView;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngo_event_list);

        context=this;
        listView=(ListView) findViewById(R.id.event_list);

        ArrayList<ngo> values=new ArrayList<ngo>();

        Bitmap image= BitmapFactory.decodeResource(getResources(),R.drawable.demo);



        // Tag used to cancel the request
        String  tag_string_req = "string_req";

        String url = "https://hacking2-gigapro.c9users.io/project";

        StringRequest strReq = new StringRequest(Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                JSONresponse=response;
                NgoAdapter ngoAdapter=new NgoAdapter(context,Utilities.parse(JSONresponse));
                listView.setAdapter(ngoAdapter);
                listView.setEmptyView(findViewById(R.id.empty));


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.getMessage());
            }
        });

// Adding request to request queue
        VolunteerApp.getInstance().addToRequestQueue(strReq, tag_string_req);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:
                startActivity(new Intent(this, add.class));
                return true;
            case R.id.certificates:
                startActivity(new Intent(this,Certificates.class));
            default:
                return super.onOptionsItemSelected(item);
        }
        //respond to menu item selection

    }
}
