package com.example.calculator;

import static com.example.calculator.R.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText numInput1, numInput2 ;

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        numInput1 = findViewById(R.id.numInput1);

        numInput2 = findViewById(R.id.numInput2);

        resultText = findViewById(R.id.resultText);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation('+');
            }
        });

        Button btnSubstract = findViewById(R.id.btnSubstract);
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation('-');
            }
        });

        Button btnMultply = findViewById(R.id.btnMultply);

        btnMultply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation('*');
            }
        });

        Button btnDivide = findViewById(R.id.btnDivide);

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation('/');
            }
        });
    }

    private void performCalculation(char operation){
        String input1 = numInput1.getText().toString();
        String input2 = numInput2.getText().toString();

        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result = 0;

        switch (operation) {
            case '+':
                result = num2 + num1;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':

                if (num2 == 0) {
                    resultText.setText("Cannot Divide by 0");
                    return;
                }
                result = num1 / num2;
                break;

            default:
                resultText.setText("Ivalid Operation!");
                return;
        }

        resultText.setText("Result:  " + result);
    }
}
