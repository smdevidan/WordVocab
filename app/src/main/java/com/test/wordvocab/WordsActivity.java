package com.test.wordvocab;

import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.wordvocab.db.model.WordDataModel;
import com.test.wordvocab.ui.IDataUpdateNotifier;
import com.test.wordvocab.ui.RecyclerViewAdapter;
import com.test.wordvocab.ui.UINotifier;

public class WordsActivity extends AppCompatActivity implements IDataUpdateNotifier
{

    private static final String TAG = WordsActivity.class.getSimpleName();
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mAdapter;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        mHandler = new Handler();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(layoutManager);
        setRecyclerViewData();
        UINotifier.getInstance().registerNotifier(this);
    }

    @Override
    public void onDataUpdate()
    {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                setRecyclerViewData();
                mAdapter.notifyDataSetChanged();
            }
        }, 0);

    }

    private void setRecyclerViewData()
    {
        List<WordDataModel> dataList = WordsApplication.getWordApplicationContext().getDaoService().getWordDaoService()
                .getAllWordsList();
        mAdapter = new RecyclerViewAdapter(this, dataList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        UINotifier.getInstance().deregisterDataNotifier();
    }
}
