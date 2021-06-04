package com.racofix.things2.le;

import android.bluetooth.BluetoothDevice;

import com.racofix.things2.le.callback.FailCallback;
import com.racofix.things2.le.callback.SuccessCallback;

public class TimeoutRequest extends Request {

    private int timeout;

    TimeoutRequest(Type type, BluetoothDevice device) {
        super(type, device);
    }

    @Override
    TimeoutRequest setManager(final BluetoothKit manager) {
        super.setManager(manager);
        return this;
    }

    @Override
    TimeoutRequest done(SuccessCallback callback) {
        super.done(callback);
        return this;
    }

    @Override
    TimeoutRequest fail(FailCallback callback) {
        super.fail(callback);
        return this;
    }

    TimeoutRequest timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public int getTimeout() {
        return timeout;
    }
}
