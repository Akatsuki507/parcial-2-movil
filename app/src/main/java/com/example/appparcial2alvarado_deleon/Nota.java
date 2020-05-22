package com.example.appparcial2alvarado_deleon;

public class Nota {
    public char calculo1;
    public char calculo2;
    public char programacion1;
    public char programacion2;
    public char bases_de_datos1;
    public char bases_de_datos2;
    public char ecuaciones_diferenciales;
    public char matematicas_superiores;
    public char ingenieria_de_requisitos;
    public char ingenieria_web;

    public boolean first;

    public Nota() {
        this.calculo1 = '-';
        this.calculo2 = '-';
        this.programacion1 = '-';
        this.programacion2 = '-';
        this.bases_de_datos1 = '-';
        this.bases_de_datos2 = '-';
        this.ecuaciones_diferenciales = '-';
        this.matematicas_superiores = '-';
        this.ingenieria_de_requisitos = '-';
        this.ingenieria_web = '-';
        this.first = false;
    }

    public void setCalculo1(char calculo1) {
        this.calculo1 = calculo1;
    }

    public void setCalculo2(char calculo2) {
        this.calculo2 = calculo2;
    }

    public void setProgramacion1(char programacion1) {
        this.programacion1 = programacion1;
    }

    public void setProgramacion2(char programacion2) {
        this.programacion2 = programacion2;
    }

    public void setBases_de_datos1(char bases_de_datos1) {
        this.bases_de_datos1 = bases_de_datos1;
    }

    public void setBases_de_datos2(char bases_de_datos2) {
        this.bases_de_datos2 = bases_de_datos2;
    }

    public void setEcuaciones_diferenciales(char ecuaciones_diferenciales) {
        this.ecuaciones_diferenciales = ecuaciones_diferenciales;
    }

    public void setMatematicas_superiores(char matematicas_superiores) {
        this.matematicas_superiores = matematicas_superiores;
    }

    public void setIngenieria_de_requisitos(char ingenieria_de_requisitos) {
        this.ingenieria_de_requisitos = ingenieria_de_requisitos;
    }

    public void setIngenieria_web(char ingenieria_web) {
        this.ingenieria_web = ingenieria_web;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }
}
