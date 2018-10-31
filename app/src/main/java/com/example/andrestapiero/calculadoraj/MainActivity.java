package com.example.andrestapiero.calculadoraj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int op = 0;
    private TextView res;
    private double resultado, operando1,operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (TextView) findViewById(R.id.resultado);
    }

    public void numeros(View view) {
        String inputNumber = res.getText().toString();
        String selectedNumber = "";

        switch (view.getId()) {
            case R.id.btn0:
                selectedNumber = "0";
                break;

            case R.id.btn1:
                selectedNumber = "1";
                break;

            case R.id.btn2:
                selectedNumber =  "2";
                break;

            case R.id.btn3:
                selectedNumber =  "3";
                break;

            case R.id.btn4:
                selectedNumber =  "4";
                break;

            case R.id.btn5:
                selectedNumber =  "5";
                break;

            case R.id.btn6:
                selectedNumber =  "6";
                break;

            case R.id.btn7:
                selectedNumber =  "7";
                break;

            case R.id.btn8:
                selectedNumber =  "8";
                break;

            case R.id.btn9:
                selectedNumber =  "9";
                break;

            case R.id.btncoma:
                if(!isResultNumberEmpty() && !res.getText().toString().contains(".")){
                    selectedNumber = ".";
                }
                break;
        }

        res.setText(inputNumber.concat(selectedNumber));
    }

    private Boolean isResultNumberEmpty() {
        return res.getText().toString().equals("");
    }


    public void operadores(View view) {
        String ope1;

        switch (view.getId()) {

            case R.id.btnSuma:
                if (isResultNumberEmpty()) {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    op = 1;
                }
                break;

            case R.id.btnMenos:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    op = 2;
                } catch (NumberFormatException nfe) {
                }
                break;

            case R.id.btnmtl:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    op = 3;
                } catch (NumberFormatException nfe) {
                }
                break;

            case R.id.btndv:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    op = 4;
                } catch (NumberFormatException nfe) {
                }
                break;
            case R.id.btnpor:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    op = 5;
                } catch (NumberFormatException nfe) {
                }
                break;
        }
        res.setText(" ");
    }


    public void igual(View view) {

        try {
            String ope2 = res.getText().toString();
         //   res.setText("");
            switch (op) {
                case 1:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operando1 + operand2;
                    operando1 = resultado;
                    break;
                case 2:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operando1 - operand2;
                    operando1 = resultado;
                    break;

                case 3:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operando1*operand2;
                    operando1 = resultado;
                    break;
                case 4:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operando1 / operand2;
                    operando1 = resultado;
                    break;
                case 5:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operand2 *( operando1/100.0);
                    operando1 = resultado;
                    break;
            }
            res.setText("" + resultado);
        } catch (NumberFormatException nfe) {
        }
    }

    public void clear(View view) {
       switch (view.getId()){

           case R.id.btndelete:
               res.setText("");
               operando1=0.0;
               operand2=0.0;
           break;

           case R.id.btndel:
               if(!res.getText().toString().equals("")){
                   res.setText(res.getText().subSequence(0, res.getText().length()-1)+"");
               }

       }

    }
}
