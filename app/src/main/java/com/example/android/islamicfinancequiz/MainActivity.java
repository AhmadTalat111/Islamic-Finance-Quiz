package com.example.android.islamicfinancequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    private int questionOneScore = 0;
    private int questionTwoScore = 0;
    private int questionThreeScore = 0;
    private int questionFourScore = 0;
    private int questionFiveScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void checkQuestionOne(boolean a, boolean b, boolean c) {
        if (a && b && c && questionOneScore == 0) {
            questionOneScore += 5;
        }
        if (a && b && c && questionOneScore == 5) {
            questionOneScore = 5;
        } else {
            questionOneScore = 0;
        }
    }

    private void checkQuestionTwo(boolean b) {
        if (b && questionTwoScore == 0) {
            questionTwoScore += 5;
        }
        if (b && questionTwoScore == 5) {
            questionTwoScore = 5;
        } else {
            questionTwoScore = 0;
        }
    }

    private void checkQuestionThree(boolean a, boolean b) {
        if (a && b && questionThreeScore == 0) {
            questionThreeScore += 5;
        }
        if (a && b && questionThreeScore == 5) {
            questionThreeScore = 5;
        } else {
            questionThreeScore = 0;
        }
    }

    private void checkQuestionFour(boolean a) {
        if (a && questionFourScore == 0) {
            questionFourScore += 5;
        }
        if (a && questionFourScore == 5) {
            questionFourScore = 5;
        } else {
            questionFourScore = 0;
        }
    }

    private void checkQuestionFive(boolean c) {
        if (c && questionFiveScore == 0) {
            questionFiveScore += 5;
        }
        if (c && questionFiveScore == 5) {
            questionFiveScore = 5;
        } else {
            questionFiveScore = 0;
        }
    }

    private void finalScore() {
        score = questionOneScore + questionTwoScore + questionThreeScore + questionFourScore + questionFiveScore;
    }

    public void updateScore(View view) {
        EditText name = findViewById(R.id.name);
        name.getText().toString();
        CheckBox questionOneA = findViewById(R.id.question_one_ans_one);
        CheckBox questionOneB = findViewById(R.id.question_one_ans_two);
        CheckBox questionOneC = findViewById(R.id.question_one_ans_three);
        boolean q1a = questionOneA.isChecked();
        boolean q1b = questionOneB.isChecked();
        boolean q1c = questionOneC.isChecked();
        checkQuestionOne(q1a, q1b, q1c);
        RadioButton questionTwoB = findViewById(R.id.question_two_ans_two);
        boolean q2b = questionTwoB.isChecked();
        checkQuestionTwo(q2b);
        CheckBox questionThreeA = findViewById(R.id.question_three_ans_one);
        CheckBox questionThreeB = findViewById(R.id.question_three_ans_two);
        boolean q3a = questionThreeA.isChecked();
        boolean q3b = questionThreeB.isChecked();
        checkQuestionThree(q3a, q3b);
        RadioButton questionFourA = findViewById(R.id.question_four_ans_one);
        boolean q4a = questionFourA.isChecked();
        checkQuestionFour(q4a);
        RadioButton questionFiveC = findViewById(R.id.question_five_ans_three);
        boolean q5c = questionFiveC.isChecked();
        checkQuestionFive(q5c);
        finalScore();
        Toast.makeText(this, name.getText().toString() + " scored " + score, Toast.LENGTH_LONG).show();
    }
}
