package com.racofix.things2.le.callback;

import android.bluetooth.BluetoothDevice;

public interface ReceiveCallback {

    void onRequestReceive(BluetoothDevice device, byte[] bytes);
}
