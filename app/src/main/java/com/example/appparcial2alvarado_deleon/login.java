package com.example.appparcial2alvarado_deleon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends base {
    EditText identity,pass;
    private Button Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Metodos heredados de clase Base
        Load_or_inicializate_users();
        LoadAllData();

        // Probando datos cargados
        Log.e("TEST", "==============================================TEST====================================================");
        Log.e("TEST", "CANTIDAD DE USUARIOS: " + String.valueOf(users.size()));
        for (int counter = 0; counter < users.size(); counter++) {
            Log.e("TEST", "| NOMBRE: " + users.get(counter).nombre + "| ROL: " + users.get(counter).rol);
        }
        Log.e("TEST", "==============================================TEST====================================================");

        identity= findViewById(R.id.txtCedula);
        pass= findViewById(R.id.txtContrasena);

        Btn = (Button)findViewById(R.id.btnValidar);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CD = identity.getText().toString();
                String PASS = pass.getText().toString();


    }
            });


}}
