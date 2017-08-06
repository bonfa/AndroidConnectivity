package com.ubunfu.connectivity.notifier;

public interface ConnectivityStatusNotifier {
    void addConnectivityStatusListener(ConnectivityStatusListener connectivityStatusListener);
    void removeConnectivityStatusListener(ConnectivityStatusListener connectivityStatusListener);
}
