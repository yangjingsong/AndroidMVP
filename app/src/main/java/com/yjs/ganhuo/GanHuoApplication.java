package com.yjs.ganhuo;

import android.app.Application;
import android.content.Context;

/**
 * Created by yangjingsong on 16/6/27.
 */
public class GanHuoApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
