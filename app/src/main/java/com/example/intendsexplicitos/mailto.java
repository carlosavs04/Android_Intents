package com.example.intendsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mailto extends AppCompatActivity implements View.OnClickListener {

    EditText correo, asunto;
    Button enviar;
    String direccion, motivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailto);

        enviar = (Button) findViewById(R.id.enviar);
        correo = (EditText) findViewById(R.id.correo);
        asunto = (EditText) findViewById(R.id.asunto);
        direccion = correo.getText().toString();
        motivo = asunto.getText().toString();

        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.enviar){
            Intent enviarCorreo = new Intent(Intent.ACTION_SEND);
            enviarCorreo.setType("*/*");
            enviarCorreo.putExtra(Intent.EXTRA_EMAIL, direccion);
            enviarCorreo.putExtra(Intent.EXTRA_SUBJECT, motivo);

            if(enviarCorreo.resolveActivity(getPackageManager()) != null) {
                startActivity(enviarCorreo);
            }
        }

    }
}