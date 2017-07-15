package com.example.android.volunteer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by shubham on 7/15/17.
 */

public class NgoAdapter extends ArrayAdapter<ngo> {
    public NgoAdapter(Context context, ArrayList<ngo> data)
    {
        super(context,0,data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listview=convertView;
        if(listview==null)
        {
            listview= LayoutInflater.from(getContext()).inflate(R.layout.ngo_event_item,parent,false);
        }

        ngo variable=getItem(position);

        TextView title=(TextView) listview.findViewById(R.id.e_name);
        title.setText(variable.getNgoTitle());

        TextView ngoName=(TextView) listview.findViewById(R.id.n_name);
        ngoName.setText(variable.getNgoTitle());

        TextView description=(TextView) listview.findViewById(R.id.description);
        int length=variable.getDescription().length();
        if(length>60)
            length=60;
        description.setText(variable.getDescription().substring(0,length)+"....");

        TextView date_time=(TextView) listview.findViewById(R.id.date_time);
        Date d=new Date(variable.getEventDate());
        SimpleDateFormat sdf=new SimpleDateFormat("MMM dd , yyyy");
        String dateString=sdf.format(d);

        sdf=new SimpleDateFormat("HH:mm");
        dateString=dateString+" "+sdf.format(d);
        date_time.setText(dateString);

        ImageView image=(ImageView) listview.findViewById(R.id.image);
        image.setImageBitmap(variable.getImage());

        return listview;
    }
}
