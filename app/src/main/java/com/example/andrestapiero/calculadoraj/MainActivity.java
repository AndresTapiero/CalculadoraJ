package com.example.andrestapiero.calculadoraj;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int operator;
    private TextView textViewResult;
    private TextView textViewGuia;
    private double number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
       // number1 = savedInstanceState.get
        //
        textViewResult = findViewById(R.id.resultado);
        textViewGuia= findViewById(R.id.guia);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
      //  outState.putInt("selec", (String) inputNumber.concat(selectedNumber));
        super.onSaveInstanceState(outState);
    }

    private void setOperator (int operator) {
        this.operator = operator;
    }

    private int getOperator() {
        return this.operator;
    }

    private double getFirstNumber() {
        return this.number1;
    }

    private double getSecondNumber() {
        return this.number2;
    }

    private void setFirstNumber(double number) {
        this.number1 = number;
    }

    private void setSecondNumber(double number) {
        this.number2 = number;
    }

    public void onClickListenerNumbers(View view) {
        String inputNumber = textViewResult.getText().toString();
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
                if (!isResultNumberEmpty() && !textViewResult.getText().toString().contains(".")) {
                    selectedNumber = ".";
                }else{
                    if(isResultNumberEmpty()){
                    selectedNumber = "0.";}
                }
                break;
        }
        textViewResult.setText(inputNumber.concat(selectedNumber));
     //   textViewGuia.setText(inputNumber.concat(selectedNumber));
    }

    private Boolean isResultNumberEmpty() {         //Metodo que compara si el String esta vacio
        return textViewResult.getText().toString().equals("");
    }

    public void onClickListenerOperators(View view) {
        int selectedOperator = 0;
       // String error = "Error";
        switch (view.getId()) {
            case R.id.btnSuma:
                selectedOperator = 1;
//                signo="+";
                break;
            case R.id.btnMenos:
                selectedOperator = 2;
                break;
            case R.id.btnMtl:
                selectedOperator = 3;
                break;
            case R.id.btndv:
                selectedOperator = 4;
                break;
            case R.id.btnpor:
                if(!isResultNumberEmpty()){
                selectedOperator = 5;
                }else{
                 //   textViewResult.setText(error);
                    Toast.makeText(this, "Error inserte número", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        saveFirstNumber();
        setOperator(selectedOperator);
        textViewResult.setText("");
    }

    private void saveFirstNumber(){
        String textNumber1 = textViewResult.getText().toString();
        if (!textNumber1.equals("")) {
            setFirstNumber(Double.parseDouble(textNumber1));
        }
    }

    public void onClickListenerEqual(View view) {
        double result=0;
        if (!isResultNumberEmpty()) {
            String textNumber2 = textViewResult.getText().toString();
            setSecondNumber(Double.parseDouble(textNumber2));
            switch (getOperator()) {
                case 1:
                    result = getFirstNumber() + getSecondNumber();
             
                    break;
                case 2:
                    result = getFirstNumber() - getSecondNumber();
                    break;
                case 3:
                    result = getFirstNumber() * getSecondNumber();
                    break;
                case 4:
                    result = getFirstNumber() / getSecondNumber();
                    break;
                case 5:
                    result = getSecondNumber() * (getFirstNumber() / 100.0);
                    break;
                    default:
                        result=getSecondNumber();
            }
            textViewResult.setText(""+result);
            setFirstNumber(result);
        }
    }

    public void onClickListenerClear(View view) {
        switch (view.getId()) {

            case R.id.btndelete:
                textViewResult.setText("");
                textViewGuia.setText("");
                setFirstNumber(0.0);
                setSecondNumber(0.0);
                break;
            case R.id.btndel:
                if (!isResultNumberEmpty()) {
                    textViewResult.setText(textViewResult.getText().subSequence(0, textViewResult.getText().length() - 1));
                }
        }
    }
}
