package com.lau.spring2022.exam_helper_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_web);

        // to get the url sent from the main activity when clicked on an item in the list
        Intent intent = getIntent();

        String url = intent.getStringExtra("url");

        view = (WebView) findViewById(R.id.webview);

        view.getSettings().setJavaScriptEnabled(true); // returns a WebSettings object that can be used to control the WebView's settings
        view.setWebViewClient( new WebViewClient()); // sets the WebViewClient that will receive various notifications and requests
        view.loadUrl(url); // load the url
    }
}