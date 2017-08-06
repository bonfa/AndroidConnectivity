package com.ubunfu.connectivity.notifier;

import java.util.HashSet;
import java.util.Set;

public class BroadcastConnectivityStatusNotifier implements ConnectivityStatusListener, ConnectivityStatusNotifier {

    private final Set<ConnectivityStatusListener> connectivityStatusListeners = new HashSet<>();

    @Override
    public void addConnectivityStatusListener(ConnectivityStatusListener connectivityStatusListener) {
        connectivityStatusListeners.add(connectivityStatusListener);
    }

    @Override
    public void removeConnectivityStatusListener(ConnectivityStatusListener connectivityStatusListener) {
        connectivityStatusListeners.remove(connectivityStatusListener);
    }

    @Override
    public void onConnectionLost() {
        for (ConnectivityStatusListener connectivityStatusListener : connectivityStatusListeners) {
            connectivityStatusListener.onConnectionLost();
        }
    }

    @Override
    public void onConnectionResumed() {
        for (ConnectivityStatusListener connectivityStatusListener : connectivityStatusListeners) {
            connectivityStatusListener.onConnectionResumed();
        }
    }
}
