package com.example.ioana.eduquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class History extends AppCompatActivity {



    TextView scorePoints;
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
        setContentView(R.layout.activity_history);


        optionOneQ1 = (CheckBox) findViewById(R.id.checkBox);
        optionTwoQ1 = (CheckBox) findViewById(R.id.checkBox2);
        optionThreeQ1 = (CheckBox) findViewById(R.id.checkBox3);
        optionFourQ1 = (CheckBox) findViewById(R.id.checkBox4);
        optionFiveQ1 = (CheckBox) findViewById(R.id.checkBox5);
        nextQuestion = (Button) findViewById(R.id.next);
        scorePoints = (TextView) findViewById(R.id.scorePoints);


        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the HistQ1 activity
                if(optionFiveQ1.isChecked() ||optionFourQ1.isChecked() || optionTwoQ1.isChecked()){
                    answerPoints = answerPoints + 0;
                }
                else if (optionThreeQ1.isChecked() && optionOneQ1.isChecked()) {
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
        Intent histQ1Intent = new Intent(History.this, HistQ1.class);
        histQ1Intent.putExtra("Score", score);

        //START SECOND ACTIVITY
        this.startActivity(histQ1Intent);
    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

