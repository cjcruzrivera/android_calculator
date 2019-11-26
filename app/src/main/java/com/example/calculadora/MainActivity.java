package com.example.calculadora;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    double res = 0;
    String valor1 = "";
    String valor2 = "";
    String operacion;
    CharSequence text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Esto que haria?
        final TextView oper =(TextView)findViewById(R.id.operacion);
        String operation = oper.getText().toString();

        char v1 = operation.charAt(0);
        char v2 = operation.charAt(2);

        valor1 = String.valueOf(v1);
        valor2 = String.valueOf(v2); */
    }

    public void onClickNum(View view){
        int id = view.getId();
        final TextView op =(TextView)findViewById(R.id.operacion);
        final Button btn =(Button) findViewById(id);

        text = btn.getText();
        op.append(text);
    }

    public void onClickIgual(View view){
        final TextView result =(TextView)findViewById(R.id.resultado);
        final TextView op =(TextView)findViewById(R.id.operacion);
        valor2 = op.getText().toString();

        switch (operacion){
            case "+":
                sum();
                break;
            case "-":
                resta();
                break;

        }
        op.setText("");
        valor1 = String.valueOf(res);
        result.setText(valor1);
        valor2="";
        //float r = sum();
        //result.setText(String.valueOf(r));
        //result.append(text);
    }


    public void onClickClean(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);
        res.setText("");
        op.setText("");
        valor1 = "";
        valor2 = "";
        operacion = "";
    }

    public void onClickSum(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);

        if (valor1 == "" && valor2 == ""){
            valor1 = op.getText().toString();
         }else {
            if (operacion == ""){
                valor2 = op.getText().toString();
                valor1 = String.valueOf(sum());
            }else{
                onClickIgual(view);
            }
        }
        operacion = "+";
        op.setText("");
        res.setText(valor1 + " + ");
    }

    public void onClickResta(View view){
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);
        if (valor1 == "" && valor2 == ""){
            valor1 = op.getText().toString();
        }else {
            if(operacion==""){
                valor1 = String.valueOf(resta());
                valor2 = op.getText().toString();
            }else{
                onClickIgual(view);
            }
        }
        operacion="-";
        op.setText("");
        res.setText(valor1 + " - ");
    }

    private double resta(){
        try {
            double s1 = Double.parseDouble(valor1);
            double s2 = Double.parseDouble(valor2);
            res = s1 - s2;
        }catch (NumberFormatException ex){

        }

        return res;
    }

    private double sum()
    {
        try {
            double s1 = Double.parseDouble(valor1);
            double s2 = Double.parseDouble(valor2);
            res = s1 + s2;

        }catch (NumberFormatException exp){

        }

        return res;
    }

}
