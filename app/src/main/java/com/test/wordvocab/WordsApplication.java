package com.test.wordvocab;

import android.app.Application;
import android.content.Intent;

import com.test.wordvocab.intenthandler.WordDataUpdateIntentHandler;
import com.test.wordvocab.service.IDaoService;
import com.test.wordvocab.service.impl.DaoServiceImpl;
import com.test.wordvocabnetworkmanager.NetworkManager;

/**
 * Created by dsunder on 12/20/2015.
 */
public class WordsApplication extends Application
{
    private static final String TAG = WordsApplication.class.getSimpleName();
    private static WordsApplication application;
    private Object DAO_SERVICE_LOCK = new Object();
    private IDaoService daoService;

    @Override
    public void onCreate()
    {
        super.onCreate();
        application = this;

        NetworkManager networkManager = NetworkManager.getInstance();
        networkManager.initializeNetworkManager();
        // Fire intent to check for updates.
        Intent intent = new Intent(this, WordDataUpdateIntentHandler.class);
        intent.setAction(WordDataUpdateIntentHandler.UPDATE_WORDS_DATA_ACTION);
        startService(intent);
    }

    public static WordsApplication getWordApplicationContext()
    {
        return application;
    }

    /**
     * Get dao service
     * @return
     */
    public IDaoService getDaoService()
    {
        if (daoService == null) {
            synchronized (DAO_SERVICE_LOCK) {
                if (daoService == null) {
                    daoService = new DaoServiceImpl();
                }
            }
        }

        return daoService;
    }
}
