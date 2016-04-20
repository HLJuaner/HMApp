package com.jncc.hmapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.jncc.hmapp.utils.ToastUtil;

import org.xutils.x;

/**
 * Created by h_vk on 16/4/16.
 */
public abstract class BaseFragment extends Fragment {

    public Activity mActivity;

    private boolean isCreate = false;

    private LinearLayout lLayout_titleContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();// 获取所在的activity对象
        lLayout_titleContent = (LinearLayout) mActivity.findViewById(R.id.lLayout_titleContent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        x.view().inject(this,view);
        isCreate = true;
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isCreate){
            isCreate = false;
            initData();
        }
    }

    public abstract int getLayoutId();


    public abstract void initData();

    /**
     * 跳转 Activity
     *
     * @param intent
     */
    public void setStartActivity(Intent intent){
        startActivity(intent);
    }


    /**
     * 动态添加导航栏右侧按钮
     *
     * @param view 动态view
     * @param listener  动态添加事件
     */
    public void setTitleBarWhiteRight(View view,final View.OnClickListener listener){
        lLayout_titleContent.addView(view);
        view.setOnClickListener(listener);
    }
}
