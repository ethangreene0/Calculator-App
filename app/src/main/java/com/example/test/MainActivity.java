package com.example.test;

//imports
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

//creating the main class
public class MainActivity extends AppCompatActivity {

    //When the app is started this code runs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting the java file to the xml layout file (for the design)
        setContentView(R.layout.activity_main);

        //Setting the title of the page
        setTitle("Home");
    }

    //The below public voids launch different activity's by taking in View which is a user interface component.
    //The intents are set to a specific button using on click, and when clicked the new activity is started
    public void launchQuadratic(View v){
        Intent i = new Intent(this,QuadraticActivity.class);
        startActivity(i);
    }

    public void launchMassEnergy(View v){
        Intent i = new Intent(this, EnergyActivity.class);
        startActivity(i);
    }
    public void launchMotion(View v){
        Intent i = new Intent(this, MotionEquationsActivity.class);
        startActivity(i);
    }
    public void launchCalculator(View v){
        Intent i = new Intent(this, CalculatorActivity.class);
        startActivity(i);
    }
}