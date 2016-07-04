package com.example.estudiante.proyecto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by david on 02/07/16.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    public static final int WIDTH=1980;
    public static final int HEIGHT=177;
    private BackGround bg;
    private MainThread thread;
    public GamePanel(Context context){

        super(context);
        //interceptar eventos
        getHolder().addCallback(this);

        thread=new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format,int height,int width){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry=true;
        while(retry){
            try {
                thread.setRunning(false);
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
                retry=false;
            }
        }

    }

    @Override
    public  void surfaceCreated(SurfaceHolder holder){

        bg = new BackGround(BitmapFactory.decodeResource(getResources(), R.drawable.ciudad));
        bg.setVector(-5);

        //se puede iniciar el game loop
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
    }

    public void update(){
        bg.update();
    }


    public void draw(Canvas canvas){
        final float scaleFactorx= getWidth()/WIDTH;
        final float scaleFactory= getHeight()/HEIGHT;
        if(canvas!=null) {
            final int guardarestado=canvas.save();
            bg.draw(canvas);
            canvas.restoreToCount(guardarestado);
        }
    }

}
