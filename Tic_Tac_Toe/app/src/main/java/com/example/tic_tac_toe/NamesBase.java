package com.example.tic_tac_toe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NamesBase {
    public static String DATABASE_NAME = "list_db";
    public static int DATABASE_VERSION = 1;
    public static String TABLE_NAME = "Names";

    public static String COLUMN_ID = "_id";
    public static String COLUMN_NAME = "name";
    public static int NUM_COLUMN_ID = 0;
    public static int NUM_COLUMN_NAME = 1;

    private final SQLiteDatabase mDataBase;
    Context context;

    public NamesBase(Context context){
        DBHelper helper = new DBHelper(context);
        mDataBase = helper.getWritableDatabase();
        this.context = context;
    }

    public ArrayList<Names> selectAll(){
        Cursor mCursor = mDataBase.query(TABLE_NAME,null,null,null,null,null,null);
        ArrayList<Names> list = new ArrayList<Names>();
        mCursor.moveToFirst();
        if (!mCursor.isAfterLast()){
            do {
                long id = mCursor.getLong(NUM_COLUMN_ID);
                String name = mCursor.getString(NUM_COLUMN_NAME);
                Names names = new Names(id,name);
                list.add(names);
            }while (mCursor.moveToNext());
        }
        mCursor.close();
        return list;
    }

    public long add(String name){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);

        return mDataBase.insert(TABLE_NAME,null, cv);
    }

    public void clear() {
        //Выполняем запрос DELETE
        mDataBase.delete(TABLE_NAME, null, null);
    }

}
