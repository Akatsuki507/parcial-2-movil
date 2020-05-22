package com.example.appparcial2alvarado_deleon;

import android.os.Bundle;

import android.widget.ArrayAdapter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class historial extends base {


    private ListView NotasList;
    private ArrayList<String> names;
    private TextView selected;
    private EditText Calificacion;
    private EditText editName;
    private EditText editPass;
    private Button buttonUpdate;
    private Button UpdateName;
    private Button UpdatePass;

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

        editName = (EditText) findViewById(R.id.EditNombre);
        editPass = (EditText) findViewById(R.id.EditPass);
        UpdateName = (Button) findViewById(R.id.UpdateNAME);
        UpdatePass = (Button) findViewById(R.id.UpdatePASS);

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

                if( !(Calificacion.getText().toString() != null) || !(selected.getText().toString() != null)){
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
                }else{
                    Toast.makeText(historial.this, "Error: Selecciona una materia e introduce la nota por favor", Toast.LENGTH_LONG).show();
                }

            }
        });

        UpdateName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarNombre();
            }
        });

        UpdatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarPass();
            }
        });


    }


    public void actualizarNombre(){
        String name = editName.getText().toString();
        if ((name != null)){
            for (int counter = 0; counter < users.size(); counter++) {
                if((users.get(counter).cedula.equals(current_user.cedula)) && (users.get(counter).pass.equals(current_user.pass)) ){
                    users.get(counter).setNombre(name);
                    saveCurrentUser(users.get(counter));
                    saveData();
                    LoadAllData();
                    print_LOGs_User();
                    Log.e("TEST LIST", " PASS:" + users.get(counter).nombre);
                    Log.e("TEST CURRENT", " NAME:" + current_user.nombre);
                    Toast.makeText(historial.this, "Nombre Actualizado", Toast.LENGTH_LONG).show();
                }
            }

        }else{
            Toast.makeText(historial.this, "Nombre no puede estar vacio", Toast.LENGTH_LONG).show();
        }
    }


    public void actualizarPass(){
        String pass = editPass.getText().toString();
        if ((pass != null)){
            for (int counter = 0; counter < users.size(); counter++) {
                if((users.get(counter).cedula.equals(current_user.cedula)) && (users.get(counter).pass.equals(current_user.pass)) ){
                    users.get(counter).setPass(pass);
                    saveCurrentUser(users.get(counter));
                    saveData();
                    LoadAllData();
                    print_LOGs_User();
                    Log.e("TEST LIST", " PASS:" + users.get(counter).pass);
                    Log.e("TEST CURRENT", " PASS:" + current_user.pass);
                    Toast.makeText(historial.this, "Pass Actualizado", Toast.LENGTH_LONG).show();
                }
            }
        }else{
            Toast.makeText(historial.this, "Password no puede estar vacio", Toast.LENGTH_LONG).show();
        }
    }

    public void print_LOGs_User(){
        for (int counter = 0; counter < users.size(); counter++) {
            Log.e("TEST LIST", " Name:" + users.get(counter).nombre + " Pass:" + users.get(counter).pass);
        }
    }
}
