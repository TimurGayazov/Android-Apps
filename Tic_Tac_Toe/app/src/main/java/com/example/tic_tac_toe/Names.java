package com.example.tic_tac_toe;

public class Names {
    public long id;
    public String name;

    public Names(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId(){return id;}
    public String getName(){return name;}
}
