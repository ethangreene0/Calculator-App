package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class NoDispEqActivity extends AppCompatActivity {
    //Sets all the variables that are going to be used
    double IV, ACC, Time;

    EditText EditInitV, EditACC, EditTime1;

    Button SubmitButton;

    //allows the final answer to be rounded
    private static final DecimalFormat df = new DecimalFormat("0.0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_disp_eq);

        //sets all the ID's to the proper variables
        EditInitV = findViewById(R.id.NoTimeIV);
        EditACC = findViewById(R.id.NoFVTIme);
        EditTime1 =  findViewById(R.id.NoFVACC);
        SubmitButton = findViewById(R.id.NoTSubmit);

        //constantly checks for if the button is clicked
        SubmitButton.setOnClickListener(view -> {
            TextView myTextView = findViewById(R.id.NoTimeAns);

            //Checks if any of the input fields are empty and tells the user
            if (EditInitV.length() == 0 || (EditACC.length() == 0) || (EditTime1.length() == 0)){
                myTextView.setText("Please Enter Values in Each Field");

            }
            //if the fields are all full it takes the values and calculates them and sets the text to the answer field
            else{
                IV = Double.parseDouble((EditInitV.getText().toString()));
                ACC = Double.parseDouble((EditACC.getText().toString()));
                Time = Double.parseDouble((EditTime1.getText().toString()));

                double Answer = IV+(ACC*Time);

                myTextView.setText("The Final Velocity is "+ df.format(Answer));
            }

        });




    }
}