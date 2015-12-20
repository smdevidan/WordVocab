package com.test.wordvocab;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.test.wordvocab.network.WordsDataDownloadListener;
import com.test.wordvocabnetworkmanager.NetworkManager;
import com.test.wordvocabnetworkmanager.NetworkRequestModel;
import com.test.wordvocabnetworkmanager.resource.WordJSONResource;

public class WordsActivity extends AppCompatActivity
{

    private static final String TAG = WordsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        WordsApplication.getWordApplicationContext().getDaoService();
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
