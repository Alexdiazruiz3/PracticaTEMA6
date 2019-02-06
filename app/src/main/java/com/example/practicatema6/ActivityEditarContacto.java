package com.example.practicatema6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityEditarContacto extends AppCompatActivity {

    SharedPreferences guardado;
    SharedPreferences.Editor editar;
    EditText txtNumero1, txtNumero2, txtNumero3;
    EditText txtCorreo1, txtCorreo2, txtCorreo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contacto);

        txtNumero1 = findViewById(R.id.txtNumero1);
        txtNumero2 = findViewById(R.id.txtNumero2);
        txtNumero3 = findViewById(R.id.txtNumero3);

        txtCorreo1 = findViewById(R.id.txtCorreo1);
        txtCorreo2 = findViewById(R.id.txtCorreo2);
        txtCorreo3 = findViewById(R.id.txtCorreo3);

        guardado = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        txtNumero1.setText(guardado.getString("Número1", ""));
        txtCorreo1.setText(guardado.getString("Correo1", ""));
        txtNumero2.setText(guardado.getString("Numero2", ""));
        txtCorreo2.setText(guardado.getString("Correo2", ""));
        txtNumero3.setText(guardado.getString("Numero3", ""));
        txtCorreo3.setText(guardado.getString("Correo2",""));
        editar = guardado.edit();
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_blocdenotas, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        SharedPreferences.Editor editar = guardado.edit();
        editar.putString("Número1", txtNumero1.getText().toString());
        editar.putString("Numero2", txtNumero2.getText().toString());
        editar.putString("Numero3", txtNumero3.getText().toString());
        editar.putString("Correo1", txtCorreo1.getText().toString());
        editar.putString("Correo2", txtCorreo2.getText().toString());
        editar.putString("Correo3", txtCorreo3.getText().toString());
        editar.commit();
        Toast.makeText(this, getResources().getString(R.string.toast_correcto), Toast.LENGTH_LONG).show();
        return false;
    }





}
