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

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean updateNotas(String materia, char calificacion){
        boolean resultado = false;
        if (materia.equals("Calculo 1")){
            this.calculo1 = calificacion;
            return true;
        }else if(materia.equals("Calculo 2")){
            this.calculo2 = calificacion;
            return true;
        }else if(materia.equals("Programacion 1")){
            this.programacion1 = calificacion;
            return true;
        }else if(materia.equals("Programacion 2")){
            this.programacion2 = calificacion;
            return true;
        }else if(materia.equals("Bases de datos 1")){
            this.bases_de_datos1 = calificacion;
            return true;
        }else if(materia.equals("Bases de datos 2")){
            this.bases_de_datos2 = calificacion;
            return true;
        }else if(materia.equals("Ecuaciones diferenciales")){
            this.ecuaciones_diferenciales = calificacion;
            return true;
        }else if(materia.equals("Matematicas superiores")){
            this.matematicas_superiores = calificacion;
            return true;
        }else if(materia.equals("Ingenieria de requisitos")){
            this.ingenieria_de_requisitos = calificacion;
            return true;
        }else if(materia.equals("Ingenieria web")){
            this.ingenieria_web = calificacion;
            return true;
        }else{
            return resultado;
        }
    }
}
