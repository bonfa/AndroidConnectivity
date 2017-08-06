package com.ubunfu.connectivity.change_notifier;

import com.ubunfu.connectivity.notifier.ConnectivityStatusListener;
import com.ubunfu.connectivity.status.Connectivity;

public class ToConnectivityStatusListenerConnectivityChangeNotifier implements ConnectivityChangeNotifier {

    private final Connectivity connectivity;
    private final ConnectivityStatusListener connectivityStatusListener;

    public ToConnectivityStatusListenerConnectivityChangeNotifier(Connectivity connectivity, ConnectivityStatusListener connectivityStatusListener) {
        this.connectivity = connectivity;
        this.connectivityStatusListener = connectivityStatusListener;
    }

    public void notifyConnectivityChange() {
        if (connectivity.isConnected()) {
            this.connectivityStatusListener.onConnectionResumed();
        } else {
            this.connectivityStatusListener.onConnectionLost();
        }
    }
}
