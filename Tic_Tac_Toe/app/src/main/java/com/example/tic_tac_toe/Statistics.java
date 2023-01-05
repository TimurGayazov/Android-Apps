package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Statistics extends AppCompatActivity {
    Button btn_back_stat;
    ListView items;
    private NamesBase DBConnector;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    private void updateList(){
        adapter.clear();
        for (Names n: DBConnector.selectAll()){
            adapter.add(n.getName());

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        btn_back_stat = findViewById(R.id.btn_back_stat);
        items = findViewById(R.id.itemsList);
        DBConnector = new NamesBase(this);


        btn_back_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    finish();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Неопределенная ошибка", Toast.LENGTH_LONG).show();

                    return;
                }



            }

        });
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        items.setAdapter(adapter);
        updateList();
    }
}