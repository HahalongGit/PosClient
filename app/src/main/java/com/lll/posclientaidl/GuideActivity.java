package com.lll.posclientaidl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnScannQrCode;

    private Button mBtnPrinter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mBtnScannQrCode = findViewById(R.id.btn_scannQrCode);
        mBtnPrinter = findViewById(R.id.btn_printer);
        mBtnPrinter.setOnClickListener(this);
        mBtnScannQrCode.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_printer: {
                Intent intent = new Intent(this, PrinterActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_scannQrCode: {
                Intent intent = new Intent(this, QuickScanQrActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
