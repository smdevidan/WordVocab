package com.test.wordvocabnetworkmanager;

import com.squareup.okhttp.Response;
import com.test.wordvocabnetworkmanager.resource.AbstractResource;

/**
 * Network request state listener.
 * Created by dsunder on 12/20/2015.
 */
public interface INetworkRequestListener
{

    void onRequestStarted();

    void onRequestCompleted(AbstractResource resource);

    void onRequestFailed(Response response);
}
