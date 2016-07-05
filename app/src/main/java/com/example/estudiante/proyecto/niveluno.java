package com.example.estudiante.proyecto;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;

public class niveluno extends Activity {
    private ImageView ciudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new GamePanel(this));

        //ciudad= (ImageView) findViewById(R.id.img);
        //animacion
        //ciudad.post(new Runnable() {
            //@Override
          //  public void run() {
            //    ((AnimationDrawable)ciudad.getBackground()).start();
            //}
        //});
    }
}
