package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    int noOfQuestions;
    String category;
    int currentNoQuestion;

    String[] categoryOneQuestions = {"Please select the correct capital name from a list of options for each province and territory in Canada.", "Please select the correct capital name from a list of options for each province and territory in Canada.", "Please select the correct capital name from a list of options for each province and territory in Canada.", "Please select the correct capital name from a list of options for each province and territory in Canada."};
    String[][] categoryOneOptions = {{"Ottawa","Hamilton","Toronto","None"}, {"St. John's", "Charlottetown","Winnipeg","None"}, {"St. John's", "Waterloo","Regina","None"}, {"Whitehorse", "Inuvik","Yellowknife","None"}};
    String[] categoryOneAnswers = {"Toronto","Charlottetown","St. John's","Yellowknife"};
    int[] categoryOneImages = {R.drawable.capital1,R.drawable.capital2,R.drawable.capital3,R.drawable.capital4};
    String[] categoryTwoQuestions = {"Who is the Head of Government of Canada?", "Which of the following is NOT a provincial/territorial responsibility?", "How many Canadians died in World War II?", "What province in Canada is known for its Celtic and Gaelic traditions?"};
    String[][] categoryTwoOptions = {{"The Prime Minister","The Governor General","The Lt. Governor","The Sovereign"}, {"Education", "Property and civil rights","Health","Foreign policy"}, {"6,000", "45,000","60,000","110,000"}, {"Nova Scotia", "Newfoundland and Labrador","Prince Edward Island","New Brunswick"}};
    String[] categoryTwoAnswers = {"The Prime Minister","Foreign policy","45,000","Nova Scotia"};
    int[] categoryTwoImages = {R.drawable.about_canada1,R.drawable.about_canada2,R.drawable.about_canada3,R.drawable.about_canada4};
    String[] categoryThreeQuestions = {"Please select the correct Mountain name from a list of mountain names in Canada.", "Please select the correct Mountain name from a list of mountain names in Canada.", "Please select the correct Mountain name from a list of mountain names in Canada.", "Please select the correct Mountain name from a list of mountain names in Canada."};
    String[][] categoryThreeOptions = {{"Rocky Mountains","Appalachian Mountains","Andes Mountains","None"}, {"Himalayas", "Alps","Mount Robson","None"}, {"Andes Mountains", "Sierra Nevada","Mount Temple","None"}, {"Alps", "Mount Columbia","Andes Mountains","None"}};
    String[] categoryThreeAnswers = {"Rocky Mountains","Mount Robson","Mount Temple","Mount Columbia"};
    int[] categoryThreeImages = {R.drawable.mountain1,R.drawable.mountain2,R.drawable.mountain3,R.drawable.mountain4};

    String[] questions;
    String[][] options;
    String[] answers;
    int[] images;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        noOfQuestions = bundle.getInt("noOfQuestions");
        category = bundle.getString("category");
        currentNoQuestion = bundle.getInt("currentNoQuestion");
        score = bundle.getInt("score");

        if (category.equals("Canadian Capital")) {
            questions = categoryOneQuestions;
            options = categoryOneOptions;
            answers = categoryOneAnswers;
            images = categoryOneImages;
        }
        else if (category.equals("About Canada")) {
            questions = categoryTwoQuestions;
            options = categoryTwoOptions;
            answers = categoryTwoAnswers;
            images = categoryTwoImages;
        }
        else if (category.equals("Canadian mountains")) {
            questions = categoryThreeQuestions;
            options = categoryThreeOptions;
            answers = categoryThreeAnswers;
            images = categoryThreeImages;
        }

        // Check bounds
        if (currentNoQuestion < noOfQuestions) {
            currentNoQuestion += 1;
        }
        else {
            // Navigate to Activity 3
            Intent intent2 = new Intent(this, Activity3.class);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("score", score);
            bundle2.putInt("noOfQuestions", noOfQuestions);
            intent2.putExtras(bundle2);
            startActivity(intent2);
        }

        // Set Question
        TextView question =  findViewById(R.id.question);
        question.setText(questions[currentNoQuestion-1]);
        // Set Image
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(images[currentNoQuestion-1]);
        // Set Options
        RadioButton choice1 = findViewById(R.id.radiobutton1);
        choice1.setText(options[currentNoQuestion-1][0]);
        RadioButton choice2 = findViewById(R.id.radiobutton2);
        choice2.setText(options[currentNoQuestion-1][1]);
        RadioButton choice3 = findViewById(R.id.radiobutton3);
        choice3.setText(options[currentNoQuestion-1][2]);
        RadioButton choice4 = findViewById(R.id.radiobutton4);
        choice4.setText(options[currentNoQuestion-1][3]);
        // Set Button Text
        Button button = findViewById(R.id.button2);
        if (currentNoQuestion != noOfQuestions) {
            button.setText("NEXT");
        }
        else {
            button.setText("FINISH");
        }
    }

    public void toggleButton(View v) {
        // Get User Answer
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        int selectedID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedID);
        // Radio Button Is Selected
        if (radioButton != null) {
            // Update Score
            String userAnswer = radioButton.getText().toString();
            if (userAnswer.equals(answers[currentNoQuestion-1])){
                score += 1;
            }
            System.out.println(score);
            // Re-navigate to Activity 2 with Updated Data
            Intent intent = new Intent(this, Activity2.class);
            Bundle bundle = new Bundle();
            bundle.putInt("noOfQuestions", noOfQuestions);
            bundle.putString("category", category);
            bundle.putInt("currentNoQuestion", currentNoQuestion);
            bundle.putInt("score", score);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else{
            // Radio Button Is Not Selected
            Toast toast = Toast.makeText(this /* MyActivity */, "Please select an option", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}