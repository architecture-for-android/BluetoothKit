package com.racofix.things2.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.racofix.things2.le.BluetoothKit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothKit bluetoothKit = BluetoothKit.getInstance();

    }
}
