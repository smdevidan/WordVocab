package com.test.wordvocab.db.impl;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.test.wordvocab.db.IWordsDao;
import com.test.wordvocab.db.model.WordDataModel;

/**
 * Created by dsunder on 12/20/2015.
 */
public class WordsDaoImpl implements IWordsDao
{

    private static String TAG = WordsDaoImpl.class.getSimpleName();
    private SQLiteOpenHelper dbHelper;

    private static String GET_ALL_WORDS_DATA = "SELECT * FROM " + IWordsDao.TABLE_NAME;
    private static String GET_ALL_IDS = "SELECT " + Columns.SERVER_ID + " FROM " + IWordsDao.TABLE_NAME;

    public WordsDaoImpl(SQLiteOpenHelper sqLiteOpenHelper)
    {
        this.dbHelper = sqLiteOpenHelper;
    }

    @Override
    public List<WordDataModel> getAllWordsList()
    {

        List<WordDataModel> wordsDataList = new ArrayList<>();
        Cursor cursor = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        try {
            cursor = db.rawQuery(GET_ALL_WORDS_DATA, null);
            if (cursor != null && cursor.getCount() > 0) {

                while (cursor.moveToNext()) {
                    WordDataModel dataModel = new WordDataModel();
                    dataModel.loadFromCursor(cursor);
                    wordsDataList.add(dataModel);
                }
            }

            return wordsDataList;
        }
        catch (Exception e) {
            Log.e(TAG, " Error getting data : ", e);
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return null;
    }

    @Override
    public void insertWordData(WordDataModel dataModel)
    {

        if (dataModel == null) {
            return;
        }
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.beginTransaction();
            db.insert(IWordsDao.TABLE_NAME, null, dataModel.toContentValues());
            db.setTransactionSuccessful();
        }
        catch (Exception e) {
            Log.e(TAG, " Error inserting data : ", e);
        }
        finally {
            if (db != null) {
                db.endTransaction();
            }
        }

    }

    @Override
    public void updateWordData(WordDataModel dataModel)
    {

        if (dataModel == null) {
            return;
        }
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.beginTransaction();
            db.update(IWordsDao.TABLE_NAME, dataModel.toContentValues(), Columns.SERVER_ID + "=?",
                    new String[] { String.valueOf(dataModel.getServerId()) });
            db.setTransactionSuccessful();
        }
        catch (Exception e) {
            Log.e(TAG, " Error updating data : ", e);
        }
        finally {
            if (db != null) {
                db.endTransaction();
            }
        }

    }

    @Override
    public List<Integer> getAllServerIds()
    {

        List<Integer> idList = new ArrayList<>();
        Cursor cursor = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        try {
            cursor = db.rawQuery(GET_ALL_IDS, null);
            if (cursor != null && cursor.getCount() > 0) {

                while (cursor.moveToNext()) {
                    idList.add(cursor.getInt(cursor.getColumnIndex(Columns.SERVER_ID)));
                }
            }

            return idList;
        }
        catch (Exception e) {
            Log.e(TAG, " Error getting ids : ", e);
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return null;
    }
}
