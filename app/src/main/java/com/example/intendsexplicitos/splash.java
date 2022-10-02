package com.example.intendsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class splash extends AppCompatActivity implements View.OnClickListener {

    TextView contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.entrar).setOnClickListener(this);

        contador = (TextView) findViewById(R.id.contador);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                contador.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        }.start();
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
