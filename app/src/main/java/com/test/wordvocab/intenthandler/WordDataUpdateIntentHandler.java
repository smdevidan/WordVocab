package com.test.wordvocab.intenthandler;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.test.wordvocab.WordsApplication;
import com.test.wordvocab.network.WordsDataDownloadListener;
import com.test.wordvocabnetworkmanager.NetworkManager;
import com.test.wordvocabnetworkmanager.NetworkRequestModel;
import com.test.wordvocabnetworkmanager.resource.WordJSONResource;

/**
 * Created by dsunder on 12/20/2015.
 */
public class WordDataUpdateIntentHandler extends IntentService
{

    private static final String TAG = WordDataUpdateIntentHandler.class.getSimpleName();
    public static final String UPDATE_WORDS_DATA_ACTION = "UPDATE_WORDS_DATA_ACTION";

    public WordDataUpdateIntentHandler()
    {
        super("WordDataUpdateIntentHandler");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (UPDATE_WORDS_DATA_ACTION.equals(intent.getAction())) {
            SharedPreferences sharedPreferences = WordsApplication.getWordApplicationContext()
                    .getSharedPreferences("keyValue", Context.MODE_PRIVATE);

            long lastUpdateTime = sharedPreferences.getLong("lastUpdateTime", 0);
            if (lastUpdateTime == 0 || (System.currentTimeMillis() - lastUpdateTime) > 24 * 60 * 60 * 1000) {
                NetworkManager networkManager = NetworkManager.getInstance();
                networkManager.initializeNetworkManager();
                NetworkRequestModel networkRequestModel = new NetworkRequestModel(new WordJSONResource(),
                        new WordsDataDownloadListener());
                try {
                    networkManager.submitRequest(networkRequestModel);
                }
                catch (InterruptedException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}
