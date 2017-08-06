package com.ubunfu.connectivity.status;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConnectivityStatusTest {

    private ConnectivityStatus connectivityStatus;
    private ConnectionStatusAdapter connectionStatusAdapter;
    private NetworkInfo networkInfo;

    @Before
    public void setUp() throws Exception {
        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        connectionStatusAdapter = mock(ConnectionStatusAdapter.class);
        connectivityStatus = new ConnectivityStatus(connectivityManager, connectionStatusAdapter);
        networkInfo = mock(NetworkInfo.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);
    }

    @Test
    public void isConnected() throws Exception {
        when(connectionStatusAdapter.isConnected(networkInfo)).thenReturn(true);
        Assert.assertThat(connectivityStatus.isConnected(), is(true));
    }

    @Test
    public void isNotConnected() throws Exception {
        when(connectionStatusAdapter.isConnected(networkInfo)).thenReturn(false);
        Assert.assertThat(connectivityStatus.isConnected(), is(false));
    }
}
