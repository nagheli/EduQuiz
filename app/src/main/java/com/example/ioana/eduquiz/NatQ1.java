package com.example.ioana.eduquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NatQ1 extends AppCompatActivity {


    TextView scorePoints;
    int score;
    int answerPoints;
    EditText answer;
    Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nat_q1);

        answer = (EditText) findViewById(R.id.answerN21);
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
                // create a new intent to open the NatQ2 activity
                if(answer.getText().toString().equals("Bamboo")) {
                    answerPoints++;}

                else{answerPoints = answerPoints + 0;}

                if(!answer.getText().toString().equals(""))
                {
                    sendData();

                }
            }
        });
    }

    private void sendData() {
        //GET PRIMITIVE VALUES TO SEND
        int score = answerPoints;
        //int score = Integer.parseInt(scorePoints.getText().toString());

        //PACK THEM IN AN INTENT OBJECT
        Intent natQ2Intent = new Intent(NatQ1.this, NatQ2.class);
        natQ2Intent.putExtra("Score", score);

        //START SECOND ACTIVITY
        this.startActivity(natQ2Intent);
    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}


