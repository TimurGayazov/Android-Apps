package com.example.graphics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button drawGraphics;
    EditText inputx1;
    EditText inputx2;
    Drawpanel draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawGraphics = findViewById(R.id.drawGraphics);
        inputx1 = findViewById(R.id.inputx1);
        inputx2 = findViewById(R.id.inputx2);
        draw = findViewById(R.id.draw);

        drawGraphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

//                    String xx1 = inputx1.getText().toString();
//                    int xx1_int = Integer.parseInt(xx1);


                    float xx1 = Float.parseFloat(inputx1.getText().toString());
                    float xx2 = Float.parseFloat(inputx2.getText().toString());
                    inputx1.setText("");
                    inputx2.setText("");

                    Toast.makeText(getApplicationContext(),"График успешно построен!!!", Toast.LENGTH_LONG).show();


                    draw.setXX(xx1*10+1, xx2*10+1);


                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }
//


            }
        });
    }
}