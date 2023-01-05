package com.example.lab1_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    EditText op1;
    EditText op2;
    Button sumBtn;
    Button subBtn;
    Button multiBtn;
    Button divisionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        sumBtn = findViewById(R.id.sumBtn);
        subBtn = findViewById(R.id.subBtn);
        multiBtn = findViewById(R.id.multiBtn);
        divisionBtn = findViewById(R.id.divisionBtn);




        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double x = Double.parseDouble(op1.getText().toString());
                    double y = Double.parseDouble(op2.getText().toString());
                    Intent i =  new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("result", x-y);
                    startActivity(i);

                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ошибка ввода!", Toast.LENGTH_LONG).show();

                    return;
                }
//                Intent i =  new Intent(MainActivity.this, ResultActivity.class);
//                i.putExtra("result", x+y);
//                startActivity(i);


            }
        });
        sumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double x = Double.parseDouble(op1.getText().toString());
                    double y = Double.parseDouble(op2.getText().toString());
                    Intent i =  new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("result", x+y);
                    startActivity(i);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ошибка ввода!", Toast.LENGTH_LONG).show();
//                    double x = Double.parseDouble(op1.getText().toString());
//                    double y = Double.parseDouble(op2.getText().toString());
//                    Intent i =  new Intent(MainActivity.this, ResultActivity.class);
//                    i.putExtra(x + y + " = ", x+y);
//                    startActivity(i);

                    return;
                }
//


            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double x = Double.parseDouble(op1.getText().toString());
                    double y = Double.parseDouble(op2.getText().toString());
                    Intent i =  new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("result", x*y);
                    startActivity(i);

                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ошибка ввода!", Toast.LENGTH_LONG).show();

                    return;
                }
//                Intent i =  new Intent(MainActivity.this, ResultActivity.class);
//                i.putExtra("result", x+y);
//                startActivity(i);


            }
        });

        divisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double x = Double.parseDouble(op1.getText().toString());
                    double y = Double.parseDouble(op2.getText().toString());
                    if (y == 0){
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.del0), Toast.LENGTH_LONG).show();
                    }
                    else{
                        Intent i =  new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("result", x/y);
                        startActivity(i);
                    }

                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ошибка ввода!", Toast.LENGTH_LONG).show();

                    return;
                }
//                Intent i =  new Intent(MainActivity.this, ResultActivity.class);
//                i.putExtra("result", x+y);
//                startActivity(i);


            }
        });


    }


}