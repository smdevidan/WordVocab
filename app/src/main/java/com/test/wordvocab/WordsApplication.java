package com.test.wordvocab;

import android.app.Application;
import android.util.Log;

import com.test.wordvocab.db.IWordsDao;
import com.test.wordvocab.network.WordsDataDownloadListener;
import com.test.wordvocab.service.IDaoService;
import com.test.wordvocab.service.impl.DaoServiceImpl;
import com.test.wordvocabnetworkmanager.NetworkManager;
import com.test.wordvocabnetworkmanager.NetworkRequestModel;
import com.test.wordvocabnetworkmanager.resource.WordJSONResource;

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
    }

    public static WordsApplication getWordApplicationContext()
    {
        return application;
    }

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
