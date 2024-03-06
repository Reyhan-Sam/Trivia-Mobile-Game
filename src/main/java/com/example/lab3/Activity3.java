package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int score = bundle.getInt("score");
        int noOfQuestions = bundle.getInt("noOfQuestions");

        // Set Final Score
        TextView outputScore = findViewById(R.id.score);
        outputScore.setText(""+score+"/"+noOfQuestions);
    }

    public void toggleButton(View v) {
        // Navigate to Main Activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}