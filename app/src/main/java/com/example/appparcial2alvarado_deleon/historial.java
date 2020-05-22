package com.example.appparcial2alvarado_deleon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class historial extends base {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        Load_or_inicializate_users();
        Load_or_inicializate_notas();
        LoadAllData();

    }




}
