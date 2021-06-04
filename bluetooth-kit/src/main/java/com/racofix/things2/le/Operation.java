package com.racofix.things2.le;

import android.bluetooth.BluetoothDevice;

public interface Operation {

    void connect(BluetoothDevice device, Request request);

    void notification(BluetoothDevice device, Request request);

    void write(BluetoothDevice device, byte[] bytes, Request request);

    void disconnect(BluetoothDevice device, Request request);
}
