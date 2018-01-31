package com.example.ioana.eduquiz;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView geography = (ImageView) findViewById(R.id.geography);
        ImageView history = (ImageView) findViewById(R.id.history);
        ImageView nature = (ImageView) findViewById(R.id.nature);
        ImageView religion = (ImageView) findViewById(R.id.science);



        // set a click listener on that View
        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the Geography activity
                Intent geographyIntent = new Intent(MainActivity.this,Geography.class);
                // start the new activity
                startActivity(geographyIntent);
            }
        });


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(MainActivity.this, History.class);
                startActivity(historyIntent);
            }
        });


        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent natureIntent = new Intent(MainActivity.this, Nature.class);
                startActivity(natureIntent);

            }
        });

        religion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent religionIntent = new Intent(MainActivity.this,Science.class);
                startActivity(religionIntent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
