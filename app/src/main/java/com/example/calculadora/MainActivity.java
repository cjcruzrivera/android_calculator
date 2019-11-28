package com.example.calculadora;

import java.lang.Math;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    double result = 0;
    String valor1 = "";
    String valor2 = "";
    String operacion;
    CharSequence text = "";
    String memoria = "";
    String autor1 = "Camilo José Cruz Rivera";
    String autor2 = "Diana Melissa Millares Gutiérrez";
    String opText = "";
    String resText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            opText = savedInstanceState.getString("opText");
            resText = savedInstanceState.getString("resText");
            result = savedInstanceState.getDouble("res");
            operacion = savedInstanceState.getString("operacion");
            valor1 = savedInstanceState.getString("valor1");
            valor2 = savedInstanceState.getString("valor2");
            memoria = savedInstanceState.getString("memoria");

            //outState.putString("opText", op.getText().toString());
            //outState.putDouble("res", result);
            //outState.putString("operacion", operacion);
            //outState.putString("valor1", valor1);
            //outState.putString("valor2", valor2);
            //outState.putString("memoria", memoria);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        final TextView op = findViewById(R.id.operacion);
        final TextView mem = findViewById(R.id.memoria);
        final TextView res = findViewById(R.id.resultado);

        if (resText != "") {
            res.setText(resText);
        }

        if (opText != "") {
            op.setText(opText);
        }

        if (memoria != "") {
            mem.setText("Mem: " + memoria);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        final TextView op = findViewById(R.id.operacion);
        final TextView mem = findViewById(R.id.memoria);
        final TextView res = findViewById(R.id.resultado);

        if (resText != "") {
            res.setText(resText);
        }

        if (opText != "") {
            op.setText(opText);
        }

        if (memoria != "") {
            mem.setText("Mem: " + memoria);
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        final TextView op = (TextView) findViewById(R.id.operacion);

        outState.putString("opText", op.getText().toString());
        outState.putDouble("res", result);
        outState.putString("operacion", operacion);
        outState.putString("valor1", valor1);
        outState.putString("valor2", valor2);
        outState.putString("memoria", memoria);
    }

    public void onClickNum(View view) {
        int id = view.getId();
        final TextView op = (TextView) findViewById(R.id.operacion);
        final Button btn = (Button) findViewById(id);

        text = btn.getText();
        op.append(text);
    }

    public void onClickMC(View view) {
        final TextView mem = findViewById(R.id.memoria);
        mem.setText("Mem: ");
        memoria = "";
    }

    public void onClickMR(View view) {
        final TextView mem = findViewById(R.id.memoria);
        final TextView op = findViewById(R.id.operacion);
        mem.setText("Mem: ");
        valor1 = "";
        op.setText(memoria);
        memoria = "";
    }

    public void onClickMMenos(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView mem = findViewById(R.id.memoria);

        String val;
        if (valor1 == "") {
            val = op.getText().toString();
        } else {
            val = valor1;
        }
        double memAux = 0;
        try {
            if (memoria != "") {
                memAux = Double.parseDouble(memoria);
            }

            memAux = memAux - Double.parseDouble(val);
        } catch (NumberFormatException ex) {
        }
        op.setText("");

        memoria = String.valueOf(memAux);
        mem.setText("Mem: " + memoria);

    }

    public void onClickMMas(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView mem = findViewById(R.id.memoria);
        String val;
        if (valor1 == "") {
            val = op.getText().toString();
        } else {
            val = valor1;
        }
        op.setText("");
        double memAux = 0;
        try {
            if (memoria != "") {
                memAux = Double.parseDouble(memoria);
            }

            memAux = memAux + Double.parseDouble(val);
        } catch (NumberFormatException ex) {
        }

        memoria = String.valueOf(memAux);
        mem.setText("Mem: " + memoria);


    }

    public void onClickIgual(View view) {
        final TextView res = (TextView) findViewById(R.id.resultado);
        final TextView op = (TextView) findViewById(R.id.operacion);

        if (valor1 == "") {
            res.setText(valor1);
        } else {
            valor2 = op.getText().toString();

            switch (operacion) {
                case "+":
                    sum();
                    break;
                case "-":
                    resta();
                    break;
                case "*":
                    mult();
                    break;
                case "/":
                    division();
                    break;
                case "^":
                    potencia();
                    break;
                case "√":
                    raiz();
                    break;
            }

            op.setText("");
            valor1 = String.valueOf(result);
            res.setText(valor1);
            valor2 = "";
            operacion = "";
        }
        //float r = sum();
        //result.setText(String.valueOf(r));
        //result.append(text);
    }


    public void onClickClean(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);

        res.setText("Resultado:");
        op.setText("");

        valor1 = "";
        valor2 = "";
        operacion = "";
        result = 0;
    }

    public void onClickSum(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);

        if (valor1 == "" && valor2 == "") {
            valor1 = op.getText().toString();
        } else {
            if (operacion == "") {
                valor2 = op.getText().toString();
                valor1 = String.valueOf(sum());
            } else {
                onClickIgual(view);
            }
        }
        operacion = "+";
        op.setText("");
        res.setText(valor1 + " + ");
    }

    public void onClickResta(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);

        if (valor1 == "" && valor2 == "") {
            valor1 = op.getText().toString();
        } else {
            if (operacion == "") {
                valor1 = String.valueOf(resta());
                valor2 = op.getText().toString();
            } else {
                onClickIgual(view);
            }
        }
        operacion = "-";
        op.setText("");
        res.setText(valor1 + " - ");
    }

    public void onClickMult(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);

        if (valor1 == "" && valor2 == "") {
            valor1 = op.getText().toString();
        } else {
            if (operacion == "") {
                valor1 = String.valueOf(mult());
                valor2 = op.getText().toString();
            } else {
                onClickIgual(view);
            }
        }
        operacion = "*";
        op.setText("");
        res.setText(valor1 + " * ");
    }

    public void onClickDivision(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);

        if (valor1 == "" && valor2 == "") {
            valor1 = op.getText().toString();
        } else {
            if (operacion == "") {
                valor1 = String.valueOf(division());
                valor2 = op.getText().toString();
            } else {
                onClickIgual(view);
            }
        }
        operacion = "/";
        op.setText("");
        res.setText(valor1 + " / ");
    }

    public void onClickPotencia(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);

        if (valor1 == "" && valor2 == "") {
            valor1 = op.getText().toString();
        } else {
            if (operacion == "") {
                valor1 = String.valueOf(potencia());
                valor2 = op.getText().toString();
            } else {
                onClickIgual(view);
            }
        }

        operacion = "^";
        op.setText("");
        res.setText(valor1 + " ^ ");
    }

    public void onClickRaiz(View view) {
        final TextView op = findViewById(R.id.operacion);
        final TextView res = findViewById(R.id.resultado);

        if (valor1 == "") {
            valor1 = op.getText().toString();
        } else {
            if (operacion == "") {
                valor1 = String.valueOf(raiz());
            } else {
                onClickIgual(view);
            }
        }

        operacion = "√";
        res.setText("√" + valor1);
    }

    public void onClickSend(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        String mensaje = "Resultado: " + String.valueOf(result) + "\n" + autor1 + "\n" + autor2;
        intent.putExtra(Intent.EXTRA_TEXT, mensaje);//

        startActivity(intent);
    }

    private double resta() {
        try {
            double s1 = Double.parseDouble(valor1);
            double s2 = Double.parseDouble(valor2);
            result = s1 - s2;
        } catch (NumberFormatException ex) {

        }

        return result;
    }

    private double sum() {
        try {
            double s1 = Double.parseDouble(valor1);
            double s2 = Double.parseDouble(valor2);
            result = s1 + s2;

        } catch (NumberFormatException exp) {

        }

        return result;
    }

    private double mult() {
        try {
            double s1 = Double.parseDouble(valor1);
            double s2 = Double.parseDouble(valor2);
            result = s1 * s2;

        } catch (NumberFormatException exp) {

        }

        return result;
    }

    private double division() {
        try {
            double s1 = Double.parseDouble(valor1);
            double s2 = Double.parseDouble(valor2);
            result = s1 / s2;

        } catch (NumberFormatException exp) {

        }

        return result;
    }

    private double potencia() {
        try {
            double s1 = Double.parseDouble(valor1);
            double s2 = Double.parseDouble(valor2);
            result = Math.pow(s1, s2);

        } catch (NumberFormatException exp) {

        }

        return result;
    }

    private double raiz() {
        try {
            double s1 = Double.parseDouble(valor1);
            //double s2 = Double.parseDouble(valor2);
            result = Math.sqrt(s1);

        } catch (NumberFormatException exp) {

        }

        return result;
    }


}
