package com.example.a1027.d_3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView =(WebView)findViewById(R.id.webView);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setClickable(true);
        webView.addJavascriptInterface(
                new JSExecutor(MainActivity.this),"Android");
        //컨텍스트는 일단 MainActivity.this

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/test.html");


    }

    public class JSExecutor{
        Context ctx;
        public JSExecutor(Context ctx){
            this.ctx=ctx;
        }
        @JavascriptInterface
        public void showToast(){
            Toast.makeText(ctx,"Hello",Toast.LENGTH_SHORT).show();
        }
    }

    }
