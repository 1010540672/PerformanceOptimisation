package com.yqq.performanceoptimisation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yqq.performanceoptimisation.handlerLeak.HandlerLeakActivity;
import com.yqq.performanceoptimisation.singletonLeak.innnerClassLeak.InnerClassActivity;
import com.yqq.performanceoptimisation.webviewLeak.WebViewLeakAc;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //单例引用了比他生命周期还短的对象
       // Singleton4Static.getInstance(this);

    }


    public void doInnerClassLeak(View view){
    startActivity(new Intent(MainActivity.this, InnerClassActivity.class));


    }

    public void doHandlerLeak(View view){

        startActivity(new Intent(MainActivity.this, HandlerLeakActivity.class));

    }

    public void doWebviewLeak(View view){

        startActivity(new Intent(MainActivity.this, WebViewLeakAc.class));

    }


}
