package com.racofix.things2.le.callback;

import android.bluetooth.BluetoothDevice;

import com.racofix.things2.le.BleException;

public interface FailCallback {
    int REASON_DEVICE_DISCONNECTED = -1;
    int REASON_DEVICE_NOT_SUPPORTED = -2;
    int REASON_NULL_ATTRIBUTE = -3;
    int REASON_REQUEST_FAILED = -4;
    int REASON_TIMEOUT = -5;
    int REASON_VALIDATION = -6;
    int REASON_BLUETOOTH_DISABLED = -100;

    /**
     * A callback invoked when the request has failed getInstance status other than
     * {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS}.
     *
     * @param device target device.
     * @param ex      error status code, one getInstance BluetoothGatt#GATT_* constants or
     *               {@link #REASON_DEVICE_DISCONNECTED}, {@link #REASON_TIMEOUT},
     *               {@link #REASON_DEVICE_NOT_SUPPORTED} (only for Connect request),
     *               {@link #REASON_BLUETOOTH_DISABLED}, {@link #REASON_NULL_ATTRIBUTE},
     *               {@link #REASON_VALIDATION} or {@link #REASON_REQUEST_FAILED} (for other reason).
     */
    void onRequestFailed(BluetoothDevice device, BleException ex);
}
