package com.example.tic_tac_toe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class DrawView extends SurfaceView implements SurfaceHolder.Callback {
    DrawThread drawThread;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference player11 = database.getReference("player1");
    DatabaseReference player22 = database.getReference("player2");


    public DrawView(Context context){
        super(context);
        getHolder().addCallback(this);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs){
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

        player11.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
//                Toast.makeText(getApplicationContext(),dataSnapshot.getValue()+ " " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();

                int chislo = Integer.parseInt(dataSnapshot.getValue().toString());

                if (chislo == 1){
                    drawThread = new DrawThread(surfaceHolder, getResources());
                    drawThread.setRunning(true);
                    drawThread.start();

                }
                else if (chislo==0){
                    drawThread = new DrawThread(surfaceHolder, getResources());
                    drawThread.setRunning(false);

                    drawThread.start();


                }






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
//        drawThread = new DrawThread(surfaceHolder, getResources());
//        drawThread.setRunning(true);
//        drawThread.start();


    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

        drawThread = new DrawThread(surfaceHolder, getResources());
        boolean retry = true;



        drawThread.setRunning(false);
        while (retry){
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e){

            }
        }



    }

}
