package com.example.thermo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.TypedValue;
import android.view.View;

public class Thermo  extends View {
    public float temp;
    public String unit;
    public String couleur;

    public Thermo(Context ctx,float temp) {
        super(ctx);
        this.temp = temp;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float width= getWidth();
        float heigth= getHeight();
       /* float xs = (float)width/2.0f;
        float ys = (float)heigth-50.0f;
        float xf = xs;
        float yf= ys-(float) temp*10.0f;
*/
        //ligne positive
        float xs = (float)width/2.0f;
        float ys = (float)heigth-310.0f;
        float xf = xs;
        float yf= ys - temp *  12.0f;


        Paint pinceau = new Paint(1);
        pinceau.setStrokeWidth(5f);
        canvas.drawLine(xs,ys,xf,yf,pinceau);
      /*  canvas.drawLine(xs,ys,xf,yf,pinceau);*/
        canvas.drawCircle(xs,ys,50.0f,pinceau);



        pinceau.setTextSize(60);
        int startX = getWidth() / 3;
        int endX = startX;
        float y = getHeight() -1500; // position verticale initiale de la ligne de température en Celsius
        float y2 = getHeight()-1500; // position verticale initiale de la ligne de température en Fahrenheit

        for (int i = 100; i >= -20; i -= 10) {
            canvas.drawText(Integer.toString(i), startX - 100, y, pinceau);
            canvas.drawLine(startX, y, endX, y, pinceau);
            canvas.drawText(Float.toString(i * 9 / 5 + 32), startX + 500, y2, pinceau); // affichage de la température en Fahrenheit
            canvas.drawLine(startX + 200, y2, endX + 200, y2, pinceau); // décalage de la ligne de température en Fahrenheit à droite
            y += 120; // ajustement de la position verticale de la ligne de température en Celsius
            y2 += 120; // ajustement de la position verticale de la ligne de température en Fahrenheit
        }

        canvas.drawText("C", endX + 150, y - 90, pinceau); // affichage de l'unité Celsius
        canvas.drawText("F", endX + 300, y - 90, pinceau); // affichage de l'unité Fahrenheit
        float f = (float)temp * 1.8f + 32f;
        canvas.drawText("Celcius : "+temp, endX - 250, y - 2000, pinceau); // affichage des Celsius
        canvas.drawText("Fahrenheit: "+f, endX + 400, y - 2000, pinceau); // affichage des Fahrenheits

    }
    public void setTemp(float temp){
        this.temp=(float) temp;
        invalidate();
    }
}


