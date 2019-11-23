package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    float res = 0;
    String valor1;
    String valor2;
    CharSequence text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        final TextView oper =(TextView)findViewById(R.id.operacion);
        String operation = oper.getText().toString();

        char v1 = operation.charAt(0);
        char v2 = operation.charAt(2);

        valor1 = String.valueOf(v1);
        valor2 = String.valueOf(v2); */
    }

    public void onClickNum(View view)
    {
        int id = view.getId();
        final TextView op =(TextView)findViewById(R.id.operacion);
        final Button btn =(Button) findViewById(id);

        text = btn.getText();
        op.append(text);
    }

    public void onClickIgual(View view)
    {
        final TextView result =(TextView)findViewById(R.id.resultado);
        //float r = sum();
        //result.setText(String.valueOf(r));
        result.append(text);
    }

    private float sum()
    {
        float s1 = Float.parseFloat(valor1);
        float s2 = Float.parseFloat(valor2);

        res = s1 + s2;

        return res;
    }

    public void onClickClean(View view) {
        final TextView op =(TextView)findViewById(R.id.operacion);
        op.setText("");
    }
}
