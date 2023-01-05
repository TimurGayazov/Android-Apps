package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button player1;
    Button player2;
    Button stat;
    Button reset;
    TextView game_start;
    DrawThread drawThread;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference player11 = database.getReference("player1");
    DatabaseReference player22 = database.getReference("player2");
    DatabaseReference player11_move = database.getReference("player1_move");
    DatabaseReference player22_move = database.getReference("player2_move");






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        stat = findViewById(R.id.stat);
        reset = findViewById(R.id.reset);




        player11.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
//                Toast.makeText(getApplicationContext(),dataSnapshot.getValue()+ " " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();

                int chislo = Integer.parseInt(dataSnapshot.getValue().toString());

                if (chislo == 1){
                    player1.setText("Игрок 1 авторизован");
                    player1.setVisibility(View.INVISIBLE);


                }
                else if (chislo == 0){
                    player1.setText("Игрок 1 не авторизован");
                    player1.setVisibility(View.VISIBLE);
                }
                else {
                    player1.setText("Ошибка!");
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

        player22.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
//                Toast.makeText(getApplicationContext(),dataSnapshot.getValue()+ " " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();

                int chislo = Integer.parseInt(dataSnapshot.getValue().toString());

                if (chislo == 1){
                    player2.setText("Игрок 2 авторизован");
                    player2.setVisibility(View.INVISIBLE);


                }
                else if (chislo == 0){
                    player2.setText("Игрок 2 не авторизован");
                    player2.setVisibility(View.VISIBLE);
                }
                else {
                    player2.setText("Ошибка!");
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







        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    player11.removeValue();
                    player11.push().setValue("1");
                    Intent i = new Intent(MainActivity.this, playing_field.class);
                    i.putExtra("qwe","1");
                    startActivity(i);


                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }



            }
        });



        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    player22.removeValue();
                    player22.push().setValue("1");

                    Intent i = new Intent(MainActivity.this, playing_field.class);
                    i.putExtra("qwe","2");
                    startActivity(i);

                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }



            }
        });

        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent st = new Intent(MainActivity.this, Statistics.class);

                    startActivity(st);











                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }



            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    player11.removeValue();
                    player22.removeValue();
                    player11.push().setValue("0");
                    player22.push().setValue("0");
                    player11_move.removeValue();
                    player22_move.removeValue();


                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }



            }
        });












    }
}