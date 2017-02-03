package com.example.android.quizzi2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView mScoreView,mQuestion;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        mScoreView = (TextView) findViewById(R.id.points);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mQuestion = (TextView) findViewById(R.id.question);
        mTrueButton = (Button) findViewById(R.id.trueButton);
        mFalseButton = (Button) findViewById(R.id.falseButton);

        updateQuestion();

        //Logic for True Button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAnswer == true) {
                    mScore++; //This updates the score int variable
                    updateScore(mScore); //This converts the int variable to a String and adds it to mScoreView

                    //Perform this check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }

                //if the user's answer is wrong
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }

            }
        });
        //Logic for False Button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer == false) {
                    mScore++; //This updates the score int variable
                    updateScore(mScore); //This converts the int variable to a String and adds it to mScoreView

                    //Perform this check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }

                //if the user's answer is wrong
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }

            }
        });

    }

    private void updateQuestion(){
        mImageView.setImageResource(QuizBook.images[mQuestionNumber]);
        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    private void updateScore(int point){

        mScoreView.setText("" + mScore);
    }
    public void clickExit(View view) {
        askToClose();

    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id){
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id){
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}


