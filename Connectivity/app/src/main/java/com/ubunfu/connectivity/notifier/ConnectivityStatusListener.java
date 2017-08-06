package com.ubunfu.connectivity.notifier;

public interface ConnectivityStatusListener {
    void onConnectionLost();
    void onConnectionResumed();
}
