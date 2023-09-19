package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class NoIntVEqActivity extends AppCompatActivity {
    //Sets all the variables that are going to be used
    double FV, Time, Acc;

    EditText EditFV, EditTime, EditAcc;

    Button SubmitButton;

    //allows the answer to be rounded
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_int_veq);

        //sets the proper ID's to the right variables
        EditFV = findViewById(R.id.NoIvFv);
        EditTime = findViewById(R.id.NoIvTime);
        EditAcc = findViewById(R.id.NoIvAcc);
        SubmitButton = findViewById(R.id.NoIvSubmit);

        //Checks if the submit button is clicked and runs the code
        SubmitButton.setOnClickListener(view -> {

            //allows text to be inputted into the answer field
            TextView myTextView = findViewById(R.id.NoIvAnswer);

            //Checks if any of the fields are empty and tells the user to enter data in each
            if (EditFV.length() == 0 || (EditTime.length() == 0) || (EditAcc.length() == 0)){
                myTextView.setText("Please Enter Values in Each Field");

            }
            //Sets all the values to the proper variables and calculates the answer
            else{
                FV = Double.parseDouble(EditFV.getText().toString());
                Time = Double.parseDouble(EditTime.getText().toString());
                Acc = Double.parseDouble(EditAcc.getText().toString());

                double Answer = ((FV*Time)+(0.5*Acc*(Time*Time)));

                myTextView.setText("The Displacement is "+df.format(Answer));
            }
        });
    }
}