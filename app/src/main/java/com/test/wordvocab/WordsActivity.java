package com.test.wordvocab;

import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.wordvocab.db.model.WordDataModel;
import com.test.wordvocab.ui.RecyclerViewAdapter;

public class WordsActivity extends AppCompatActivity
{

    private static final String TAG = WordsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        List<WordDataModel> dataList = WordsApplication.getWordApplicationContext().getDaoService().getWordDaoService()
                .getAllWordsList();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
}
