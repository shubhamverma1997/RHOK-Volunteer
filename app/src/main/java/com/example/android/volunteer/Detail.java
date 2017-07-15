package com.example.android.volunteer;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Detail extends AppCompatActivity {


    Context context;

    AlertDialog alertDialog;

    Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        context = this;

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
                builder.setTitle("Success").setMessage("You have successfully applied.").show();

            }
        });

    }




}
