package com.racofix.things2.le;

import android.bluetooth.BluetoothDevice;

import com.racofix.things2.le.callback.FailCallback;
import com.racofix.things2.le.callback.SuccessCallback;

public class ConnectedRequest extends TimeoutRequest {

    private int retries = 0;
    private int delay = 0;

    ConnectedRequest(final Type type, final BluetoothDevice device) {
        super(type, device);
    }

    @Override
    ConnectedRequest setManager(final BluetoothKit manager) {
        super.setManager(manager);
        return this;
    }

    @Override
    public ConnectedRequest done(final SuccessCallback callback) {
        super.done(callback);
        return this;
    }

    @Override
    public ConnectedRequest fail(final FailCallback callback) {
        super.fail(callback);
        return this;
    }

    @Override
    public ConnectedRequest timeout(int timeout) {
        super.timeout(timeout);
        return this;
    }

    public ConnectedRequest retry(final int count) {
        this.retries = count;
        this.delay = 0;
        return this;
    }

    public ConnectedRequest retry(final int count, final int delay) {
        this.retries = count;
        this.delay = delay;
        return this;
    }

    public int getRetries() {
        return retries;
    }

    int getRetryDelay() {
        return delay;
    }

    boolean canRetry() {
        if (retries > 0) {
            retries -= 1;
            return true;
        }
        return false;
    }
}
