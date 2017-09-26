package com.yqq.performanceoptimisation.webviewLeak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yqq.performanceoptimisation.R;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class WebViewLeakAc extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_leak);




    }

    public void doLoadUrl(View view ){

        startActivity(new Intent(WebViewLeakAc.this,WebViewShowAc.class));

    }


}
