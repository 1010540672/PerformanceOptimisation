package com.yqq.performanceoptimisation.singletonLeak;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/9/23 0023.
 */

public class Singleton4Static {

    private static Context sCtx;

    private Singleton4Static(Context context){
    //初始化相关的
    }
    private static class Holder{
        private static final Singleton4Static sInstance=new Singleton4Static(sCtx);

    }

    public static Singleton4Static  getInstance(Context context){
        //解决方法：上下文转换
       //sCtx=context.getApplicationContext();
        //解决方法 弱引用
        sCtx=new WeakReference<Context>(context).get();
        return  Holder.sInstance;
    }

}
