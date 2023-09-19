package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuadraticActivity extends AppCompatActivity {
    //sets all the variables that are going to be used
    double ValueA , ValueB , ValueC;

    EditText EditValueA,EditValueB,EditValueC;

    Button SubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //sets the ID's to the proper variables
        EditValueA = findViewById(R.id.ValueA);
        EditValueB = findViewById(R.id.ValueB);
        EditValueC = findViewById(R.id.ValueC);
        SubmitButton = findViewById(R.id.SubmitButton);

        //checks if the submit button is pressed
        SubmitButton.setOnClickListener(view -> {

            //allowing the answer field to be populated
            TextView myTextView = findViewById(R.id.Answer);

            //checking if any of the fields are empty and telling the user
            if (EditValueA.length() == 0 || (EditValueB.length() == 0) || (EditValueB.length() == 0)){
                myTextView.setText("Please Enter Values in Each Field");

            }
            //This calculates the discriminant and checks if it has one root, two roots or no roots
            else{
                ValueA = Double.parseDouble(EditValueA.getText().toString());
                ValueB = Double.parseDouble(EditValueB.getText().toString());
                ValueC = Double.parseDouble(EditValueC.getText().toString());

                double discriminant = ValueB * ValueB - 4 * ValueA * ValueC;

                if (discriminant > 0){
                    double root1 = (-ValueB + Math.sqrt(discriminant)) / (2 * ValueA);
                    double root2 = (-ValueB - Math.sqrt(discriminant)) / (2 * ValueA);

                    String FinalRoot1 = Double.toString(root1);
                    String FinalRoot2 = Double.toString(root2);
                    myTextView.setText("The roots are " + FinalRoot1 + " and " + FinalRoot2);

                }  else if (discriminant == 0){
                    double root = -ValueB/ (2 * ValueA);


                    myTextView.setText("The root is "+root);

                }   else{

                    myTextView.setText("The equation has no real roots");
                }
            }






        });



    }

}