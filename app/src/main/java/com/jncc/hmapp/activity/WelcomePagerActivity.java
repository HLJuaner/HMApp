package com.jncc.hmapp.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jncc.hmapp.BaseFragmentActivity;
import com.jncc.hmapp.R;
import com.jncc.hmapp.adapter.ViewPagerAdapter;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

public class WelcomePagerActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {

    @ViewInject(R.id.vp_welcomePager)
    private ViewPager vp_welcomePager;

    @ViewInject(R.id.lLayout_dot)
    private LinearLayout lLayout_dot;

    @ViewInject(R.id.rLayout_btnContent)
    private RelativeLayout rLayout_btnContent;

    private int []  images = new int[]{R.drawable.miku_12,R.drawable.load_2};

    private List<View> views;

    private ImageView imageView;

    private ImageView [] dotViews;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome_pager;
    }

    @Override
    protected void initData() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initViewPagerData();
    }


    //初始化ViewPager中的数据
    private void initViewPagerData(){
        views = new ArrayList<View>();
        for (int item:images){
            imageView = new ImageView(WelcomePagerActivity.this);
            imageView.setImageResource(item);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            views.add(imageView);
        }
        vp_welcomePager.setAdapter(new ViewPagerAdapter(WelcomePagerActivity.this, views));
        int index = getIntent().getIntExtra("welcomeCurrentItem",0);
        if (index != 0){
            index = views.size() -1;
            rLayout_btnContent.setVisibility(View.VISIBLE);
        }
        vp_welcomePager.setCurrentItem(index);
        initDotView(index);
    }



    //初始化导航页白点
    private void initDotView(int index){
        ImageView dotImg;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 20, 0);
        dotViews = new ImageView[views.size()];
        for (int i = 0 ; i < views.size(); i++){
            dotImg = new  ImageView(WelcomePagerActivity.this);
            if (i == index){
                dotImg.setImageResource(R.drawable.style_dot_select);
            } else {
                dotImg.setImageResource(R.drawable.style_dot_unselect);
            }
            dotImg.setLayoutParams(lp);
            dotImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dotViews[i] = dotImg;
            lLayout_dot.addView(dotImg);
        }
    }



    //绑定按钮点击事件
    @Event(value = {R.id.btn_experience,R.id.btn_login,R.id.btn_register})
    private void goActivity(View view){
//        switch (view.getId()){
//            case  R.id.btn_experience:
//                startActivity(new Intent(WelcomePagerActivity.this, MainActivity.class));
//                break;
//            case  R.id.btn_login:
//                startActivity(new Intent(WelcomePagerActivity.this, LoginActivity.class));
//                break;
//            case R.id.btn_register:
//                startActivity(new Intent(WelcomePagerActivity.this,RegisterActivity.class));
//                break;
//        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotViews.length; i++){
            if(position == i){
                dotViews[i].setImageResource(R.drawable.style_dot_select);
            }else{
                dotViews[i].setImageResource(R.drawable.style_dot_unselect);
            }
        }
        if (position == dotViews.length-1){
            rLayout_btnContent.setVisibility(View.VISIBLE);
        }else{
            rLayout_btnContent.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
