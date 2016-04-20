package com.jncc.hmapp.utils;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by h_vk on 16/4/16.
 */
public class AppIntroUtil {

    public static final int APP_INSTALL_BOOT = 1;//首次安装启动

    public static final int APP_UPDATE_BOOT = 2; //更新后启动

    public static final int APP_AGAIN_BOOT = 3; //再次启动

    private boolean isOpenMarked = false;

    public static final String SHARENAME = "HM2App";

    private int launchMode = APP_AGAIN_BOOT; //启动-模式

    private static AppIntroUtil instance;

    private String currentVersion = "";

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static AppIntroUtil getAppIntroUtil() {
        if (instance == null)
            instance = new AppIntroUtil();
        return instance;
    }



    /**
     * 设置 Android 启动模式
     */
    public void markOpenApp() {
        if (isOpenMarked){ return;}
        isOpenMarked = true;
        String lastVersion = SPUtil.getString(context, SHARENAME, SHARENAME);
        String currentVersion = VersionUtil.getVersion(context);
        // 首次启动
        if (TextUtils.isEmpty(lastVersion)) {
            launchMode = APP_INSTALL_BOOT;
            SPUtil.setString(context, SHARENAME, SHARENAME, currentVersion);
        }
        // 更新后启动
        else if (VersionUtil.compareVersion(lastVersion,currentVersion)) {
            launchMode = APP_UPDATE_BOOT;
            SPUtil.setString(context, SHARENAME, SHARENAME, currentVersion);
        }
        // 二次启动(版本未变)
        else {
            launchMode = APP_AGAIN_BOOT;
        }
    }


    /**
     * 获取当前启动模式
     */
    public  int getLaunchMode(){
        return  launchMode;
    }


    public static final String ACCOUNT = "HMACCOUNT"; //登录用户账号
    public static final String PASSWORLD = "HMPASSWORLD";
    public static final String ACCESS_TOKEN="HMACCESSTOKEN";
    public static final String  EXPIRES_IN  = "EXPIRES_IN";
    public static final String LOGIN_DATETIME = "LOGINDATETIME";

    /**
     * 获取App中的记录数据
     * @param key
     */
    public String getShareValue(String key){
        return SPUtil.getString(context,key,key);
    }

    /**
     * 设置App的记录数据
     * @param key
     * @param value
     */
    public void setShareValue(String key,String value){
        SPUtil.setString(context,key,key,value);
    }




}
