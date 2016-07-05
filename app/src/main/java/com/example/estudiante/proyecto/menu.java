package com.example.estudiante.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //setContentView(R.layout.activity_pantalla_inicio);
        setContentView(R.layout.activity_menu);
    }
    public void jugar(View v){
        Intent i = new Intent(this,pantallauno.class);
        startActivity(i);

    }
    public void instruccion(View v){
        Intent i = new Intent(this,instruccion.class);
        startActivity(i);

    }
}
