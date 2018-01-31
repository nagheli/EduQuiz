package com.example.ioana.eduquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class HistQ1 extends AppCompatActivity {


    TextView scorePoints;
    int score;
    int answerPoints = 0;
    CheckBox optionOneQ1;
    CheckBox optionTwoQ1;
    CheckBox optionThreeQ1;
    CheckBox optionFourQ1;
    CheckBox optionFiveQ1;
    Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist_q1);

        optionOneQ1 = (CheckBox) findViewById(R.id.checkBox);
        optionTwoQ1 = (CheckBox) findViewById(R.id.checkBox2);
        optionThreeQ1 = (CheckBox) findViewById(R.id.checkBox3);
        optionFourQ1 = (CheckBox) findViewById(R.id.checkBox4);
        optionFiveQ1 = (CheckBox) findViewById(R.id.checkBox5);
        nextQuestion = (Button) findViewById(R.id.next);
        scorePoints = (TextView) findViewById(R.id.scorePoints);


        //RECEIVE DATA FROM MAIN ACTIVITY
        score = getIntent().getExtras().getInt("Score");
        answerPoints = score;

        //SET THE DATA TO OUR LOCAL VIEWS
        scorePoints.setText(String.valueOf(score));


        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the HistQ2 activity
                if(optionFiveQ1.isChecked() ||optionFourQ1.isChecked() || optionOneQ1.isChecked()){
                    answerPoints = answerPoints + 0;
                }
                else if (optionTwoQ1.isChecked() && optionThreeQ1.isChecked()) {
                    answerPoints++;
                }
                if(optionFiveQ1.isChecked() ||optionFourQ1.isChecked() || optionThreeQ1.isChecked() || optionTwoQ1.isChecked() || optionOneQ1.isChecked())
                {   sendData();

                }
            }
        });
    }

    private void sendData() {
        //GET PRIMITIVE VALUES TO SEND
        int score = answerPoints;

        //PACK THEM IN AN INTENT OBJECT
        Intent histQ2Intent = new Intent(HistQ1.this, HistQ2.class);
        histQ2Intent.putExtra("Score", score);

        //START SECOND ACTIVITY
        this.startActivity(histQ2Intent);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

