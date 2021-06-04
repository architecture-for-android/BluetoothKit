package com.racofix.things2.le;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import com.racofix.things2.le.util.UiThread;

public class BluetoothKit {

    private LinkedRequestQueue mRequestQueue;
    private static BluetoothKit manager;
    private static Configurations.Builder newBuilder;

    private BluetoothKit() {
        if (newBuilder == null)
            throw new RuntimeException("Bluetooth Occurred Initialize Exception!");
        this.mRequestQueue = new LinkedRequestQueue();
    }

    public static BluetoothKit getInstance() {
        if (manager == null) synchronized (BluetoothKit.class) {
            if (manager == null) manager = new BluetoothKit();
        }
        return manager;
    }

    /*init configurations*/
    public static Configurations.Builder init() {
        if (newBuilder == null) synchronized (Configurations.class) {
            if (newBuilder == null) newBuilder = Configurations.newBuilder();
        }
        return newBuilder;
    }

    public final ConnectedRequest connect(final String address) {
        BluetoothDevice device = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(address);
        return connect(device);
    }

    public final ConnectedRequest connect(final BluetoothDevice device) {
        return Request.newConnectRequest(device).setManager(this);
    }

    public final NotificationRequest notification(final BluetoothDevice device) {
        return Request.newNotificationRequest(device).setManager(this);
    }

    public final WritedRequest write(final BluetoothDevice device, byte[] data) {
        return Request.newWriteRequest(device, data).setManager(this);
    }

    public final DisConnectedRequest disconnect(final BluetoothDevice device) {
        return Request.newDisConnectedRequest(device).setManager(this);
    }

    public static Configurations getConfigurations() {
        return newBuilder.newInstance();
    }

    // Caller controls Request execution order
    final void enqueue(final Request request) {
        this.mRequestQueue.add(request);
        UiThread.getInstance().runOnUiThread(this::nextRequest);
    }

    private void nextRequest() {
        Request mRequest = null;
        // If Request set is present, try taking next request getInstance it
        if (mRequestQueue.hasMore()) {
            mRequest = mRequestQueue.getNext();
        }

        if (mRequest == null) return;

//        mRequest.fail((device, message) -> UiThread.getInstance().runOnUiThread(this::nextRequest));

        BluetoothDevice device = mRequest.getDevice();
        Operation trigger = getConfigurations().getTrigger();
        switch (mRequest.getType()) {
            case CONNECT:
                ConnectedRequest cr = (ConnectedRequest) mRequest;
                trigger.connect(device, cr);
                break;

            case NOTIFICATION:
                NotificationRequest nr = (NotificationRequest) mRequest;
                trigger.notification(device, nr);
                break;

            case WRITE:
                WritedRequest wr = (WritedRequest) mRequest;
                trigger.write(device, wr.getBytes(), wr);
                break;

            case DISCONNECT:
                DisConnectedRequest dr = (DisConnectedRequest) mRequest;
                trigger.disconnect(device, dr);
                break;
            default:
                break;
        }
    }
}
