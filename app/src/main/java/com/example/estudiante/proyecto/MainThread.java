package com.example.estudiante.proyecto;

import android.graphics.Canvas;
import android.provider.Settings;
import android.view.SurfaceHolder;

/**
 * Created by david on 02/07/16.
 */
public class MainThread extends Thread {
    private int FPS=30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }
    @Override
    public void run() {

        long startTime;
        long timeMills;
        long waitTime;
        long totalTime = 0;
        long frameCont = 0;
        long tartetTime = 1000 / FPS;

        while (running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            } catch (Exception e) {

            }
            finally {
                if(canvas!=null){
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            timeMills = (System.nanoTime() - startTime) / 1000000;
            waitTime = tartetTime - timeMills;

            try {
                this.sleep(waitTime);

            } catch (Exception e) {
            }

            totalTime+=System.nanoTime()-startTime;
            frameCont++;
            if(frameCont==FPS){
                averageFPS=1000/((totalTime/frameCont)/1000000);
                frameCont=0;
                totalTime=0;
                System.out.println(averageFPS);
            }
        }
    }
    public void setRunning(boolean b){
        running=b;
    }
}
