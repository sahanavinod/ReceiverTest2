package com.example.receivertest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;

import java.text.DateFormat;
//NOTE: This class implementation is incomplete
public class Database extends SQLiteOpenHelper {

    private static final String ADTIMER_TABLE = "ADTIMER" ;
    private static final String COL_ID = "ADID" ;
    private static final String COL_SHOWDATE = "SHOWDATE";

    public Database(@Nullable Context context) {
        super(context, "tvapp.db", null, 1);
        Log.i("database created","created successfully");
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_database);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("create table %s(%s text,%s numeric,STARTTIME numeric,ENDTIME numeric, ADSHOWMODE text)",ADTIMER_TABLE,COL_ID,COL_SHOWDATE);

        db.execSQL(sql);
        Log.i("Table","Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void storeTimeData(int prevIndex){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(ADTIMER_TABLE,null,null);

        ContentValues values = new ContentValues();
        values.put(COL_ID,prevIndex);
        values.put(COL_SHOWDATE, String.valueOf(DateFormat.getDateInstance()));
        db.insert(ADTIMER_TABLE, null, values);

        db.close();
    }
}
