package com.ubunfu.connectivity.notifier;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class BroadcastConnectivityStatusNotifierTest {

    private BroadcastConnectivityStatusNotifier connectivityNotifier;
    private ConnectivityStatusListener connectivityStatusListener;

    @Before
    public void setUp() throws Exception {
        connectivityNotifier = new BroadcastConnectivityStatusNotifier();
        connectivityStatusListener = mock(ConnectivityStatusListener.class);
    }

    @Test
    public void notifyAnAddedListener() throws Exception {
        connectivityNotifier.addConnectivityStatusListener(connectivityStatusListener);

        connectivityNotifier.onConnectionResumed();
        verify(connectivityStatusListener).onConnectionResumed();

        connectivityNotifier.onConnectionLost();
        verify(connectivityStatusListener).onConnectionLost();
    }

    @Test
    public void dontNotifyARemovedListener() throws Exception {
        connectivityNotifier.addConnectivityStatusListener(connectivityStatusListener);
        connectivityNotifier.removeConnectivityStatusListener(connectivityStatusListener);

        connectivityNotifier.onConnectionResumed();
        verifyZeroInteractions(connectivityStatusListener);

        connectivityNotifier.onConnectionLost();
        verifyZeroInteractions(connectivityStatusListener);
    }
}
