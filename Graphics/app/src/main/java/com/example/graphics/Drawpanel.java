package com.example.graphics;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Drawpanel extends View {
    Paint paint = new Paint();
    private float i1 = 0;
    private float i2 = 0;



    public Drawpanel(Context context) {
        super(context);
    }

    public Drawpanel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        paint.setColor();
        paint.setAntiAlias(true);
        canvas.drawLine(getWidth()/2,0,getWidth()/2,getHeight(),paint); // ось y
        canvas.drawLine(0,getHeight()/2,getWidth(),getHeight()/2,paint); // ось x

        canvas.drawLine(getWidth()/2,0,getWidth()/2-50,50,paint);// стрелочки оси y
        canvas.drawLine(getWidth()/2,0,getWidth()/2+50,50,paint);// стрелочки оси y

        canvas.drawLine(getWidth(),getHeight()/2,getWidth()-50,getHeight()/2+50,paint); // стрелочки оси x
        canvas.drawLine(getWidth(),getHeight()/2,getWidth()-50,getHeight()/2-50,paint); // стрелочки оси x

        // Точки на графике
        canvas.drawLine(getWidth()/2+10,getHeight()/2-25,getWidth()/2-10,getHeight()/2-25,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-50,getWidth()/2-10,getHeight()/2-50,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-75,getWidth()/2-10,getHeight()/2-75,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-100,getWidth()/2-10,getHeight()/2-100,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-125,getWidth()/2-10,getHeight()/2-125,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-150,getWidth()/2-10,getHeight()/2-150,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-175,getWidth()/2-10,getHeight()/2-175,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-200,getWidth()/2-10,getHeight()/2-200,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-225,getWidth()/2-10,getHeight()/2-225,paint);
        canvas.drawLine(getWidth()/2+10,getHeight()/2-250,getWidth()/2-10,getHeight()/2-250,paint);

        canvas.drawLine(getWidth()/2+25,getHeight()/2-10,getWidth()/2+25,getHeight()/2+10,paint);
        canvas.drawLine(getWidth()/2+50,getHeight()/2-10,getWidth()/2+50,getHeight()/2+10,paint);
        canvas.drawLine(getWidth()/2+75,getHeight()/2-10,getWidth()/2+75,getHeight()/2+10,paint);
        canvas.drawLine(getWidth()/2+100,getHeight()/2-10,getWidth()/2+100,getHeight()/2+10,paint);
        canvas.drawLine(getWidth()/2+125,getHeight()/2-10,getWidth()/2+125,getHeight()/2+10,paint);

        canvas.drawLine(getWidth()/2-25,getHeight()/2-10,getWidth()/2-25,getHeight()/2+10,paint);
        canvas.drawLine(getWidth()/2-50,getHeight()/2-10,getWidth()/2-50,getHeight()/2+10,paint);
        canvas.drawLine(getWidth()/2-75,getHeight()/2-10,getWidth()/2-75,getHeight()/2+10,paint);
        canvas.drawLine(getWidth()/2-100,getHeight()/2-10,getWidth()/2-100,getHeight()/2+10,paint);
        canvas.drawLine(getWidth()/2-125,getHeight()/2-10,getWidth()/2-125,getHeight()/2+10,paint);


        //график правая часть + - + -

//        float des = 1/10;
//        for(float i = 10; i < 101; i++) {
//            float startx = getWidth()/2 + ((i/10)-1) *50;
//            float starty = getHeight()/2 - (2*(((i/10)-1)*((i/10)-1)))*50 - 50;
//            float finishx = getWidth()/2 + (i/10)*50;
//            float finishy = getHeight()/2 - (2*((i/10)*(i/10)))*50-50;
//
//            canvas.drawLine(startx,starty,finishx,finishy,paint);
//
//        }
        /////////////////////////
//        for(float i = 10; i < 31; i++) {
//            float x1 = ((i/10)-1);
//            float x2 = i/10;
//            float startx = getWidth()/2 + x1*25;
//            float starty = getHeight()/2 - (2 * (x1 * x1)) * 25-25;
//            float finishx = getWidth()/2 + x2*25 ;
//            float finishy = getHeight()/2 - (2 * (x2 * x2)) * 25-25;
//
//            canvas.drawLine(startx,starty,finishx,finishy,paint);
//
//        }
//
//        for(float i = 10; i < 31; i++) {
//            float x1 = ((i/10)-1);
//            float x2 = i/10;
//            float startx = getWidth()/2 - x1*25;
//            float starty = getHeight()/2 - (2 * (x1 * x1)) * 25 - 25;
//            float finishx = getWidth()/2 - x2*25 ;
//            float finishy = getHeight()/2 - (2 * (x2 * x2)) * 25 - 25;
//
//            canvas.drawLine(startx,starty,finishx,finishy,paint);
//
//        }
        /////////////////////////////////////



        // График левая часть - - - -

//        for(float i = 10; i < 31; i++) {
//            float startx = getWidth()/2 - ((i/10)-1) *25;
////            float starty = getHeight()/2 - (i-1) * 50 - 50;
//            float starty = getHeight()/2 - (2*(((i/10)-1)*((i/10)-1)))*25 - 25;
//            float finishx = getWidth()/2 - (i/10)*25;
//            float finishy = getHeight()/2 - (2*((i/10)*(i/10)))*25 - 25;
//
//            canvas.drawLine(startx,starty,finishx,finishy,paint);
//
//        }

//        for(float i = 1; i < 3; i++) {
//            float startx = getWidth()/2 - (i-1) *50;
//            float starty = getHeight()/2 - (2*((i-1)*(i-1)))*50 - 50;
//            float finishx = getWidth()/2 - i*50;
//            float finishy = getHeight()/2 - (2*(i*i))*50 - 50;
//
//            canvas.drawLine(startx,starty,finishx,finishy,paint);
//
//        }
//        float i = 1;
//        float des = 1/10;
//        while (i < 4){
//            float startx = getWidth()/2 - (i-1) *50;
//            float starty = getHeight()/2 - (2*((i-1)*(i-1)))*50 - 50;
//            float finishx = getWidth()/2 - i*50;
//            float finishy = getHeight()/2 - (2*(i*i))*50 - 50;
//
//            canvas.drawLine(startx,starty,finishx,finishy,paint);
//            i = i+(1);
//        }

    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
//        paint.setColor();
        paint.setAntiAlias(true);


        for(float i = 9; i < i2; i++) {
            float x1 = ((i/10)-1);
            float x2 = i/10;
            float startx = getWidth()/2 + x1*25;
            float starty = getHeight()/2 - (2 * (x1 * x1)) * 25-25;
            float finishx = getWidth()/2 + x2*25 ;
            float finishy = getHeight()/2 - (2 * (x2 * x2)) * 25-25;

            canvas.drawLine(startx,starty,finishx,finishy,paint);

        }

        float i = 10;
        for(i=9; i < i1; i++) {
            float x1 = ((i/10)-1);
            float x2 = i/10;
            float startx = getWidth()/2 - x1*25;
            float starty = getHeight()/2 - (2 * (x1 * x1)) * 25 - 25;
            float finishx = getWidth()/2 - x2*25 ;
            float finishy = getHeight()/2 - (2 * (x2 * x2)) * 25 - 25;

            canvas.drawLine(startx,starty,finishx,finishy,paint);

        }
    }

    public void setXX(float xx1, float xx2) {
      this.i1  = xx1;
      this.i2 = xx2;
      invalidate();
    }
}
