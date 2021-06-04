package com.racofix.things2.le;

import android.bluetooth.BluetoothDevice;

import com.racofix.things2.le.callback.FailCallback;
import com.racofix.things2.le.callback.SuccessCallback;

public class DisConnectedRequest extends Request {

    DisConnectedRequest(Type type, BluetoothDevice device) {
        super(type, device);
    }

    @Override
    DisConnectedRequest setManager(final BluetoothKit manager) {
        super.setManager(manager);
        return this;
    }

    @Override
    public DisConnectedRequest done(final SuccessCallback callback) {
        super.done(callback);
        return this;
    }

    @Override
    public DisConnectedRequest fail(final FailCallback callback) {
        super.fail(callback);
        return this;
    }
}
