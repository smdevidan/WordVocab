package com.test.wordvocabnetworkmanager.resource;

/**
 * Base resource class for all network call abstractions. Resource class can itself specify which URL to connect and how
 * to parse the response via Gson. Created by dsunder on 12/20/2015.
 */
public abstract class AbstractResource
{
    protected final String BASE_URL = "http://appsculture.com/";

    public abstract String getUrl();
}
