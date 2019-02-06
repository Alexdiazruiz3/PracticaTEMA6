package com.example.practicatema6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;

public class ActivityPersona extends AppCompatActivity {

    ImageView imgHombre1, imgHombre2, imgHombre3, imgMujer1, imgMujer2, imgMujer3;
    SharedPreferences guardado;
    SharedPreferences.Editor editar;
    Intent opcion1, opcion2;
    String telefono="";
    String correo_electronico="";
    String tipo="";
    String personas="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);

        imgHombre1 = findViewById(R.id.imgHombre1);
        imgHombre2 = findViewById(R.id.imgHombre2);
        imgHombre3 = findViewById(R.id.imgHombre3);

        imgMujer1 = findViewById(R.id.imgMujer1);
        imgMujer2 = findViewById(R.id.imgMujer2);
        imgMujer3 = findViewById(R.id.imgMujer3);


        registerForContextMenu(imgHombre1);
        registerForContextMenu(imgHombre2);
        registerForContextMenu(imgHombre3);

        registerForContextMenu(imgMujer1);
        registerForContextMenu(imgMujer2);
        registerForContextMenu(imgMujer3);

        guardado =getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editar = guardado.edit();

        imgHombre1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                personas="hombre1";
                return false;
            }
        });
        imgHombre2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                personas="hombre2";
                return false;
            }
        });
        imgHombre3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                personas="hombre3";
                return false;
            }
        });
        imgMujer1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                personas="mujer1";
                return false;
            }
        });
        imgMujer2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                personas="mujer2";
                return false;
            }
        });
        imgMujer3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                personas="mujer3";
                return false;
            }
        });

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_persona, menu);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editar, menu);
        return true;
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.opcion1:
                tipo="telefono";
                tipo+=personas;
                realizar_llamada();
                Log.i("APP1",telefono);
                break;
            case R.id.opcion2:
                tipo="correo";
                tipo+= personas;
                enviar_correo();
                Log.i("APP2",correo_electronico);
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void realizar_llamada() {
        telefono= guardado.getString(tipo,null);
        if(telefono.isEmpty())
        {
            Toast.makeText(this, "ERROR, No hay número de teléfono indicado.", Toast.LENGTH_LONG).show();
        }
        else {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Uri call = Uri.parse("tel: " + telefono);
                Intent surf = new Intent(Intent.ACTION_CALL, call);
                startActivity(surf);
            } else {
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        }

    }
    public void enviar_correo() {
        correo_electronico= guardado.getString(tipo, null);
        if (correo_electronico.isEmpty())
        {
            Toast.makeText(this, "Error, no hay correo indicado", Toast.LENGTH_LONG).show();
        } else {
            Intent intent_correo = new Intent(Intent.ACTION_SEND);
            intent_correo.setType("text/plain");
            intent_correo.putExtra(Intent.EXTRA_EMAIL, new String[]{correo_electronico});
            startActivity(intent_correo);
        }
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent2 = new Intent(this, ActivityEditarContacto.class);
        startActivity(intent2);
        return true;
    }
}
