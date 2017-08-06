package com.ubunfu.connectivity.status;

import android.net.NetworkInfo;

interface ConnectionStatusAdapter {
    boolean isConnected(NetworkInfo networkInfo);
}
