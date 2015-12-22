package com.mudo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mudo on 2015/12/18.
 */
public class SQLiteHelper extends SQLiteOpenHelper{


    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // TODO 建表语句，如果存在则不执行，如果不存在则执行。
        String sqlstr = "create table testtable(_id integer primary key autoincrement,_name text,_number text)";
        db.execSQL(sqlstr);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // TODO 数据库版本更新的时候使用，可以改变table的结构，也可以进行删除等操作
    }
}
