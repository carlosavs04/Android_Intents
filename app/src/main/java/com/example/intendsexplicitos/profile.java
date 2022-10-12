package com.example.intendsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.net.MailTo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class profile extends AppCompatActivity implements View.OnClickListener {

    String nbr, edd, cro;
    TextView nom, ed, txtmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtmail = (TextView) findViewById(R.id.txtmail);
        nom = (TextView) findViewById(R.id.nom);
        ed = (TextView) findViewById(R.id.ed);

        Bundle getDatos = this.getIntent().getExtras();
        nbr = getDatos.getString("enviarNombre");
        edd = getDatos.getString("enviarEdad");
        cro = getDatos.getString("enviarCorreo");

        nom.setText("Nombre: " + nbr);
        ed.setText("Edad: " + edd);
        txtmail.setText("Correo: " + cro);
    }


    @Override
    public void onClick(View view) {

    }
}