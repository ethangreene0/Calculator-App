package com.example.test;

//imports
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    //These TextView attributes allow for text to be displayed to the user
    TextView resultTv,solutionTv;

    //These Button attributes allow for the button to do something when they are clicked
    MaterialButton buttonC,buttonBrackOpen,buttonBrackClose;
    MaterialButton buttonDivide,buttonMultiply,buttonPlus,buttonMinus,buttonEquals;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting this code to the calculator xml for the design, and setting the title
        setContentView(R.layout.activity_calculator);
        setTitle("Calculator");

        //setting the textview variables to the ID's set in the xml design file to allow for setting text
        resultTv = findViewById(R.id.result_TV);
        solutionTv = findViewById(R.id.solution_TV);

        //assigning each button to the ID's set in the xml file to allow finding which button is clicked
        assignId(buttonC,R.id.button_c);
        assignId(buttonBrackOpen,R.id.button_open_bracket);
        assignId(buttonBrackClose,R.id.button_close_bracket);
        assignId(buttonDivide,R.id.button_divide);
        assignId(buttonMultiply,R.id.button_multiply);
        assignId(buttonPlus,R.id.button_plus);
        assignId(buttonMinus,R.id.button_minus);
        assignId(buttonEquals,R.id.button_equals);
        assignId(button0,R.id.button_0);
        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);
        assignId(buttonAC,R.id.button_ac);
        assignId(buttonDot,R.id.button_dot);





    }
    //This code assigns all of the button variables to the proper ID's
    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        //allows for the text on the button to be saved Ex. 8
        MaterialButton button =(MaterialButton) view;

        //Getting the text from the button
        String buttonText = button.getText().toString();

        //taking the inputted value and adding it to the dataToCalculate String
        String dataToCalculate = solutionTv.getText().toString();

        //This makes the app not crash :)
        String Check = resultTv.getText().toString();

        //This also makes the app not crash when spamming the clear button by checking if the result is set to 0 and consistently checks to avoid crashing
        if (Check.equals("0") && buttonText.equals("C")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }

        //Clearing the text when the AC button is pressed
        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        //When the equals button is pressed the result is set to the solutions textview
        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }

        //if the Clear button is clicked it takes 1 off the end of the total
        if(buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
        }
        //This adds the value of each button pressed and adds it to the datatocalculate
        else{
            dataToCalculate = dataToCalculate+buttonText;
        }
        //This makes the app not crash when the length of the data is less than 1 when pressing the clear button
        if(buttonText.equals("C") && dataToCalculate.length() < 1){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        //This sets the top bar to the numbers that are being calculated
        solutionTv.setText(dataToCalculate);

        //getting the final results by calling the function
        String finalResult = getResult(dataToCalculate);

        //This checks for errors in the calculations
        if(!finalResult.equals("Err")){
            resultTv.setText(finalResult);
        }

    }
    //This is where everything is calculated. It uses a try and accept to check for calculation errors and returns "Err"
    //The function uses the Mozilla Rhino JavaScript engine to execute the string passed as "data" as JavaScript code.
    // The result of the JavaScript code is converted to a string, and if the string ends with ".0", that is removed.
    //Then the final string result is returned
    //I did watch a tutorial to help with the calculations and using the Mozilla Rhino JavaScript engine
    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }

}