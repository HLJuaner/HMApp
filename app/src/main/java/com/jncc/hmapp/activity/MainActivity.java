package com.jncc.hmapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jncc.hmapp.BaseFragmentActivity;
import com.jncc.hmapp.R;
import com.jncc.hmapp.fragment.TabCheckCropFragment;
import com.jncc.hmapp.fragment.TabIndexFragment;
import com.jncc.hmapp.fragment.TabMyFragment;
import com.jncc.hmapp.fragment.TabWorkManagerFragment;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by h_vk on 16/4/16.
 */
public class MainActivity extends BaseFragmentActivity implements RadioGroup.OnCheckedChangeListener {

    @ViewInject(R.id.rg_navTab)
    private RadioGroup rg_navTab;

    @ViewInject(R.id.rb_tabIndex)
    private RadioButton rb_tabIndex;

    @ViewInject(R.id.rb_tabWorkManager)
    private RadioButton rb_tabWorkManager;

    @ViewInject(R.id.rb_tabCheckCrop)
    private RadioButton rb_tabCheckCrop;

    @ViewInject(R.id.rb_tabMy)
    private RadioButton rb_tabMy;

    private Fragment tabIndexFragment,tabWorkManagerFragment,tabCheckCropFragment,tabMyFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        rg_navTab.setOnCheckedChangeListener(this);
        selectTab(0);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_tabIndex:
                selectTab(0);
                break;
            case R.id.rb_tabWorkManager:
                selectTab(1);
                break;
            case R.id.rb_tabCheckCrop:
                selectTab(2);
                break;
            case R.id.rb_tabMy:
                selectTab(3);
                break;
        }
    }

    //tab导航选择
    private void selectTab(int index){
        showTitleBarWhiteRight(false);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        resetView(transaction);
        switch (index){
            case 0:
                setTitle("禾美网");
                rb_tabIndex.setTextColor(this.getResources().getColor(R.color.titleBackgroundColor));
                if(tabIndexFragment == null){
                    tabIndexFragment = new TabIndexFragment();
                    transaction.add(R.id.fLayout_mainContent,tabIndexFragment);
                }else{
                    transaction.show(tabIndexFragment);
                }
                break;
            case 1:
                setTitle("工作管理");
                rb_tabWorkManager.setTextColor(this.getResources().getColor(R.color.titleBackgroundColor));
                if (tabWorkManagerFragment == null){
                    tabWorkManagerFragment = new TabWorkManagerFragment();
                    transaction.add(R.id.fLayout_mainContent,tabWorkManagerFragment);
                }else{
                    transaction.show(tabWorkManagerFragment);
                }
                break;
            case 2:
                setTitle("作物检测");
                showTitleBarWhiteRight(true);
                rb_tabCheckCrop.setTextColor(this.getResources().getColor(R.color.titleBackgroundColor));
                if (tabCheckCropFragment == null){
                    tabCheckCropFragment = new TabCheckCropFragment();
                    transaction.add(R.id.fLayout_mainContent,tabCheckCropFragment);
                }else{
                    transaction.show(tabCheckCropFragment);
                }
                break;
            case  3:
                setTitle("个人中心");
                rb_tabMy.setTextColor(this.getResources().getColor(R.color.titleBackgroundColor));
                if (tabMyFragment == null){
                    tabMyFragment = new TabMyFragment();
                    transaction.add(R.id.fLayout_mainContent,tabMyFragment);
                }else{
                    transaction.show(tabMyFragment);
                }
                break;
        }
        transaction.commit();
    }

    //重置View显示样式 及 隐藏所有的Fragment
    private void resetView(FragmentTransaction transaction){
        rb_tabIndex.setTextColor(this.getResources().getColor(R.color.tabNormalColor));
        rb_tabWorkManager.setTextColor(this.getResources().getColor(R.color.tabNormalColor));
        rb_tabCheckCrop.setTextColor(this.getResources().getColor(R.color.tabNormalColor));
        rb_tabMy.setTextColor(this.getResources().getColor(R.color.tabNormalColor));

        if(tabIndexFragment != null){
            transaction.hide(tabIndexFragment);
        }
        if(tabWorkManagerFragment != null){
            transaction.hide(tabWorkManagerFragment);
        }

        if (tabCheckCropFragment != null){
            transaction.hide(tabCheckCropFragment);
        }

        if (tabMyFragment != null){
            transaction.hide(tabMyFragment);
        }
    }


}
