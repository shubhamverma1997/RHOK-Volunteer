package com.example.android.volunteer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngo_event_list);

        ListView listView=(ListView) findViewById(R.id.event_list);

        ArrayList<ngo> values=new ArrayList<ngo>();

        Bitmap image= BitmapFactory.decodeResource(getResources(),R.drawable.demo);
        values.add(new ngo("Spot Fix in Gurgaon","A spot fixing is beingorganised in Gurgaon ." +
                " All the people are requested to support our cause .",image,"Udaan",20,new String[]{"Social","Technician"}
                ,new int[]{10,20},1500129442,1500129440));
        values.add(new ngo("Spot Fix in Gurgaon","A spot fixing is beingorganised in Gurgaon ." +
                " All the people are requested to support our cause .",image,"Udaan",20,new String[]{"Social","Technician"}
                ,new int[]{10,20},1500129442,1500129440));
        values.add(new ngo("Spot Fix in Gurgaon","A spot fixing is beingorganised in Gurgaon ." +
                " All the people are requested to support our cause .",image,"Udaan",20,new String[]{"Social","Technician"}
                ,new int[]{10,20},1500129442,1500129440));
        values.add(new ngo("Spot Fix in Gurgaon","A spot fixing is beingorganised in Gurgaon ." +
                " All the people are requested to support our cause .",image,"Udaan",20,new String[]{"Social","Technician"}
                ,new int[]{10,20},1500129442,1500129440));
        NgoAdapter ngoAdapter=new NgoAdapter(this,values);
        listView.setAdapter(ngoAdapter);
        listView.setEmptyView(findViewById(R.id.empty));
    }
}
