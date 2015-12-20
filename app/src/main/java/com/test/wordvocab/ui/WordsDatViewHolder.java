package com.test.wordvocab.ui;

import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.wordvocab.R;

/**
 * Created by dsunder on 12/20/2015.
 */
class WordsDataViewHolder extends RecyclerView.ViewHolder
{

    CardView cardView;
    ImageView image;
    TextView word;
    TextView meaning;

    public WordsDataViewHolder(View view)
    {
        super(view);
        cardView = (CardView) view.findViewById(R.id.cardView);
        image = (ImageView) view.findViewById(R.id.cardImage);
        word = (TextView) view.findViewById(R.id.word);
        meaning = (TextView) view.findViewById(R.id.meaning);
    }
}
