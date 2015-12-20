package com.test.wordvocab.db;

/**
 * Database constants.
 * Created by dsunder on 12/20/2015.
 */
public interface DBConstants {

    // DB name
    String DB_NAME = "words.db";

    // Present DB version.
    int DB_VERSION = 1;

    String CREATE_WORDS_TABLE = "CREATE TABLE IF NOT EXISTS " + IWordsDao.TABLE_NAME + "( " +
            IWordsDao.Columns.SERVER_ID + " INTEGER PRIMARY KEY, " +
            IWordsDao.Columns.WORD + " TEXT, " +
            IWordsDao.Columns.MEANING + " TEXT, " +
            IWordsDao.Columns.ASPECT_RATIO + " REAL, " +
            IWordsDao.Columns.VARIANT + " INTEGER ) ";


}
