package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class EnergyActivity extends AppCompatActivity {
    //sets all the variables
    double Light = 299792458;
    double Energy, Mass;

    EditText EditEnergy, EditMass;

    Button SubmitButton;

    //used to round the answers to 2 decimal places
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy2);

        //These assign the correct buttons to each variable
        EditEnergy = findViewById(R.id.Energy);
        EditMass = findViewById(R.id.EngMass);
        SubmitButton = findViewById(R.id.EngSubmit);

        //This constantly looks for when the Submit button is pressed
        SubmitButton.setOnClickListener(view -> {

            //This sets a textview so the answer can be displayed
            TextView myTextView = findViewById(R.id.EngAnswer);

            //This checks if there are no data entry's in the text to make the app not crash
            if (EditEnergy.length() == 0 && EditMass.length() == 0){
                myTextView.setText("Please Enter Values in one of the Field's");
            }
            //Checks if the energy field is empty and calculates Energy and sets the answer to the text field
            else if (EditEnergy.length() == 0){
                Mass = Double.parseDouble(EditMass.getText().toString());
                double Eanswer = ((Mass*(Light*Light))/1000);

                myTextView.setText("The Energy is " + df.format(Eanswer)+"KJ");
            }
            //checks if mass field is empty and calculates for the mass and sets the answer to the text field
            else if (EditMass.length() == 0){
                Energy = Double.parseDouble((EditEnergy.getText().toString()));

                double Manswer = Energy/(Light*Light);
                myTextView.setText("The Mass is "+Manswer+"Kg");
            }

            else{
                myTextView.setText("Please only fill in one field");
            }
        });
    }
}