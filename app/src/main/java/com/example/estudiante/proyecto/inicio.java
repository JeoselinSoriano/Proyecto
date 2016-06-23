package com.example.estudiante.proyecto;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class inicio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inicio);

       // new Handler().postDelayed(new Runnable(){

        //    public void run(){

          //  }
//        },4000);


    }



    public void cargar(View v){

        Intent i = new Intent(inicio.this, pantallaInicio.class);
        startActivity(i);
    }


}
