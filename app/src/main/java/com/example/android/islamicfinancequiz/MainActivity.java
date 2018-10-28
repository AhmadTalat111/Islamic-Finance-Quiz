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
    private int questionSixScore = 0;

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

    private void checkQuestionThree(boolean a, boolean b, boolean c) {
        if (a && b && questionThreeScore == 0) {
            questionThreeScore += 5;
        }
        if (a && b && questionThreeScore == 5) {
            questionThreeScore = 5;
        }
        if (c && a && b) {
            questionThreeScore = 0;
        }
        if (!a) {
            questionThreeScore = 0;
        }
        if (!b) {
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

    private void checkQuestionSix(String answer) {

        if (answer.equals("murabaha") && questionSixScore == 0) {
            questionSixScore += 5;
        }
        if (answer.equals("murabaha") && questionSixScore == 5) {
            questionSixScore = 5;
        } else {
            questionSixScore = 0;
        }
    }

    private void finalScore() {
        score = questionOneScore + questionTwoScore + questionThreeScore + questionFourScore + questionFiveScore + questionSixScore;
    }

    public void displayScore(String name, int score) {
        if (name.equals("")) {
            Toast.makeText(this, "You must tell us your name", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, name + " scored " + score, Toast.LENGTH_LONG).show();
        }
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
        CheckBox questionThreeC = findViewById(R.id.question_three_ans_three);
        boolean q3a = questionThreeA.isChecked();
        boolean q3b = questionThreeB.isChecked();
        boolean q3c = questionThreeC.isChecked();
        checkQuestionThree(q3a, q3b, q3c);
        RadioButton questionFourA = findViewById(R.id.question_four_ans_one);
        boolean q4a = questionFourA.isChecked();
        checkQuestionFour(q4a);
        RadioButton questionFiveC = findViewById(R.id.question_five_ans_three);
        boolean q5c = questionFiveC.isChecked();
        checkQuestionFive(q5c);
        EditText userAnswer = findViewById(R.id.user_answer);
        checkQuestionSix(userAnswer.getText().toString());
        finalScore();
        displayScore(name.getText().toString(), score);
    }

}
