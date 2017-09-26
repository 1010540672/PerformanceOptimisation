package com.yqq.performanceoptimisation.singletonLeak.innnerClassLeak;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.yqq.performanceoptimisation.R;


public class InnerClassActivity extends AppCompatActivity {
    StaticAsynckTask mTask=new StaticAsynckTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_class);
       // doLeak();
        mTask.execute();

//        new AsyncTask<Void,Void,Void>(){
//
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                SystemClock.sleep(15000);
//                return null;
//            }
//
//
//        }.execute();



    }

    private static void doLeak(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(10000);
            }
        }).start();
    }






    static class StaticAsynckTask extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {

            SystemClock.sleep(15000);
            return null;
        }
    }







   }





