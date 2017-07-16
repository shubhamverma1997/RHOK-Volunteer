package com.example.android.volunteer;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {



    Context context;

    AlertDialog alertDialog;

    Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        context = this;
        Intent recieve=getIntent();
        String desc=recieve.getStringExtra("desc");

        TextView textView=(TextView) findViewById(R.id.ldesc);
        textView.setText(desc);

        desc=recieve.getStringExtra("title");
        TextView title=(TextView) findViewById(R.id.dTitle);
        title.setText(desc);

        String imgUrl=recieve.getStringExtra("imageURL");
        ImageView img=(ImageView) findViewById(R.id.dImg);
        Picasso.with(this).load(imgUrl).placeholder(R.drawable.demo).error(R.drawable.demo).into(img);

        applyButton = (Button)findViewById(R.id.apply_button);

        applyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                builder.setTitle("Thanks, Shubham!").setMessage("Someone from the organization will contact you shortly.").show();

            }
        });

    }




}
