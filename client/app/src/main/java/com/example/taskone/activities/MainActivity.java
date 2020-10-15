package com.example.taskone.activities;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskone.viewmodel.MyViewModel;
import com.example.taskone.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel = new MyViewModel();
    ;
    EditText hostEditText;
    Button sendReqButton;
    EditText portEditText;
    TextView responseText;
    private String mAppUnitId = "ca-app-pub-7526080045582593~7855797963";
    private String mInterstitialAdUnitId = "ca-app-pub-3940256099942544/1033173712";
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendReqButton = findViewById(R.id.btn_req);
        hostEditText = findViewById(R.id.host_edit_text);
        portEditText = findViewById(R.id.port_edit_text);
        responseText = findViewById(R.id.grpc_response_text);

        mInterstitialAd = new InterstitialAd(this);
        initializeInterstitialAd(mAppUnitId);
        mInterstitialAd.setAdUnitId(mInterstitialAdUnitId);
        loadInterstitialAd(mInterstitialAdUnitId);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });


        sendReqButton.setOnClickListener(view -> {
            if ("1".contentEquals(responseText.getText())) {
                viewModel.downloadFile(getFilesDir(), getApplicationContext());
            }
            if ("3".contentEquals(responseText.getText())) {
                mInterstitialAd.show();
                responseText.setText("0");
            } else {
                viewModel.sendRequest(hostEditText.getText().toString(), portEditText.getText().toString());
            }

        });

        viewModel.getNumber().observe(this,
                number -> responseText.setText(number.toString()));
    }

    private void initializeInterstitialAd(String appUnitId) {
        MobileAds.initialize(this, appUnitId);

    }

    private void loadInterstitialAd(String interstitialAdUnitId) {
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
}