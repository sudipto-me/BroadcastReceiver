package com.example.android.broadcastreceiver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Android on 7/27/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "numbers.db";
    private static final String TABLE_NAME = "numbers";
    private static final String COLUMN_ONE = "id";
    private static final String COLUMN_TWO = "value";

    private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +"("+
           COLUMN_ONE + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_TWO + " TEXT )";
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);

    }

    public void saveValue(String value){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_TWO,value);

        db.insert(TABLE_NAME,null,contentValues);
    }

    public Cursor readValue(){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] projection = {"id",COLUMN_TWO};

        Cursor cursor =db.query (TABLE_NAME,
        projection,
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }
}
