package com.mudo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.mudo.utils.SQLiteHelper;

/**
 * Created by Mudo on 2015/12/18.
 */
public class DBDao {

    SQLiteDatabase db ;
    public DBDao(Context context) {
        SQLiteHelper sqlitehelper = new SQLiteHelper(context,"dbname",null,1);
        this.db = sqlitehelper.getReadableDatabase();
    }

    // TODO 可以通过dao来访问的各种数据库方法，例如查找数据，删除数据，根据特定条件查找数据等。里面的各种方法都可以通过单元测试判断是否正确
}
