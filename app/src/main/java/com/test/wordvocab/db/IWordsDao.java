package com.test.wordvocab.db;

import com.test.wordvocab.db.model.WordDataModel;

import java.util.List;

/**
 * Created by dsunder on 12/20/2015.
 */
public interface IWordsDao
{

    String TABLE_NAME = "words";

    interface Columns
    {
        String SERVER_ID = "serverId";
        String WORD = "word";
        String VARIANT = "variant";
        String MEANING = "meaning";
        String ASPECT_RATIO = "aspectRatio";
    }

    List<WordDataModel> getAllWordsList();

    void insertWordData(WordDataModel dataModel);

    void updateWordData(WordDataModel dataModel);

    List<Integer> getAllServerIds();
}
