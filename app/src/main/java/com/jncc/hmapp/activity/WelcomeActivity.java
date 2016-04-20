package com.jncc.hmapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.jncc.hmapp.BaseFragmentActivity;
import com.jncc.hmapp.R;
import com.jncc.hmapp.utils.AppIntroUtil;

public class WelcomeActivity extends BaseFragmentActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initData() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //判断是否为首次启动 或 更新
//                int launchModel  = AppIntroUtil.getAppIntroUtil().markOpenApp(WelcomeActivity.this);

//                setStartActivity(new Intent(WelcomeActivity.this,WelcomePagerActivity.class),true);


//                if (launchModel == AppIntroUtil.APP_AGAIN_BOOT){
//                    String isLogin = AppIntroUtil.getThis().getShareValue(AppIntroUtil.ACCOUNT);
//                    if(isLogin == null || isLogin.equals("")){
//                Intent intent = new Intent(WelcomeActivity.this,WelcomePagerActivity.class);
//                intent.putExtra("welcomeCurrentItem",2);
////                        startActivity(intent);
//                setStartActivity(intent,true);
//                    }else{
//                        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
//                    }
//                } else {
//                    startActivity(new Intent(WelcomeActivity.this, WelcomePagerActivity.class));
//                }
                setStartActivity(new Intent(WelcomeActivity.this,MainActivity.class),true);
            }
        }, 3000);
    }
}
