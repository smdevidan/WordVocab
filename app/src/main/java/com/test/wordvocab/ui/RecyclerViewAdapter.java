package com.test.wordvocab.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.wordvocab.R;
import com.test.wordvocab.db.model.WordDataModel;

import java.util.List;

/**
 * Created by dsunder on 12/20/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter
{

    private List<WordDataModel> wordsDataList;

    public RecyclerViewAdapter(List<WordDataModel> list)
    {
        this.wordsDataList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        WordsDataViewHolder viewHolder = new WordsDataViewHolder(cardView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        WordsDataViewHolder wordsDataViewHolder = (WordsDataViewHolder) holder;
        WordDataModel data = wordsDataList.get(position);
        wordsDataViewHolder.meaning.setText(data.getMeaning());
        wordsDataViewHolder.word.setText(data.getWord());

    }

    @Override
    public int getItemCount()
    {

        if (wordsDataList != null) {
            return wordsDataList.size();
        }
        return 0;
    }
}
