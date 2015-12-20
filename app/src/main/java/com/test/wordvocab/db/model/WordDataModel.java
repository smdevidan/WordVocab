package com.test.wordvocab.db.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.test.wordvocab.db.IWordsDao;

/**
 * Created by dsunder on 12/20/2015.
 */
public class WordDataModel
{

    private int serverId;
    private String word;
    private String meaning;
    private float aspectRatio;
    private int variant;

    public WordDataModel()
    {

    }

    public WordDataModel(int serverId, String word, String meaning, float aspectRatio, int variant)
    {
        this.serverId = serverId;
        this.word = word;
        this.meaning = meaning;
        this.aspectRatio = aspectRatio;
        this.variant = variant;
    }

    public int getServerId()
    {
        return serverId;
    }

    public String getWord()
    {
        return word;
    }

    public String getMeaning()
    {
        return meaning;
    }

    public float getAspectRatio()
    {
        return aspectRatio;
    }

    public int getVariant()
    {
        return variant;
    }

    public void loadFromCursor(Cursor cursor)
    {

        this.serverId = cursor.getInt(cursor.getColumnIndex(IWordsDao.Columns.SERVER_ID));
        this.word = cursor.getString(cursor.getColumnIndex(IWordsDao.Columns.WORD));
        this.meaning = cursor.getString(cursor.getColumnIndex(IWordsDao.Columns.MEANING));
        this.aspectRatio = cursor.getFloat(cursor.getColumnIndex(IWordsDao.Columns.ASPECT_RATIO));
        this.variant = cursor.getInt(cursor.getColumnIndex(IWordsDao.Columns.VARIANT));

    }

    public ContentValues toContentValues()
    {
        ContentValues values = new ContentValues();

        values.put(IWordsDao.Columns.SERVER_ID, serverId);
        values.put(IWordsDao.Columns.WORD, word);
        values.put(IWordsDao.Columns.MEANING, meaning);
        values.put(IWordsDao.Columns.ASPECT_RATIO, aspectRatio);
        values.put(IWordsDao.Columns.VARIANT, variant);

        return values;

    }
}
