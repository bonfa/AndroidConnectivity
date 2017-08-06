package com.ubunfu.connectivity.status;

import android.net.ConnectivityManager;

public class ConnectivityStatus implements Connectivity {

    private final ConnectivityManager connectivityManager;
    private final ConnectionStatusAdapter connectionStatusAdapter;

    public ConnectivityStatus(ConnectivityManager connectivityManager, ConnectionStatusAdapter connectionStatusAdapter) {
        this.connectivityManager = connectivityManager;
        this.connectionStatusAdapter = connectionStatusAdapter;
    }

    @Override
    public boolean isConnected() {
        return connectionStatusAdapter.isConnected(connectivityManager.getActiveNetworkInfo());
    }
}
