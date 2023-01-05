package com.example.tic_tac_toe;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DrawThread extends  Thread{
    private boolean runFlag = false;
    private SurfaceHolder surfaceHolder;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference player11_move = database.getReference("player1_move");
    DatabaseReference player22_move = database.getReference("player2_move");
    ArrayList<Integer> data = new ArrayList<Integer>();
    ArrayList<Integer> data1 = new ArrayList<Integer>();


    public DrawThread(SurfaceHolder surfaceHolder, Resources resources){
        this.surfaceHolder = surfaceHolder;

    }

    public void setRunning(boolean runFlag){

        this.runFlag = runFlag;
    }





    @Override
    public void run(){

        player11_move.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
//                Toast.makeText(getApplicationContext(),dataSnapshot.getValue()+ " " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();

                int chislo = Integer.parseInt(dataSnapshot.getValue().toString());

                data.add(chislo);




            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        player22_move.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
//                Toast.makeText(getApplicationContext(),dataSnapshot.getValue()+ " " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();

                int chislo = Integer.parseInt(dataSnapshot.getValue().toString());

                data1.add(chislo);




            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        while (runFlag){
            Canvas canvas;
            Paint p = new Paint();
            p.setColor(Color.BLACK);
            canvas = null;

            try {
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder){
                    float x1_1 = canvas.getWidth() * (1.0f/3.0f);
                    float x2_1 = canvas.getWidth() * (1.0f/3.0f);
                    float y1_1 = 0;
                    float y2_1 = canvas.getHeight();

                    float x1_2 = canvas.getWidth() * (2.0f/3.0f);
                    float x2_2 = canvas.getWidth() * (2.0f/3.0f);
                    float y1_2 = 0;
                    float y2_2 = canvas.getHeight();

                    float x1_3 = 0;
                    float x2_3 = canvas.getWidth();
                    float y1_3 = canvas.getHeight() * (1.0f/3.0f);
                    float y2_3 = canvas.getHeight() * (1.0f/3.0f);

                    float x1_4 = 0;
                    float x2_4 = canvas.getWidth();
                    float y1_4 = canvas.getHeight() * (2.0f / 3.0f);
                    float y2_4 = canvas.getHeight() * (2.0f / 3.0f);
                    // Отрисовка игрового поля
                    canvas.drawColor(Color.WHITE);

                    canvas.drawLine(x1_1,y1_1,x2_1,y2_1, p);
                    canvas.drawLine(x1_2,y1_2,x2_2,y2_2, p);

                    canvas.drawLine(x1_3,y1_3,x2_3,y2_3, p);
                    canvas.drawLine(x1_4,y1_4,x2_4,y2_4, p);
//                    int x111 = data.get(0);
//                    canvas.drawLine(x111, x111,canvas.getWidth()/2,canvas.getHeight()/2,p);
                    p.setTextSize(100);
                    if (data.size()>0){
                        p.setColor(Color.BLACK);
                        for (int i =0; i < data.size(); i++){
                            if (data.get(i) == 0){
                                canvas.drawText("X", canvas.getWidth() * (1.0f/6.0f), canvas.getHeight() * (1.0f / 6.0f), p);
                            }
                            else if (data.get(i)==1){
                                canvas.drawText("X", canvas.getWidth() * (1.0f/2.0f), canvas.getHeight() * (1.0f / 6.0f), p);
                            }
                            else if (data.get(i)==2){
                                canvas.drawText("X", canvas.getWidth() * (5.0f/6.0f), canvas.getHeight() * (1.0f / 6.0f), p);
                            }
                            else if (data.get(i)==3){
                                canvas.drawText("X", canvas.getWidth() * (1.0f/6.0f), canvas.getHeight() * (1.0f / 2.0f), p);
                            }
                            else if (data.get(i)==4){
                                canvas.drawText("X", canvas.getWidth() * (1.0f/2.0f), canvas.getHeight() * (1.0f / 2.0f), p);
                            }
                            else if (data.get(i)==5){
                                canvas.drawText("X", canvas.getWidth() * (5.0f/6.0f), canvas.getHeight() * (1.0f / 2.0f), p);
                            }
                            else if (data.get(i)==6){
                                canvas.drawText("X", canvas.getWidth() * (1.0f/6.0f), canvas.getHeight() * (5.0f / 6.0f), p);
                            }
                            else if (data.get(i)==7){
                                canvas.drawText("X", canvas.getWidth() * (1.0f/2.0f), canvas.getHeight() * (5.0f / 6.0f), p);
                            }
                            else if (data.get(i)==8){
                                canvas.drawText("X", canvas.getWidth() * (5.0f/6.0f), canvas.getHeight() * (5.0f / 6.0f), p);
                            }
//                            else if (data.){
//                                canvas.drawLine(0,canvas.getHeight() * (1.0f / 6.0f), canvas.getWidth() * 1,canvas.getHeight() * (1.0f / 6.0f),p);
//                            }

                        }

                    }

                    for (int j = 0; j < data.size();j++){
                        p.setColor(Color.GREEN);
                        p.setStrokeWidth(25);
                        if (data.contains(0) && data.contains(1) && data.contains(2)){

                            canvas.drawLine(0,canvas.getHeight() * (1.0f / 6.0f), canvas.getWidth() * 1,canvas.getHeight() * (1.0f / 6.0f),p);
                        }
                        else if (data.contains(3) && data.contains(4) && data.contains(5)){
                            canvas.drawLine(0,canvas.getHeight() * (1.0f / 2.0f), canvas.getWidth() * 1,canvas.getHeight() * (1.0f / 2.0f),p);

                        }
                        else if (data.contains(6) && data.contains(7) && data.contains(8)){
                            canvas.drawLine(0,canvas.getHeight() * (5.0f / 6.0f), canvas.getWidth() * 1,canvas.getHeight() * (5.0f / 6.0f),p);

                        }
                        else if (data.contains(0) && data.contains(3) && data.contains(6)){
                            canvas.drawLine(canvas.getWidth() * (1.0f/6.0f),0, canvas.getWidth() * (1.0f/6.0f),canvas.getHeight()*1,p);

                        }
                        else if (data.contains(1) && data.contains(4) && data.contains(7)){
                            canvas.drawLine(canvas.getWidth() * (1.0f/2.0f),0, canvas.getWidth() * (1.0f/2.0f),canvas.getHeight()*1,p);

                        }
                        else if (data.contains(2) && data.contains(5) && data.contains(8)){
                            canvas.drawLine(canvas.getWidth() * (5.0f/6.0f),0, canvas.getWidth() * (5.0f/6.0f),canvas.getHeight()*1,p);

                        }
                        else if (data.contains(0) && data.contains(4) && data.contains(8)){
                            canvas.drawLine(0,0, canvas.getWidth()*1,canvas.getHeight()*1,p);

                        }
                        else if (data.contains(2) && data.contains(4) && data.contains(6)){
                            canvas.drawLine(canvas.getWidth()*1,0, 0,canvas.getHeight()*1,p);

                        }
                    }




                    if (data1.size()>0){
                        p.setColor(Color.BLACK);

                        for (int i =0; i< data1.size(); i++){
                            if (data1.get(i) == 0){
                                canvas.drawText("O", canvas.getWidth() * (1.0f/6.0f), canvas.getHeight() * (1.0f / 6.0f), p);
                            }
                            else if (data1.get(i)==1){
                                canvas.drawText("O", canvas.getWidth() * (1.0f/2.0f), canvas.getHeight() * (1.0f / 6.0f), p);
                            }
                            else if (data1.get(i)==2){
                                canvas.drawText("O", canvas.getWidth() * (5.0f/6.0f), canvas.getHeight() * (1.0f / 6.0f), p);
                            }
                            else if (data1.get(i)==3){
                                canvas.drawText("O", canvas.getWidth() * (1.0f/6.0f), canvas.getHeight() * (1.0f / 2.0f), p);
                            }
                            else if (data1.get(i)==4){
                                canvas.drawText("O", canvas.getWidth() * (1.0f/2.0f), canvas.getHeight() * (1.0f / 2.0f), p);
                            }
                            else if (data1.get(i)==5){
                                canvas.drawText("O", canvas.getWidth() * (5.0f/6.0f), canvas.getHeight() * (1.0f / 2.0f), p);
                            }
                            else if (data1.get(i)==6){
                                canvas.drawText("O", canvas.getWidth() * (1.0f/6.0f), canvas.getHeight() * (5.0f / 6.0f), p);
                            }
                            else if (data1.get(i)==7){
                                canvas.drawText("O", canvas.getWidth() * (1.0f/2.0f), canvas.getHeight() * (5.0f / 6.0f), p);
                            }
                            else if (data1.get(i)==8){
                                canvas.drawText("O", canvas.getWidth() * (5.0f/6.0f), canvas.getHeight() * (5.0f / 6.0f), p);
                            }

                        }

                    }

                    for (int j = 0; j < data1.size();j++){
                        p.setColor(Color.GREEN);
                        p.setStrokeWidth(25);
                        if (data1.contains(0) && data1.contains(1) && data1.contains(2)){

                            canvas.drawLine(0,canvas.getHeight() * (1.0f / 6.0f), canvas.getWidth() * 1,canvas.getHeight() * (1.0f / 6.0f),p);
                        }
                        else if (data1.contains(3) && data1.contains(4) && data1.contains(5)){
                            canvas.drawLine(0,canvas.getHeight() * (1.0f / 2.0f), canvas.getWidth() * 1,canvas.getHeight() * (1.0f / 2.0f),p);

                        }
                        else if (data1.contains(6) && data1.contains(7) && data1.contains(8)){
                            canvas.drawLine(0,canvas.getHeight() * (5.0f / 6.0f), canvas.getWidth() * 1,canvas.getHeight() * (5.0f / 6.0f),p);

                        }
                        else if (data1.contains(0) && data1.contains(3) && data1.contains(6)){
                            canvas.drawLine(canvas.getWidth() * (1.0f/6.0f),0, canvas.getWidth() * (1.0f/6.0f),canvas.getHeight()*1,p);

                        }
                        else if (data1.contains(1) && data1.contains(4) && data1.contains(7)){
                            canvas.drawLine(canvas.getWidth() * (1.0f/2.0f),0, canvas.getWidth() * (1.0f/2.0f),canvas.getHeight()*1,p);

                        }
                        else if (data1.contains(2) && data1.contains(5) && data1.contains(8)){
                            canvas.drawLine(canvas.getWidth() * (5.0f/6.0f),0, canvas.getWidth() * (5.0f/6.0f),canvas.getHeight()*1,p);

                        }
                        else if (data1.contains(0) && data1.contains(4) && data1.contains(8)){
                            canvas.drawLine(0,0, canvas.getWidth()*1,canvas.getHeight()*1,p);

                        }
                        else if (data1.contains(2) && data1.contains(4) && data1.contains(6)){
                            canvas.drawLine(canvas.getWidth()*1,0, 0,canvas.getHeight()*1,p);

                        }
                    }






                }
            }
            finally {
                if (canvas!=null){
                    surfaceHolder.unlockCanvasAndPost(canvas);

                }
            }


        }

    }



}
