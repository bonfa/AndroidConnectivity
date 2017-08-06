package com.ubunfu.connectivity.change_notifier;

import com.ubunfu.connectivity.notifier.ConnectivityStatusListener;
import com.ubunfu.connectivity.status.Connectivity;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ToConnectivityStatusListenerConnectivityChangeNotifierTest {

    private ConnectivityStatusListener connectivityStatusListener;
    private Connectivity connectivity;
    private ToConnectivityStatusListenerConnectivityChangeNotifier properConnectivityListenerActionNotifier;

    @Before
    public void setUp() throws Exception {
        connectivityStatusListener = mock(ConnectivityStatusListener.class);
        connectivity = mock(Connectivity.class);
        properConnectivityListenerActionNotifier = new ToConnectivityStatusListenerConnectivityChangeNotifier(
                connectivity, connectivityStatusListener
        );
    }

    @Test
    public void notifyListenerThatWeAreConnected() throws Exception {
        when(connectivity.isConnected()).thenReturn(true);
        properConnectivityListenerActionNotifier.notifyConnectivityChange();
        verify(connectivityStatusListener).onConnectionResumed();
    }

    @Test
    public void notifyListenerThatWeAreNotConnected() throws Exception {
        when(connectivity.isConnected()).thenReturn(false);
        properConnectivityListenerActionNotifier.notifyConnectivityChange();
        verify(connectivityStatusListener).onConnectionLost();
    }
}
