package com.example.ioana.eduquiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Nature extends AppCompatActivity {

    TextView scorePoints;
    int answerPoints = 0;
    EditText answer;
    Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

                answer = (EditText) findViewById(R.id.answerN11);
                nextQuestion = (Button) findViewById(R.id.next);
                scorePoints = (TextView) findViewById(R.id.scorePoints);


                nextQuestion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // create a new intent to open the NatQ1 activity
                        if(answer.getText().toString().equalsIgnoreCase("Madagascar")) {
                            answerPoints++;}
                            else{answerPoints = answerPoints + 0;

                        }
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

                //PACK THEM IN AN INTENT OBJECT
                Intent natQ1Intent = new Intent(Nature.this, NatQ1.class);
                natQ1Intent.putExtra("Score", score);

                //START SECOND ACTIVITY
                this.startActivity(natQ1Intent);
            }


            @Override
            public void onBackPressed()
            {
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
        }




