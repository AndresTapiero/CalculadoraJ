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
        String val;
        switch (view.getId()) {
            case R.id.btn0:
                val = res.getText().toString();
                val = val + "0";
                res.setText(val);
                break;

            case R.id.btn1:
                val = res.getText().toString();
                val = val + "1";
                res.setText(val);
                break;

            case R.id.btn2:
                val = res.getText().toString();
                val = val + "2";
                res.setText(val);
                break;

            case R.id.btn3:
                val = res.getText().toString();
                val = val + "3";
                res.setText(val);
                break;

            case R.id.btn4:
                val = res.getText().toString();
                val = val + "4";
                res.setText(val);
                break;

            case R.id.btn5:
                val = res.getText().toString();
                val = val + "5";
                res.setText(val);
                break;

            case R.id.btn6:
                val = res.getText().toString();
                val = val + "6";
                res.setText(val);
                break;

            case R.id.btn7:
                val = res.getText().toString();
                val = val + "7";
                res.setText(val);
                break;

            case R.id.btn8:
                val = res.getText().toString();
                val = val + "8";
                res.setText(val);
                break;

            case R.id.btn9:
                val = res.getText().toString();
                val = val + "9";
                res.setText(val);
                break;
            case R.id.btncoma:
                val = res.getText().toString();
                val = val + ".";
                res.setText(val);
                break;
        }
    }


    public void operadores(View view) {
        String ope1;


        switch (view.getId()) {

            case R.id.btnSuma:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    res.setText(" ");
                    op = 1;
                } catch (NumberFormatException nfe) {
                }
                break;

            case R.id.btnMenos:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    res.setText(" ");
                    op = 2;
                } catch (NumberFormatException nfe) {
                }
                break;

            case R.id.btnmtl:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    res.setText(" ");
                    op = 3;
                } catch (NumberFormatException nfe) {
                }
                break;

            case R.id.btndv:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    res.setText(" ");
                    op = 4;
                } catch (NumberFormatException nfe) {
                }
                break;
            case R.id.btnpor:
                try {
                    ope1 = res.getText().toString();
                    operando1 = Double.parseDouble(ope1);
                    res.setText(" ");
                    op = 5;
                } catch (NumberFormatException nfe) {
                }
                break;
        }
    }


    public void igual(View view) {

        try {
            String ope2 = res.getText().toString();
            res.setText("");
            switch (op) {
                case 1:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operando1 + operand2;
                    res.setText("" + resultado);
                    operando1 = resultado;
                    break;
                case 2:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operando1 - operand2;
                    res.setText("" + resultado);
                    operando1 = resultado;
                    break;

                case 3:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operando1*operand2;
                    res.setText("" + resultado);
                    operando1 = resultado;
                    break;
                case 4:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operando1 / operand2;
                    res.setText("" + resultado);
                    operando1 = resultado;
                    break;
                case 5:
                    operand2 = Double.parseDouble(ope2);
                    resultado = operand2 *( operando1/100.0);
                    res.setText("" + resultado);
                    operando1 = resultado;
                    break;
            }
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
