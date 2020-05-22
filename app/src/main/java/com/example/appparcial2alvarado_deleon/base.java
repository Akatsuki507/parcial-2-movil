package com.example.appparcial2alvarado_deleon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

// Clase base para heredar todos los metodos
public class base extends AppCompatActivity {
    ArrayList<User> users;  //// Lista de usuarios registrados
    User current_user; //// Usuario logueado actualmente
    Nota notas;

    // Cargar todos los datos
    public void LoadAllData(){
        loadData();
        loadCurrentUser();
    }

    public void Load_or_inicializate_notas(){
        if(loadData()){
            inicializar_notas();
        }
    }

    public boolean inicializar_notas(){
        try {
            notas = new Nota();
            Gson gson = new Gson();
            String json = gson.toJson(notas);
            OutputStreamWriter fn = new OutputStreamWriter(openFileOutput("user.txt", Context.MODE_PRIVATE));
            fn.write(json);
            fn.close();
            Toast.makeText(getApplicationContext(),"Usted se ha registrado de un modo exitoso UwU", Toast.LENGTH_SHORT).show();
            return true;
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error en la data ingresada"+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            return false;
        }


    }



    public void Load_or_inicializate_users(){
        // Quema los usuarios si no existen
        if(loadData()){
            // Quemar datos de usuarios
            User estudiante = new User("8-888-888","Shantal De Leon", "123", "estudiante");
            User profesor = new User("8-941-856", "Alfonso Alvarado", "123", "profesor");
            users.add(estudiante);
            users.add(profesor);
            saveData();
        }
    }

    // Guardar usuario actual desdpues del login
    private void saveCurrentUser(User usuario){
        SharedPreferences sharepreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharepreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(usuario);
        editor.putString("current_user", json);
        editor.apply();
        loadData();
    }

    // Guardar Usuarios
    private void saveData() {
        SharedPreferences sharepreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharepreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(users);
        editor.putString("usuarios", json);
        editor.apply();
        loadData();
    }

    // Cargar usuario actual
    public boolean loadCurrentUser(){
        SharedPreferences sharepreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharepreferences.getString("current_user", null);
        Type type = new TypeToken<User>(){}.getType();
        current_user = gson.fromJson(json, type);


        if(current_user == null){
            return false;
        }
        Log.e("USUARIOS", "==============================================USUARIO ACTUAL====================================================");
        Log.e("USUARIO", "| USUARIO: " + current_user  + " | NOMBRE: " + current_user.nombre + "| PASS: " + current_user.pass + "| ROL: " +  current_user.rol);
        Log.e("USUARIOS", "==============================================USUARIO ACTUAL====================================================");
        return true;
    }

    // Cargar todos los usuarios
    public boolean loadData(){
        SharedPreferences sharepreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharepreferences.getString("usuarios", null);
        Type type = new TypeToken<ArrayList<User>>(){}.getType();
        users = gson.fromJson(json, type);

        if(users == null){
            users = new ArrayList<>();
            Log.e("USUARIOS", "==============================================LISTA DE USUARIOS====================================================");
            Log.e("USUARIOS", "=========================================NO HAY USUARIOS REGISTRADOS===============================================");
            Log.e("USUARIOS", "==============================================LISTA DE USUARIOS====================================================");
            return false;
        }
        Log.e("USUARIOS", "==============================================LISTA DE USUARIOS====================================================");
        Log.e("USUARIOS", "CANTIDAD DE USUARIOS: " + String.valueOf(users.size()));
        for (int counter = 0; counter < users.size(); counter++) {
            Log.e("USUARIOS", "| NOMBRE: " + users.get(counter).nombre + "| ROL: " + users.get(counter).rol);
        }
        Log.e("USUARIOS", "==============================================LISTA DE USUARIOS====================================================");
        return true;
    }
}
