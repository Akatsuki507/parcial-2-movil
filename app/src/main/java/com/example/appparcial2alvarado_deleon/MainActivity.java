package com.example.appparcial2alvarado_deleon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends base {
    RadioGroup Perfil;
    private Button btnlink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(current_user.rol.equals("estudiante")) {
            findViewById(R.id.rbtEstudiante).setVisibility(View.VISIBLE);
            findViewById(R.id.rbtUTP).setVisibility(View.VISIBLE);
            findViewById(R.id.rbtVirtual).setVisibility(View.VISIBLE);
            findViewById(R.id.rbtProfesor).setVisibility(View.GONE);
        }
        else{
            findViewById(R.id.rbtEstudiante).setVisibility(View.GONE);
            findViewById(R.id.rbtUTP).setVisibility(View.VISIBLE);
            findViewById(R.id.rbtVirtual).setVisibility(View.VISIBLE);
            findViewById(R.id.rbtProfesor).setVisibility(View.VISIBLE);
        }

        btnlink=findViewById((R.id.btnValidar));
                btnlink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Perfil=findViewById(R.id.Perfiles);
                        if(Perfil.getCheckedRadioButtonId() == R.id.rbtEstudiante){

                            Intent i =new Intent(getApplicationContext(),historial.class);
                        }
                        else if(Perfil.getCheckedRadioButtonId() == R.id.rbtProfesor){

                            Intent i =new Intent(getApplicationContext(),historial.class);
                        }
                        else if(Perfil.getCheckedRadioButtonId() == R.id.rbtUTP){
                            Uri uri = Uri.parse( "http://utp.ac.pa");
                            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            startActivity(intent);
                        }
                        else if(Perfil.getCheckedRadioButtonId() == R.id.rbtVirtual){
                            Uri uri = Uri.parse("https://ecampus.utp.ac.pa/moodle/");
                            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            startActivity(intent);
                        }


                }
    });

    }


}
