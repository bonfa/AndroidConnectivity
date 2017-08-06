package com.ubunfu.connectivity.status;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkInfoToConnectionStatusAdapter implements ConnectionStatusAdapter {

    public boolean isConnected(NetworkInfo networkInfo) {
        if (null != networkInfo) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }
        }
        return false;
    }
}
