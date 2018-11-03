package com.example.andrestapiero.calculadoraj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int operador = 0;
    private TextView restxt;
    private double result, number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restxt = (TextView) findViewById(R.id.resultado);
    }

    public void OnClickListenerNumbers(View view) {
        String inputNumber = restxt.getText().toString();
        String selectedNumber = "";

        switch (view.getId()) {
            case R.id.btn0:
                selectedNumber = "0";
                break;

            case R.id.btn1:
                selectedNumber = "1";
                break;

            case R.id.btn2:
                selectedNumber = "2";
                break;

            case R.id.btn3:
                selectedNumber = "3";
                break;

            case R.id.btn4:
                selectedNumber = "4";
                break;

            case R.id.btn5:
                selectedNumber = "5";
                break;

            case R.id.btn6:
                selectedNumber = "6";
                break;

            case R.id.btn7:
                selectedNumber = "7";
                break;

            case R.id.btn8:
                selectedNumber = "8";
                break;

            case R.id.btn9:
                selectedNumber = "9";
                break;

            case R.id.btnpoint:
                if (!isResultNumberEmpty() && !restxt.getText().toString().contains(".")) {
                    selectedNumber = ".";
                }
                break;
        }
        restxt.setText(inputNumber.concat(selectedNumber));
    }

    private Boolean isResultNumberEmpty() {         //Metodo que compara si el String esta vacio
        return restxt.getText().toString().equals("");
    }

    public void OnClickListenerOperators(View view) {
        String text1;
        text1 = restxt.getText().toString();

        switch (view.getId()) {
            case R.id.btnSuma:
                if (!isResultNumberEmpty()) {
                    number1 = Double.parseDouble(text1);
                    operador = 1;
                }
                break;

            case R.id.btnMenos:
                if (!isResultNumberEmpty()) {
                    number1 = Double.parseDouble(text1);
                    operador = 2;
                }
                break;

            case R.id.btnmtl:
                if (!isResultNumberEmpty()) {
                    number1 = Double.parseDouble(text1);
                    operador = 3;
                }
                break;

            case R.id.btndv:
                if (!isResultNumberEmpty()) {
                    number1 = Double.parseDouble(text1);
                    operador = 4;
                }

                break;
            case R.id.btnpor:
                if (!isResultNumberEmpty()){
                    number1 = Double.parseDouble(text1);
                    operador = 5;}
                break;
        }
        restxt.setText("");
    }

    public void OnClickListenerEqual(View view) {

        if (!isResultNumberEmpty()) {
            String text2 = restxt.getText().toString();
            number2 = Double.parseDouble(text2);
            switch (operador) {
                case 1:
                    result = number1 + number2;
                    break;

                case 2:
                    result = number1 - number2;
                    break;

                case 3:
                    result = number1 * number2;
                    break;

                case 4:
                    result = number1 / number2;
                    break;

                case 5:
                    result = number2 * (number1 / 100.0);
                    break;
            }
            restxt.setText("" + result);
            number1 = result;
        }
    }

    public void OnClickListenerClear(View view) {
        switch (view.getId()) {

            case R.id.btndelete:
                restxt.setText("");
                number1 = 0.0;
                number2 = 0.0;
                break;

            case R.id.btndel:
                if (!isResultNumberEmpty()) {
                    restxt.setText(restxt.getText().subSequence(0, restxt.getText().length() - 1) + "");
                }
        }
    }
}
