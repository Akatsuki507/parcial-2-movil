package com.example.appparcial2alvarado_deleon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class login extends base {

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
    }
}
