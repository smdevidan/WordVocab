package com.test.wordvocabnetworkmanager;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dsunder on 12/20/2015.
 */
public class NetworkManager
{

    private static NetworkManager networkManager;
    private static LinkedBlockingQueue<NetworkRequestModel> blockingQueue;
    Thread networkCallerThread;

    public static NetworkManager getInstance()
    {
        if (networkManager == null) {
            networkManager = new NetworkManager();
        }

        return networkManager;
    }

    public void initializeNetworkManager()
    {

        blockingQueue = new LinkedBlockingQueue<>(10);
        networkCallerThread = new NetworkCallerThread(blockingQueue);
        networkCallerThread.start();
    }

    public void submitRequest(NetworkRequestModel networkRequestModel) throws InterruptedException
    {
        blockingQueue.put(networkRequestModel);
    }
}
