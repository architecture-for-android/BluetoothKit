package com.racofix.things2.le;

import android.bluetooth.BluetoothDevice;

import com.racofix.things2.le.callback.FailCallback;
import com.racofix.things2.le.callback.SuccessCallback;

public class WritedRequest extends Request {

    private byte[] bytes;

    WritedRequest(final Type type, final BluetoothDevice device, byte[] bytes) {
        super(type, device);
        this.bytes = bytes;
    }

    @Override
    WritedRequest setManager(final BluetoothKit manager) {
        super.setManager(manager);
        return this;
    }


    @Override
    public WritedRequest done(final SuccessCallback callback) {
        super.done(callback);
        return this;
    }

    @Override
    public WritedRequest fail(final FailCallback callback) {
        super.fail(callback);
        return this;
    }

    byte[] getBytes() {
        return bytes;
    }
}
