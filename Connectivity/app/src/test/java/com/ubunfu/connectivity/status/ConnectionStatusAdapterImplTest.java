package com.ubunfu.connectivity.status;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConnectionStatusAdapterImplTest {

    private NetworkInfoToConnectionStatusAdapter networkInfoToConnectionStatusAdapter;
    private NetworkInfo networkInfo;

    @Before
    public void setUp() throws Exception {
        networkInfoToConnectionStatusAdapter = new NetworkInfoToConnectionStatusAdapter();
    }

    @Test
    public void isConnectedToWiFi() throws Exception {
        givenANetworkInfoWith(ConnectivityManager.TYPE_WIFI);
        thenTheConnectionStatusIs(true);
    }

    @Test
    public void isConnectedToMobile() throws Exception {
        givenANetworkInfoWith(ConnectivityManager.TYPE_MOBILE);
        thenTheConnectionStatusIs(true);
    }

    @Test
    public void isNotConnected() throws Exception {
        givenANetworkInfoWith(ConnectivityManager.TYPE_DUMMY);
        thenTheConnectionStatusIs(false);
    }

    @Test
    public void invalidNetworkInfo() throws Exception {
        boolean connectionStatus = networkInfoToConnectionStatusAdapter.isConnected(null);
        assertThat(connectionStatus, is(false));
    }

    private void givenANetworkInfoWith(int type) {
        networkInfo = mock(NetworkInfo.class);
        when(networkInfo.getType()).thenReturn(type);
    }

    private void thenTheConnectionStatusIs(boolean expectedConnectionStatus) {
        assertThat(networkInfoToConnectionStatusAdapter.isConnected(networkInfo), is(expectedConnectionStatus));
    }
}
