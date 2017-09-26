package com.yqq.performanceoptimisation.handlerLeak;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.yqq.performanceoptimisation.R;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class HandlerLeakActivity extends Activity {


    private static final int MSG =0X01 ;
    private static final String TAG = "HandlerLeakActivity";
    LeakHandler mLeakHandler=new LeakHandler();
    final LeakRunable mLeakRunable=new LeakRunable(HandlerLeakActivity.this);
    static  class LeakRunable implements Runnable {
       private WeakReference<HandlerLeakActivity>  mHandlerLeakActivity;
    public LeakRunable(HandlerLeakActivity _HandlerLeakActivity){

        mHandlerLeakActivity=new WeakReference<HandlerLeakActivity>(_HandlerLeakActivity);
    }

        @Override
        public void run() {
            //业务逻辑
            mHandlerLeakActivity.get().test();
        }
    }

    static class  LeakHandler  extends Handler{

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e(TAG,"--------handleMessage----"+msg.what);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_leak);


        mLeakHandler.postDelayed(mLeakRunable,1000);

    }



    private void test(){
        Toast.makeText(HandlerLeakActivity.this,"外部类方法",0).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null!=mLeakHandler){
            mLeakHandler.removeCallbacksAndMessages(null);
            mLeakHandler=null;
        }
    }
}
