package com.example.estudiante.proyecto;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by david on 02/07/16.
 */
public class BackGround {
    private Bitmap image;
    private int x,y, dx;

    public BackGround(Bitmap res){
        image=res;
    }


    public void update(){

        x+=dx;
        if(x<0){
            x=0;
        }
    }

    public void draw(Canvas canvas){

        canvas.drawBitmap(image,x,y,null);
        if(x<-GamePanel.WIDTH){
            canvas.drawBitmap(image,x,y,null);
        }
    }
    public void setVector(int x){
        this.dx=dx;
    }
}
