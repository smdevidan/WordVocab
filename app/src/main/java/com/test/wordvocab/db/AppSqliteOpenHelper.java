package com.test.wordvocab.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * SQLite helper.
 * Created by dsunder on 12/20/2015.
 */
public class AppSqliteOpenHelper extends SQLiteOpenHelper
{
    private static final String TAG = AppSqliteOpenHelper.class.getSimpleName();

    public AppSqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            db.beginTransaction();
            for (int i = 0; i <= DBConstants.DB_VERSION; i++) {

                switch (i)
                {
                case 1: {
                    // DB sqls to execute.
                    db.execSQL(DBConstants.CREATE_WORDS_TABLE);
                }
                }

            }
            db.setTransactionSuccessful();
        }
        catch (Exception e) {
            Log.e(TAG, "Error creating DB : ", e);
        }
        finally {
            if (db != null) {
                db.endTransaction();
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
