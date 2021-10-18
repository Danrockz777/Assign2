package com.example.assign2;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class declareform extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.first_question, "no"),
            new Question(R.string.second_question, "no"),
            new Question(R.string.third_question, "no"),
            new Question(R.string.forth_question, "no"),
            new Question(R.string.fifth_question, "no"),
            new Question(R.string.sixth_question, "no")
    };

    private int mCurrentIndex = 0;
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declareform);
        setTitle("Self Declaration Form " );
        mTrueButton = findViewById(R.id.yes_button);
        mFalseButton = findViewById(R.id.no_button);
        mNextButton = findViewById(R.id.next_button);
        mQuestionTextView = findViewById(R.id.question_text_view);

        //display the first question
        updateQuestion();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("yes");
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("no");
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex++;
                if (mCurrentIndex==mQuestionBank.length) {
                    mNextButton.setVisibility(View.GONE);
                    mTrueButton.setVisibility(View.GONE);
                    mFalseButton.setVisibility(View.GONE);
                    //mQuestionTextView.setText(R.string.the_end);
                    Intent intent4 = new Intent(declareform.this, viewReservation.class);
                    startActivity(intent4);
                }
                else
                    updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        mNextButton.setEnabled(false);
    }

    public void checkAnswer(String userAnswer) {
        String answer = mQuestionBank[mCurrentIndex].isAnswer();
        if (userAnswer == answer) {
            /*Toast.makeText(this, R.string.allow_toast, Toast.LENGTH_SHORT).show();*/
            mNextButton.setEnabled(true);
        }
        else {
            Toast.makeText(this, R.string.notallowed_toast, Toast.LENGTH_SHORT).show();
            //Alert Dialog
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    //set icon
                    .setIcon(R.drawable.ic_noentry)
                    //set title
                    .setTitle(R.string.alert_title2)
                    //set message
                    .setMessage(R.string.alert_message2)
                    //set positive button
                    .setPositiveButton(R.string.ok_button2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what would happen when positive button is clicked
                            displayToast("Apply again after 14 days. Thank you. ");
                            finish();

                        }
                    })


                    /*//set negative button
                    .setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what should happen when negative button is clicked
                            displayToast("You are not allowed to make a Reservation !");
                            finish();
                        }
                    })*/
                    .show();
        }
    }

}