package com.example.appparcial2alvarado_deleon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class historial extends base {
    private ListView listview;
    private ArrayList<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        Load_or_inicializate_users();
        Load_or_inicializate_notas();
        LoadAllData();
        TextView tvnombre = (TextView)findViewById(R.id.Nombre);
        tvnombre.setText( "Bienvenido  " + current_user.nombre);
        TextView tvusuario = (TextView)findViewById(R.id.Prueba);
        tvusuario.setText("Usuario en Linea: " + current_user.nombre + " " + current_user.cedula);
        listview = (ListView) findViewById(R.id.lstUsuarios);

        names = new ArrayList<String>();
        names.add("Programación 1");
        names.add("Programación 2");
        names.add("Desarrollo Movil");
        names.add("Gerencia de Proyectos");
        names.add("Base de datos");
        names.add("Calculo");
        names.add("Fisica");
        names.add("Quimica");
        names.add("Mantenimientos y Pruebas");
        names.add("HCI");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);
    }




}
