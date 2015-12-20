package com.test.wordvocabnetworkmanager;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.test.wordvocabnetworkmanager.resource.AbstractResource;

/**
 * Created by dsunder on 12/20/2015.
 */
public class NetworkCallerThread extends Thread
{

    private static final String TAG = NetworkCallerThread.class.getSimpleName();
    LinkedBlockingQueue<NetworkRequestModel> blockingQueue;

    public NetworkCallerThread(LinkedBlockingQueue<NetworkRequestModel> queue)
    {
        this.blockingQueue = queue;
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                NetworkRequestModel request = blockingQueue.take();

                OkHttpClient httpClient = new OkHttpClient();
                Request networkRequest = new Request.Builder().url(request.getResource().getUrl()).build();
                request.getNetworkRequestListener().onRequestStarted();
                Response response = httpClient.newCall(networkRequest).execute();

                if (response.isSuccessful()) {
                    String body = response.body().string();
                    Log.e(TAG, "String : " + body);
                    Gson gson = new Gson();
                    AbstractResource resource = gson.fromJson(body, request.getResource().getClass());

                    request.getNetworkRequestListener().onRequestCompleted(resource);
                }
                else {
                    request.getNetworkRequestListener().onRequestFailed(response);
                }
                return;

            }
            catch (InterruptedException e) {
                Log.e(TAG, e.getMessage());
            }
            catch (IOException e) {
                Log.e(TAG, e.getMessage());
            }
        }

    }
}
