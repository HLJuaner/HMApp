package com.jncc.hmapp;
import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.jncc.hmapp.utils.AppIntroUtil;

import org.xutils.x;


/**
 * Created by h_vk on 16/4/16.
 */
public class HMApplication extends Application {

    //Http请求队列
    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        AppIntroUtil.getAppIntroUtil().setContext(this);
        queue = Volley.newRequestQueue(this);
    }

    /**
     * 获取获取当前Http请求队列
     */
    public static RequestQueue getHttpQueues(){
        return  queue;
    }

}
