package com.example.practicatema6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Intent persona;
    Intent blocdenotas;
    ImageView imgSiluetaPersona;
    ImageView imgBlocDeNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgSiluetaPersona = findViewById(R.id.imgSiluetaPersona);
        imgBlocDeNotas = findViewById(R.id.imgBlocDeNotas);
        persona  = new Intent(this, ActivityPersona.class);
        blocdenotas  = new Intent(this, ActivityBlocDeNotas.class);

        imgSiluetaPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(persona);
            }
        });
        imgBlocDeNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(blocdenotas);
            }
        });
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Persona:
                startActivity(persona);
                break;
            case R.id.BlocDeNotas:
                startActivity(blocdenotas);
                break;
        }
        return true;
    }

}
