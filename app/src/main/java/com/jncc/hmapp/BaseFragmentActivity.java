package com.jncc.hmapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jncc.hmapp.utils.ActivityManager;
import com.jncc.hmapp.utils.ToastUtil;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by h_vk on 16/4/16.
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    @ViewInject(R.id.tv_title)
    private TextView tv_title;

    @ViewInject(R.id.rLayout_titleBar)
    private RelativeLayout rLayout_titleBar;

    @ViewInject(R.id.ib_titleToLeft)
    private ImageButton ib_titleToLeft;

    @ViewInject(R.id.lLayout_titleContent)
    private LinearLayout lLayout_titleContent;

    private boolean isCreate = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getAppManager().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        x.view().inject(this);
        isCreate = true;
    }


    /**
     * 设置Activity 主布局
     */
    protected abstract int getLayoutId();



    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    protected void onDestroy(){
        ActivityManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isCreate){
            isCreate = false;
            initData();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 隐藏 标题Bar
     */
    public void hiddenTitleBar(){
        rLayout_titleBar.setVisibility(View.GONE);
    }

    /**
     * 设置标题栏内容
     *
     * @param title  标题内容
     */
    public void setTitle(String title){
        tv_title.setText(title);
    }

    /**
     * 显示左侧返回按钮
     *
     */
    public void showTitleBarWhiteLeft(){
        ib_titleToLeft.setVisibility(View.VISIBLE);
    }


    /**
     * 显示右侧自定义按钮
     *
     * @param isShow  true 显示 false 不显示
     */
    public void showTitleBarWhiteRight(boolean isShow){
        if (isShow){
            lLayout_titleContent.setVisibility(View.VISIBLE);
        }else{
            lLayout_titleContent.setVisibility(View.GONE);
        }

    }

    /**
     * 动态添加导航栏右侧按钮
     *
     * @param view 动态view
     * @param listener  动态添加事件
     */
    public void setTitleBarWhiteRight(View view,final View.OnClickListener listener){
        lLayout_titleContent.setVisibility(View.VISIBLE);
        lLayout_titleContent.addView(view);
        view.setOnClickListener(listener);
    }

    /**
     * 跳转 Activity
     *
     * @param intent
     * @param isFinish  是否结束当前Activity
     */
    public void setStartActivity(Intent intent, boolean isFinish){
        startActivity(intent);
        if (isFinish){
            finish();
        }
    }

    @Event(value = R.id.ib_titleToLeft)
    private void onClick(View view){
        finish();
    }

}