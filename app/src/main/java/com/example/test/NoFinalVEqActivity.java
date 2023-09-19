package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class NoFinalVEqActivity extends AppCompatActivity {
    //creates the variables that are going to be used
    double IV, Time, Acc;

    EditText EditIV, EditTime, EditAcc;
    Button SubmitButton;
    private static final DecimalFormat df = new DecimalFormat("0.0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_final_veq);

        //Sets the ID's to the proper variables
        EditIV = findViewById(R.id.InitialV);
        EditTime = findViewById(R.id.NoFVTIme);
        EditAcc = findViewById(R.id.NoFVACC);
        SubmitButton = findViewById(R.id.NoTSubmit);

        //checks if the submit button is clicked and runs the code in it
        SubmitButton.setOnClickListener(view -> {
            //Allows for text to be set to the answer field
            TextView myTextView = findViewById(R.id.noFVAns);

            //checks if any of the input fields are empty and tells the user to fill them
            if (EditIV.length() == 0 || (EditTime.length() == 0) || (EditAcc.length() == 0)){
                myTextView.setText("Please Enter Values in Each Field");

            }
            //Sets the inputted text to the right variables, calculates the answer and sets the text to the answer field
            else{
                IV = Double.parseDouble(EditIV.getText().toString());
                Time = Double.parseDouble(EditTime.getText().toString());
                Acc = Double.parseDouble(EditAcc.getText().toString());

                double Answer = ((IV*Time)+(0.5*Acc*(Time*Time)));

                myTextView.setText("The Displacement is "+df.format(Answer));
            }
        });
    }
}