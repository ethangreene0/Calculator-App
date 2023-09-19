package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

//This whole thing starts all the activities for the 5 motion equations (same as the main activity)
public class MotionEquationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_equations);
    }
    //When a button is clicked and is set to the right onClick variable this code is run and starts the inputted class
    public void LaunchNoAcc(View v){
        Intent i = new Intent(this, NoAccEqActivity.class);
        startActivity(i);

    }
    public void LaunchNoDisp(View v){
        Intent i = new Intent(this, NoDispEqActivity.class);
        startActivity(i);

    }
    public void LaunchNoTime(View v){
        Intent i = new Intent(this, NoTimeEqActivity.class);
        startActivity(i);

    }
    public void LaunchNoFV(View v){
        Intent i = new Intent(this,NoFinalVEqActivity.class);
        startActivity(i);
    }
    public void LaunchNoIV(View v){
        Intent i = new Intent(this, NoIntVEqActivity.class);
        startActivity(i);
    }

}