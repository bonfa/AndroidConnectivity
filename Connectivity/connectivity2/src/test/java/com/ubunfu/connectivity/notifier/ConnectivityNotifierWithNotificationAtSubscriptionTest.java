package com.ubunfu.connectivity.notifier;

import com.ubunfu.connectivity.change_notifier.ConnectivityChangeNotifier;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConnectivityNotifierWithNotificationAtSubscriptionTest {

    private ConnectivityStatusNotifier connectivityStatusNotifier;
    private ConnectivityStatusListener connectivityStatusListener;
    private ConnectivityChangeNotifier connectivityChangeNotifier;
    private ConnectivityStatusNotifierWithNotificationAtSubscription connectivityNotifierWithNotificationAtSubscription;

    @Before
    public void setUp() throws Exception {
        givenSomeConnectivityStatusListeners();
        givenAConnectivityStatusListener();
        givenAConnectivityActionNotifier();
        givenAConnectivityBroadcastNotifier();
    }

    @Test
    public void addListenerAndNotifyIt() throws Exception {
        whenAConnectivityListenerIsAdded();
        thenTheListenerIsAddedAndNotified();
    }

    @Test
    public void removeListener() throws Exception {
        whenAConnectivityListenerIsRemoved();
        thenTheListenerIsRemoved();
    }

    private void thenTheListenerIsRemoved() {
        verify(connectivityStatusNotifier).removeConnectivityStatusListener(connectivityStatusListener);
    }

    private void givenSomeConnectivityStatusListeners() {
        connectivityStatusNotifier = mock(ConnectivityStatusNotifier.class);
    }

    private void givenAConnectivityStatusListener() {
        connectivityStatusListener = mock(ConnectivityStatusListener.class);
    }

    private void givenAConnectivityActionNotifier() {
        connectivityChangeNotifier = mock(ConnectivityChangeNotifier.class);
    }

    private void givenAConnectivityBroadcastNotifier() {
        connectivityNotifierWithNotificationAtSubscription = new ConnectivityStatusNotifierWithNotificationAtSubscription(
                connectivityStatusNotifier,
                connectivityChangeNotifier
        );
    }

    private void whenAConnectivityListenerIsAdded() {
        connectivityNotifierWithNotificationAtSubscription.addConnectivityStatusListener(connectivityStatusListener);
    }

    private void whenAConnectivityListenerIsRemoved() {
        connectivityNotifierWithNotificationAtSubscription.removeConnectivityStatusListener(connectivityStatusListener);
    }

    private void thenTheListenerIsAddedAndNotified() {
        verify(connectivityStatusNotifier).addConnectivityStatusListener(connectivityStatusListener);
        verify(connectivityChangeNotifier).notifyConnectivityChange();
    }
}
