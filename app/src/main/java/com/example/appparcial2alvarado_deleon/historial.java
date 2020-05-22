package com.example.appparcial2alvarado_deleon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.widget.ArrayAdapter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class historial extends base {


    private ListView NotasList;
    private ArrayList<String> names;
    private TextView selected;
    private EditText Calificacion;
    private Button buttonUpdate;

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





        NotasList = (ListView) findViewById(R.id.NotasList);
        selected = (TextView) findViewById(R.id.Seleccionado);
        Calificacion = (EditText) findViewById(R.id.Calificacion);
        buttonUpdate = (Button) findViewById(R.id.ChangeNote);

        names = new ArrayList<String>();
        names.add("Calculo 1: " + notas.calculo1);
        names.add("Calculo 2: " + notas.calculo2);
        names.add("Programacion 1: " + notas.programacion1);
        names.add("Programacion 2: " + notas.programacion2);
        names.add("Bases de datos 1: " + notas.bases_de_datos1);
        names.add("Bases de datos 2: " + notas.bases_de_datos2);
        names.add("Ecuaciones diferenciales: " + notas.ecuaciones_diferenciales);
        names.add("Matematicas superiores: " + notas.matematicas_superiores);
        names.add("Ingenieria de requisitos: " + notas.ingenieria_de_requisitos);
        names.add("Ingenieria web: " + notas.ingenieria_web);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        NotasList.setAdapter(adapter);

        NotasList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String[] parts = names.get(position).split(":");
                selected.setText(parts[0]);
                Toast.makeText(historial.this, "Has pulsado: "+ names.get(position), Toast.LENGTH_LONG).show();
            }
        });


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char char_calificacion = Calificacion.getText().charAt(0);
                String materia = selected.getText().toString();
                boolean ejecutar_update = notas.updateNotas(materia , char_calificacion);

                Log.e("CALIFICACION", " ============= "+ char_calificacion +" ================== ");
                Log.e("MATERIA", " ============= "+ materia +" ================== ");
                Log.e("BOOLEAN", " ============= "+ ejecutar_update +" ================== ");
                updateNotas();
                Toast.makeText(historial.this, "Nota actualizada", Toast.LENGTH_LONG).show();

                LoadAllData();
                finish();
                startActivity(getIntent());
            }
        });


    }




}
