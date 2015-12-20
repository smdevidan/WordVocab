package com.test.wordvocabnetworkmanager;

import com.test.wordvocabnetworkmanager.resource.AbstractResource;

/**
 * Request model to queue network requests. Created by dsunder on 12/20/2015.
 */
public class NetworkRequestModel
{

    private AbstractResource resource;
    private INetworkRequestListener networkRequestListener;

    public NetworkRequestModel(AbstractResource resource, INetworkRequestListener listener)
    {
        this.resource = resource;
        this.networkRequestListener = listener;
    }

    public AbstractResource getResource()
    {
        return resource;
    }

    public INetworkRequestListener getNetworkRequestListener()
    {
        return networkRequestListener;
    }

}
