package com.example.appparcial2alvarado_deleon;

public class User {

    public String cedula;
    public String nombre;
    public String pass;
    public String rol;


    public User(String cedula, String nombre, String pass, String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.pass = pass;
        this.rol = rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
