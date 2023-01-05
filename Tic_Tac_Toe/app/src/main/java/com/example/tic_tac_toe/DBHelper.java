package com.example.tic_tac_toe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, NamesBase.DATABASE_NAME, null, NamesBase.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + NamesBase.TABLE_NAME + " (" +
                NamesBase.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NamesBase.COLUMN_NAME + " TEXT); ";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NamesBase.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
