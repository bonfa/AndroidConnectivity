package com.ubunfu.connectivity.notifier;

import com.ubunfu.connectivity.change_notifier.ConnectivityChangeNotifier;

public class ConnectivityStatusNotifierWithNotificationAtSubscription implements ConnectivityStatusNotifier {

    private final ConnectivityStatusNotifier connectivityStatusNotifier;
    private final ConnectivityChangeNotifier connectivityChangeNotifier;

    public ConnectivityStatusNotifierWithNotificationAtSubscription(ConnectivityStatusNotifier connectivityStatusNotifier,
                                                                    ConnectivityChangeNotifier connectivityChangeNotifier) {
        this.connectivityStatusNotifier = connectivityStatusNotifier;
        this.connectivityChangeNotifier = connectivityChangeNotifier;
    }

    @Override
    public void addConnectivityStatusListener(ConnectivityStatusListener connectivityStatusListener) {
        connectivityStatusNotifier.addConnectivityStatusListener(connectivityStatusListener);
        connectivityChangeNotifier.notifyConnectivityChange();
    }

    @Override
    public void removeConnectivityStatusListener(ConnectivityStatusListener connectivityStatusListener) {
        connectivityStatusNotifier.removeConnectivityStatusListener(connectivityStatusListener);
    }
}
