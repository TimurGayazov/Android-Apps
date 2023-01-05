package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class playing_field extends AppCompatActivity {
    Button btn_sent_pos_to_db;
    Button btn_back;
    EditText input_pos;
    DrawThread drawThread;
    DrawView drawView;
    TextView x_o;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference player11 = database.getReference("player1");
    DatabaseReference player22 = database.getReference("player2");
    DatabaseReference player11_move = database.getReference("player1_move");
    DatabaseReference player22_move = database.getReference("player2_move");

    private NamesBase DBConnector;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_field);
        btn_sent_pos_to_db = findViewById(R.id.btn_sent_pos_to_db);
        drawView = findViewById(R.id.game_pole);
        btn_back = findViewById(R.id.btn_back);
        input_pos = findViewById(R.id.input_pos);
        x_o = findViewById(R.id.x_o);
        DBConnector = new NamesBase(this);



        Intent i = getIntent();
        String player = i.getStringExtra("qwe");
        ArrayList<Integer> players_logs = new ArrayList<Integer>();
        ArrayList<Integer> player1_logs = new ArrayList<Integer>();
        ArrayList<Integer> player2_logs = new ArrayList<Integer>();
//        Toast.makeText(getApplicationContext(),player, Toast.LENGTH_LONG).show();
        int proverka = Integer.parseInt(player.toString());
        if (proverka==1){
            x_o.setText("Вы играете за X");
        }
        else if (proverka==2){
            x_o.setText("Вы играете за O");
        }

        player11_move.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
//                Toast.makeText(getApplicationContext(),dataSnapshot.getValue()+ " " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();

                int chislo = Integer.parseInt(dataSnapshot.getValue().toString());


                player1_logs.add(chislo);
                players_logs.add(chislo);
                if (player1_logs.contains(0) && player1_logs.contains(1) && player1_logs.contains(2)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №1!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                    String name = "Игрок1";
                    DBConnector.add(name);
                }
                else if (player1_logs.contains(3) && player1_logs.contains(4) && player1_logs.contains(5)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №1!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player1_logs.contains(6) && player1_logs.contains(7) && player1_logs.contains(8)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №1!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player1_logs.contains(0) && player1_logs.contains(3) && player1_logs.contains(6)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №1!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player1_logs.contains(1) && player1_logs.contains(4) && player1_logs.contains(7)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №1!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player1_logs.contains(2) && player1_logs.contains(5) && player1_logs.contains(8)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №1!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player1_logs.contains(0) && player1_logs.contains(4) && player1_logs.contains(8)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №1!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player1_logs.contains(2) && player1_logs.contains(4) && player1_logs.contains(6)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №1!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
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

        player22_move.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
//                Toast.makeText(getApplicationContext(),dataSnapshot.getValue()+ " " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();

                int chislo = Integer.parseInt(dataSnapshot.getValue().toString());

                player2_logs.add(chislo);
                players_logs.add(chislo);
                if (player2_logs.contains(0) && player2_logs.contains(1) && player2_logs.contains(2)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №2!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player2_logs.contains(3) && player2_logs.contains(4) && player2_logs.contains(5)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №2!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player2_logs.contains(6) && player2_logs.contains(7) && player2_logs.contains(8)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №2!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player2_logs.contains(0) && player2_logs.contains(3) && player2_logs.contains(6)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №2!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player2_logs.contains(1) && player2_logs.contains(4) && player2_logs.contains(7)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №2!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player2_logs.contains(2) && player2_logs.contains(5) && player2_logs.contains(8)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №2!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player2_logs.contains(0) && player2_logs.contains(4) && player2_logs.contains(8)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №2!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
                }
                else if (player2_logs.contains(2) && player2_logs.contains(4) && player2_logs.contains(6)){
                    Toast.makeText(getApplicationContext(),"Победу одержал Игрок №2!", Toast.LENGTH_LONG).show();
                    input_pos.setVisibility(View.INVISIBLE);
                    btn_sent_pos_to_db.setVisibility(View.INVISIBLE);
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




        btn_sent_pos_to_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

//                    int proverka = Integer.parseInt(player.toString());

                    if (proverka == 1){
                        String msg = input_pos.getText().toString();
//                        x_o.setText("Вы играете за X");
                        int input_number = Integer.parseInt(msg.toString());

                        if (msg.equals("")){
                            Toast.makeText(getApplicationContext(),"Поле не должно быть пустым!", Toast.LENGTH_LONG).show();
//                            return;
                        }
                        else if (input_number > 8 || input_number < 0){
                            Toast.makeText(getApplicationContext(),"Недопустимое значение! Введите от 0 до 8.", Toast.LENGTH_LONG).show();
                        }
                        else if (players_logs.size()>0){
                            int k = 0;
                            for (int j =0; j <players_logs.size(); j++){
                                if (input_number == players_logs.get(j)){
                                    k = 1;
                                    break;
                                }
                                else if (input_number!= players_logs.get(j)){
                                    k = 0;
                                }
                            }
                            if (k == 1){
                                Toast.makeText(getApplicationContext(),"Данная позиция занята! Введите другое значение!", Toast.LENGTH_LONG).show();
                            }
                            else if (k == 0){
                                if (player1_logs.size() == player2_logs.size()){
                                    player11_move.removeValue();
                                    player11_move.push().setValue(msg);
                                    input_pos.setText("");
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Сейчас не ваш ход!", Toast.LENGTH_LONG).show();
                                }

                            }




                        }
                        else if (players_logs.size() == 0){
                            player11_move.removeValue();
                            player11_move.push().setValue(msg);
                            input_pos.setText("");
                        }
                    }
                    else if (proverka == 2){
                        String msg = input_pos.getText().toString();
//                        x_o.setText("Вы играете за X");
                        int input_number = Integer.parseInt(msg.toString());

                        if (msg.equals("")){
                            Toast.makeText(getApplicationContext(),"Поле не должно быть пустым!", Toast.LENGTH_LONG).show();
//                            return;
                        }
                        else if (input_number > 8 || input_number < 0){
                            Toast.makeText(getApplicationContext(),"Недопустимое значение! Введите от 0 до 8.", Toast.LENGTH_LONG).show();
                        }
                        else if (players_logs.size()>0){
                            int k = 0;
                            for (int j =0; j <players_logs.size(); j++){
                                if (input_number == players_logs.get(j)){
                                    k = 1;
                                    break;
                                }
                                else if (input_number!= players_logs.get(j)){
                                    k = 0;
                                }
                            }
                            if (k == 1){
                                Toast.makeText(getApplicationContext(),"Данная позиция занята! Введите другое значение!", Toast.LENGTH_LONG).show();
                            }
                            else if (k == 0){

                                if (player1_logs.size() != player2_logs.size()){
                                    player22_move.removeValue();
                                    player22_move.push().setValue(msg);
                                    input_pos.setText("");
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Сейчас не ваш ход!", Toast.LENGTH_LONG).show();
                                }
                            }




                        }
                        else if (players_logs.size() == 0){
                            player22_move.removeValue();
                            player22_move.push().setValue(msg);
                            input_pos.setText("");
                        }
                    }
                    else {
                        player11.removeValue();
                        player11.push().setValue("0");
                        player22.removeValue();
                        player22.push().setValue("0");

//                        finish();
                    }







                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }



            }
        });






        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (proverka==1){
                        player11.removeValue();
                        player11.push().setValue("0");
                        player11_move.removeValue();


                    }
                    else if (proverka==2){
                        player22.removeValue();
                        player22.push().setValue("0");
                        player22_move.removeValue();

                    }


//                    drawThread.setRunning(false);
//                    drawThread.join();
//                    drawView.setVisibility(View.INVISIBLE);

//                   finish();

//                    DrawThread.sleep(4000);

//                    drawView.drawThread.join();
//                    drawThread.join();
//                    drawThread.setRunning(true);
//                    drawThread.start();

//                    playing_field.super.recreate();
//                    recreate();







                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }



            }
        });
    }
//    public void reCreate(Bundle savedInstanceState){
//        super.recreate();
//        setContentView(R.layout.activity_playing_field);
//        finish();
//
//    }
}