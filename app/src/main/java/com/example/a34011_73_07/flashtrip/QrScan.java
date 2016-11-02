package com.example.a34011_73_07.flashtrip;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static com.example.a34011_73_07.flashtrip.R.id.textQr;

public class QrScan extends AppCompatActivity implements ZXingScannerView.ResultHandler  {
    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.INTERNET,Manifest.permission.CAMERA
                },10);

            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan);

        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);

        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.resumeCameraPreview(QrScan.this);
    }

    @Override
    public void handleResult(Result rawResult) {

        Log.e("handler", rawResult.getText());
        Log.e("handler", rawResult.getBarcodeFormat().toString());

        final String shareResult = rawResult.getText();

        final Dialog dialog = new Dialog(QrScan.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_qr_scan);

        final ImageView click_ok = (ImageView) dialog.findViewById(R.id.click_ok);
        final ImageView click_share = (ImageView) dialog.findViewById(R.id.click_share);

        final TextView qrResult = (TextView) dialog.findViewById(R.id.textQr);
        qrResult.setText(shareResult);

        click_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mScannerView.resumeCameraPreview(QrScan.this);
               finish();
            }
        });

        click_share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareResult);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });

        dialog.show();

    }
}
