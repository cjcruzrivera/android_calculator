package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SendInfo extends AppCompatActivity {

    public static final String EXTRA_INFO = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String mensaje = intent.getStringExtra(EXTRA_INFO) ;

        TextView textView = (TextView) findViewById(R.id.resultado);
        textView.setText(mensaje);
    }
}
