package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class NoTimeEqActivity extends AppCompatActivity {
    //sets the variables the are going to be used
    double VI, ACC, DISP;

    EditText EditVI, EditACC, EditDISP;

    Button SubmitButton;

    //allows the answer to be rounded
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_time_eq);

        //sets the ID's to the proper variables
        EditVI = findViewById(R.id.NoTimeIV);
        EditACC = findViewById(R.id.NoFVTIme);
        EditDISP = findViewById(R.id.NoFVACC);
        SubmitButton = findViewById(R.id.NoTSubmit);

        //Check if the submit button is clicked and runs the code
        SubmitButton.setOnClickListener(view -> {

            //allows the answer field to be populated
            TextView myTextView = findViewById(R.id.NoTimeAns);

            //checks of any of the fields are empty and tells the user to populate them
            if (EditVI.length() == 0 || (EditACC.length() == 0) || (EditDISP.length() == 0)){
                myTextView.setText("Please Enter Values in Each Field");

            }
            //Sets the inputs to the proper variables and calculates the answer and sets it
            else{
                VI = Double.parseDouble(EditVI.getText().toString());
                ACC = Double.parseDouble(EditACC.getText().toString());
                DISP = Double.parseDouble(EditDISP.getText().toString());

                double Answer = Math.sqrt((VI*VI)+(2*(ACC*DISP)));

                myTextView.setText("The Final Velocity is "+ df.format(Answer));
            }

        });


    }
}