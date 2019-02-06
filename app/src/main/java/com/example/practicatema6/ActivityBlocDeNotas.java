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

public class ActivityBlocDeNotas extends AppCompatActivity {
    EditText txt_Bloc;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloc_de_notas);
        sp = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        txt_Bloc = findViewById(R.id.txt_Bloc);
        txt_Bloc.setText(sp.getString("bloc_notas", ""));

    }

    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("bloc_notas", txt_Bloc.getText().toString());
        editor.commit();
        Toast.makeText(this, getResources().getString(R.string.toast_correcto), Toast.LENGTH_LONG).show();
        return false;
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_blocdenotas, menu);
        return true;
    }

}
