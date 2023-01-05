package com.example.displaying_lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    Button selectall;
    Button resetall;
    Button addelem;
    Button showallelem;
    EditText inputelem;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectall = findViewById(R.id.selectall);
        resetall = findViewById(R.id.resetall);
        addelem = findViewById(R.id.addelem);
        showallelem = findViewById(R.id.showallelem);
        inputelem = findViewById(R.id.inputelem);
        listView = findViewById(R.id.list);

        String purchases[] = getResources().getStringArray(R.array.purchases);
        LinkedList<String> purchases1 = new LinkedList<String>(Arrays.asList(purchases));
        ListView list = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, purchases1);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);





        selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    for(int i = 0; i < purchases1.size(); i++) {
                        list.setItemChecked(i,true);
                    }



                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }
//


            }
        });
        resetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    for(int i = 0; i < purchases1.size(); i++) {
                        list.setItemChecked(i,false);
                    }


                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }
//


            }
        });

        addelem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    adapter.add(inputelem.getText().toString());
                    inputelem.getText().clear();


                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }
//


            }
        });

        showallelem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SparseBooleanArray check = list.getCheckedItemPositions();
                String checkTrue = "";
                for(int i = 0; i < list.getCount(); i++) {
                    if(check.get(i)) {
                        checkTrue += list.getItemAtPosition(i).toString() + ", ";
                    }
                }
                    Toast.makeText(getApplicationContext(),checkTrue, Toast.LENGTH_LONG).show();


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