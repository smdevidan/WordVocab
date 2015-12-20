package com.test.wordvocab.ui;

/**
 * UI notifier on data updates.
 * Created by dsunder on 12/20/2015.
 */
public class UINotifier
{

    private static UINotifier uiNotifier = new UINotifier();

    public static UINotifier getInstance()
    {
        return uiNotifier;
    }

    private IDataUpdateNotifier dataUpdateNotifier;

    public void registerNotifier(IDataUpdateNotifier notifier)
    {
        this.dataUpdateNotifier = notifier;
    }

    public void deregisterDataNotifier()
    {
        this.dataUpdateNotifier = null;
    }

    public void onDataUpdated()
    {
        if (dataUpdateNotifier != null) {
            dataUpdateNotifier.onDataUpdate();
        }
    }

}
