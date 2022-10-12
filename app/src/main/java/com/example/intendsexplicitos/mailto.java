package com.example.intendsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mailto extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, edad, correo;
    Button enviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailto);

        enviar = (Button) findViewById(R.id.enviar);
        correo = (EditText) findViewById(R.id.correo);
        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);

        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.enviar) {
            String name = nombre.getText().toString();
            String age = edad.getText().toString();
            String mail = correo.getText().toString();

            Intent enviarDatos = new Intent(this, profile.class);
            enviarDatos.putExtra("enviarNombre", name);
            enviarDatos.putExtra("enviarEdad", age);
            enviarDatos.putExtra("enviarCorreo", mail);
            startActivity(enviarDatos);
        }
    }
}

