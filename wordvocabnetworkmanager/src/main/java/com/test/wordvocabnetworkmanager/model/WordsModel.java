package com.test.wordvocabnetworkmanager.model;

/**
 * Parse model for JSON response. Created by dsunder on 12/20/2015.
 */
public class WordsModel
{
    private int id;
    private String word;
    private String meaning;
    private float ratio;
    private int variant;

    public WordsModel()
    {

    }

    public int getServerId()
    {
        return id;
    }

    public String getWord()
    {
        return word;
    }

    public String getMeaning()
    {
        return meaning;
    }

    public float getRatio()
    {
        return ratio;
    }

    public int getVariant()
    {
        return variant;
    }
}
