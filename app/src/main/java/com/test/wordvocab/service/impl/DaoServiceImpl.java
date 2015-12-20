package com.test.wordvocab.service.impl;

import android.database.sqlite.SQLiteOpenHelper;

import com.test.wordvocab.WordsApplication;
import com.test.wordvocab.db.AppSqliteOpenHelper;
import com.test.wordvocab.db.DBConstants;
import com.test.wordvocab.db.IWordsDao;
import com.test.wordvocab.db.impl.WordsDaoImpl;
import com.test.wordvocab.service.IDaoService;

/**
 * Created by dsunder on 12/20/2015.
 */
public class DaoServiceImpl implements IDaoService
{

    private IWordsDao wordsDao;
    SQLiteOpenHelper sqLiteOpenHelper;

    public DaoServiceImpl()
    {
        this.sqLiteOpenHelper = new AppSqliteOpenHelper(WordsApplication.getWordApplicationContext(),
                DBConstants.DB_NAME, null, DBConstants.DB_VERSION);

        initDB();

        this.wordsDao = new WordsDaoImpl(sqLiteOpenHelper);
    }

    private void initDB()
    {
        sqLiteOpenHelper.getReadableDatabase();
    }

    @Override
    public IWordsDao getWordDaoService()
    {
        return wordsDao;
    }
}
