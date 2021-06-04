package com.racofix.things2.le;

import android.bluetooth.BluetoothDevice;

import com.racofix.things2.le.callback.FailCallback;
import com.racofix.things2.le.callback.ReceiveCallback;
import com.racofix.things2.le.callback.SuccessCallback;

public class NotificationRequest extends Request {

    NotificationRequest(final Type type, final BluetoothDevice device) {
        super(type, device);
    }

    @Override
    NotificationRequest setManager(final BluetoothKit manager) {
        super.setManager(manager);
        return this;
    }

    @Override
    public NotificationRequest done(final SuccessCallback callback) {
        super.done(callback);
        return this;
    }

    @Override
    public NotificationRequest fail(final FailCallback callback) {
        super.fail(callback);
        return this;
    }

    @Override
    public NotificationRequest receive(ReceiveCallback callback) {
        super.receive(callback);
        return this;
    }
}
