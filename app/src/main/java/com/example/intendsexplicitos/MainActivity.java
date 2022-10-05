package com.example.intendsexplicitos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String url = "https://www.google.com.mx/?hl=es-419";
    Button btnIntent1, btnIntent2, btnIntent3, btnIntent4, btnIntent5;
    ImageView imagen;
    Uri ubicacion = Uri.parse("google.streetview:cbll=46.414382,10.013988");
    String numeroTelefono = "+528713321257", mail = "carlos.avalos@gmail.com", asunto = "Nuevo mensaje";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntent1 = (Button) findViewById(R.id.btnIntent1);
        btnIntent2 = (Button) findViewById(R.id.btnIntent2);
        btnIntent3 = (Button) findViewById(R.id.btnIntent3);
        btnIntent4 = (Button) findViewById(R.id.btnIntent4);
        btnIntent5 = (Button) findViewById(R.id.btnIntent5);
        imagen = (ImageView) findViewById(R.id.imagen);

        btnIntent1.setOnClickListener(this);
        btnIntent2.setOnClickListener(this);
        btnIntent3.setOnClickListener(this);
        btnIntent4.setOnClickListener(this);
        btnIntent5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnIntent1) {
            Uri webGoogle = Uri.parse(url);
            Intent abrirGoogle = new Intent(Intent.ACTION_VIEW, webGoogle);

            if (abrirGoogle.resolveActivity(getPackageManager()) != null) {
                startActivity(abrirGoogle);
            }
        }

        if (view.getId() == R.id.btnIntent2) {
            Intent abrirCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (abrirCamara.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(abrirCamara, 0);
            }
        }

        if(view.getId() == R.id.btnIntent3)
        {
            Intent abrirUbicacion = new Intent(Intent.ACTION_VIEW, ubicacion);
            abrirUbicacion.setPackage("com.google.android.apps.maps");
            if (abrirUbicacion.resolveActivity(getPackageManager()) != null) {
                startActivity(abrirUbicacion);
            }
        }

        if (view.getId() == R.id.btnIntent4) {
            Intent enviarCorreo = new Intent(Intent.ACTION_SEND);
            enviarCorreo.setType("*/*");
            enviarCorreo.putExtra(Intent.EXTRA_EMAIL, mail);
            enviarCorreo.putExtra(Intent.EXTRA_SUBJECT, asunto);

            if (enviarCorreo.resolveActivity(getPackageManager()) != null) {
                startActivity(enviarCorreo);
            }
        }

        if (view.getId() == R.id.btnIntent5)
        {
            Intent llamar = new Intent(Intent.ACTION_DIAL);
            llamar.setData(Uri.parse("tel:" + numeroTelefono));

            if(llamar.resolveActivity(getPackageManager()) != null)
            {
                startActivity(llamar);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap nuevaFoto = data.getParcelableExtra("data");
        imagen.setImageBitmap(nuevaFoto);
    }
}
