package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // No of Questions Spinner
        Spinner questionSpinner = (Spinner) findViewById(R.id.questionspinner);
        ArrayAdapter<CharSequence> questionAdapter = ArrayAdapter.createFromResource(this,R.array.noOfQuestions, android.R.layout.simple_spinner_item);
        questionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        questionSpinner.setAdapter(questionAdapter);
        // Category Spinner
        Spinner categorySpinner = (Spinner) findViewById(R.id.categoryspinner);
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,R.array.category, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
    }

    public void toggleLoadQuiz(View v) {
        // No of Questions
        Spinner questionSpinner = (Spinner) findViewById(R.id.questionspinner);
        int noOfQuestions = Integer.parseInt(questionSpinner.getSelectedItem().toString());
        // Category
        Spinner categorySpinner = (Spinner) findViewById(R.id.categoryspinner);
        String category = categorySpinner.getSelectedItem().toString();
        // Navigate to Activity 2
        Intent intent = new Intent(this, Activity2.class);
        Bundle bundle = new Bundle();
        bundle.putInt("noOfQuestions", noOfQuestions);
        bundle.putString("category", category);
        bundle.putInt("currentNoQuestion",0);
        bundle.putInt("score",0);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}