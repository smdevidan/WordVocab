package com.test.wordvocabnetworkmanager.resource;

import com.test.wordvocabnetworkmanager.model.WordsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsunder on 12/20/2015.
 */
public class WordJSONResource extends AbstractResource
{

    private int version;
    private List<WordsModel> words = new ArrayList<WordsModel>();
    private final String url = "vocab/words.json";

    @Override
    public String getUrl()
    {
        return BASE_URL + url;
    }

    public int getVersion()
    {
        return version;
    }

    public List<WordsModel> getWords()
    {
        return words;
    }
}
