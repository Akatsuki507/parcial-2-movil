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
        Load_or_inicializate_notas();
        LoadAllData();

        identity= findViewById(R.id.txtCedula);
        pass= findViewById(R.id.txtContrasena);

        Btn = (Button)findViewById(R.id.btn);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CD = identity.getText().toString();
                String PASS = pass.getText().toString();
                if (verificar(CD,PASS)){

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario o Contraseña Erronea",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean verificar(String email, String pass ){
        for (int counter = 0; counter < users.size(); counter++) {
            if((users.get(counter).cedula.equals(email)) && (users.get(counter).pass.equals(pass)) ){
                saveCurrentUser(users.get(counter));
                return true;
            }
        }

        return false;
    }
}
