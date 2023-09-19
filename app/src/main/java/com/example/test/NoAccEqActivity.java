package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class NoAccEqActivity extends AppCompatActivity {
    //sets all the variables that are going to be used
    double FV , IV , Time;

    EditText EditFV,EditIV,EditTime;

    Button SubmitButton;

    //allows for the answer to be round to 2 decimal places
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_acc_eq);

        //setting the the ID's to the variables
        EditFV = findViewById(R.id.FinalVel);
        EditIV = findViewById(R.id.IV);
        EditTime =  findViewById(R.id.Time);
        SubmitButton = findViewById(R.id.Submit);

        //Constantly checks to see if the button is clicked
        SubmitButton.setOnClickListener(view -> {

            //allows for text to be set the the answer field
            TextView myTextView = findViewById(R.id.NoAccAnswer);

            //checking if any of the fields are empty and tells the user to fill all the fields
            if (EditFV.length() == 0 || (EditIV.length() == 0) || (EditTime.length() == 0)){
                myTextView.setText("Please Enter Values in Each Field");

            }
            //This gets the values, calculates the values and sets it to the answer field
            else{
                FV = Double.parseDouble(EditFV.getText().toString());
                IV = Double.parseDouble(EditIV.getText().toString());
                Time = Double.parseDouble(EditTime.getText().toString());

                double Answer = ((FV*IV)/2)*Time;



                myTextView.setText("The Change in Displacement is: "+ df.format(Answer));
            }

        });



    }

}