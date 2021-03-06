package com.example.ioana.eduquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HistSubmit extends AppCompatActivity {

    int answerPoints;
    int score;
    TextView scorePoints;
    Button restart;
    Button share;
    Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist_submit);


        scorePoints = (TextView) findViewById(R.id.scorePoints);
        restart = (Button) findViewById(R.id.restart);
        share = (Button) findViewById(R.id.share);
        quit = (Button) findViewById(R.id.quit);
        //RECEIVE DATA FROM MAIN ACTIVITY
        score = getIntent().getExtras().getInt("Score");
        answerPoints = score;

        //SET THE DATA TO OUR LOCAL VIEWS
        scorePoints.setText(String.valueOf(score));

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the History activity

                Intent intent = new Intent(HistSubmit.this, History.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                // create a new intent to open the the Email app

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.category3));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.scoree) + answerPoints + getString(R.string.scoreTextt));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        quit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                // create a new intent to open the MainActivity activity

                Intent intent = new Intent(HistSubmit.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
