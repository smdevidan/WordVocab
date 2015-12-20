package com.test.wordvocab.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.List;

import com.squareup.okhttp.Response;
import com.test.wordvocab.WordsApplication;
import com.test.wordvocab.db.IWordsDao;
import com.test.wordvocab.db.model.WordDataModel;
import com.test.wordvocabnetworkmanager.INetworkRequestListener;
import com.test.wordvocabnetworkmanager.model.WordsModel;
import com.test.wordvocabnetworkmanager.resource.AbstractResource;
import com.test.wordvocabnetworkmanager.resource.WordJSONResource;

/**
 * Created by dsunder on 12/20/2015.
 */
public class WordsDataDownloadListener implements INetworkRequestListener
{
    private static final String TAG = WordsDataDownloadListener.class.getSimpleName();

    @Override
    public void onRequestStarted()
    {

    }

    @Override
    public void onRequestCompleted(AbstractResource resource)
    {
        if (resource == null) {
            return;
        }

        SharedPreferences sharedPreferences = WordsApplication.getWordApplicationContext()
                .getSharedPreferences("keyValue", Context.MODE_PRIVATE);

        sharedPreferences.edit().putLong("lastUpdateTime", System.currentTimeMillis()).apply();

        IWordsDao wordsDao = WordsApplication.getWordApplicationContext().getDaoService().getWordDaoService();
        List<Integer> existingServerIdsList = wordsDao.getAllServerIds();
        List<WordsModel> dataValues = ((WordJSONResource) resource).getWords();
        for (WordsModel networkModel : dataValues) {

            if (networkModel.getRatio() < 0) {
                continue;
            }
            WordDataModel dbModel = new WordDataModel(networkModel.getServerId(), networkModel.getWord(),
                    networkModel.getMeaning(), networkModel.getRatio(), networkModel.getVariant());

            if (existingServerIdsList.contains(dbModel.getServerId())) {
                Log.e(TAG, "Updating word data for : " + dbModel.getWord());
                wordsDao.updateWordData(dbModel);
            }
            else {
                Log.e(TAG, "Inserting data for : " + dbModel.getWord());
                wordsDao.insertWordData(dbModel);
            }
        }

    }

    @Override
    public void onRequestFailed(Response response)
    {

    }
}
