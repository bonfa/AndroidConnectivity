package com.ubunfu.connectivity.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ubunfu.connectivity.change_notifier.ConnectivityChangeNotifier;

public class ConnectivityChangeBroadcastReceiver extends BroadcastReceiver {

    private final ConnectivityChangeNotifier connectivityChangeNotifier;

    public ConnectivityChangeBroadcastReceiver(ConnectivityChangeNotifier connectivityChangeNotifier) {
        super();
        this.connectivityChangeNotifier = connectivityChangeNotifier;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        connectivityChangeNotifier.notifyConnectivityChange();
    }
}
