package com.ubunfu.connectivity.broadcast_receiver;

import android.content.Context;
import android.content.Intent;

import com.ubunfu.connectivity.change_notifier.ToConnectivityStatusListenerConnectivityChangeNotifier;
import com.ubunfu.connectivity.status.Connectivity;
import com.ubunfu.connectivity.status.ConnectivityStatus;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConnectivityChangeBroadcastReceiverTest {

    private ConnectivityChangeBroadcastReceiver connectivityChangeBroadcastReceiver;
    private ToConnectivityStatusListenerConnectivityChangeNotifier connectivityListenerActionNotifier;

    @Test
    public void notifyListenersOnNetworkChange() throws Exception {
        givenAConnectivityStatus();
        givenAConnectivityListenerActionNotifier();
        givenNetworkChangeBroadcastReceiver();
        whenTheReceiverIsNotified();
        thenTheListenerIsNotifiedAboutNetworkInfoChange();
    }

    private void givenAConnectivityListenerActionNotifier() {
        connectivityListenerActionNotifier = mock(ToConnectivityStatusListenerConnectivityChangeNotifier.class);
    }

    private void givenNetworkChangeBroadcastReceiver() {
        connectivityChangeBroadcastReceiver = new ConnectivityChangeBroadcastReceiver(connectivityListenerActionNotifier);
    }

    private void givenAConnectivityStatus() {
        Connectivity connectivity = mock(ConnectivityStatus.class);
        when(connectivity.isConnected()).thenReturn(true);
    }

    private void whenTheReceiverIsNotified() {
        connectivityChangeBroadcastReceiver.onReceive(mock(Context.class), mock(Intent.class));
    }

    private void thenTheListenerIsNotifiedAboutNetworkInfoChange() {
        verify(connectivityListenerActionNotifier).notifyConnectivityChange();
    }

}
