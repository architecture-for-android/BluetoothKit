## BluetoothKit
队列连接/串式调用

#### BluetoothKit Instance
```BluetoothKit bluetoothKit = BluetoothKit.getInstance();```


#### Connectivity
```
    bluetoothKit
        .connect(device)
        .done((device1)->{})
        .fail((device2,exception)->{})
        .enqueue();
```


#### Notification
```
 bluetoothKit
        .notification(device)
        .done((device1)->{})
        .fail((device2,exception)->{})
        .receive((device3,bytes)->{})
        .enqueue();
```


#### Write
```
 bluetoothKit
        .write(device, bytes)
        .done((device1)->{})
        .fail((device2,exception)->{})
        .enqueue();
```