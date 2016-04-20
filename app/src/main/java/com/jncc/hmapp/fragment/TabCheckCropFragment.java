package com.jncc.hmapp.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonObject;
import com.jncc.hmapp.BaseFragment;
import com.jncc.hmapp.HMApplication;
import com.jncc.hmapp.R;
import com.jncc.hmapp.activity.ProficientActivity;
import com.jncc.hmapp.utils.LogUtil;
import com.jncc.hmapp.utils.ToastUtil;
import com.jncc.hmapp.utils.VolleyRequestUtil;

import org.json.JSONObject;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.Map;

public class TabCheckCropFragment extends BaseFragment  implements RadioGroup.OnCheckedChangeListener {


    @ViewInject(R.id.rg_checkCropByTab)
    private RadioGroup rg_checkCropByTab;

    @ViewInject(R.id.rb_checkCropByQuestion)
    private RadioButton rb_checkCropByQuestion;

    private ImageButton ibOptions;

    private Fragment checkCropByQuestionFragment,checkCropByCheckFragment;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tab_check_crop;
    }

    @Override
    public void initData() {
        rb_checkCropByQuestion.setChecked(true);
        rg_checkCropByTab.setOnCheckedChangeListener(this);
        setTitleBarWhiteRight(addImageButtonOptions(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        selectTab(0);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_checkCropByQuestion:
                selectTab(0);
                break;
            case R.id.rb_checkCropByCheck:
                selectTab(1);
                break;
        }
    }

    //重置View显示样式 及 隐藏所有的Fragment
    private void resetView(FragmentTransaction transaction){
        if(checkCropByQuestionFragment != null){
            transaction.hide(checkCropByQuestionFragment);
        }
        if (checkCropByCheckFragment !=null){
            transaction.hide(checkCropByCheckFragment);
        }
    }

    private void selectTab(int index){
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        resetView(transaction);
        switch (index){
            case 0:
                ibOptions.setVisibility(View.GONE);
                if(checkCropByQuestionFragment == null){
                    checkCropByQuestionFragment = new CheckCropByQuestionFragment();
                    transaction.add(R.id.frame_content,checkCropByQuestionFragment);
                }else{
                    transaction.show(checkCropByQuestionFragment);
                }
                break;
            case 1:
                ibOptions.setVisibility(View.VISIBLE);
                if(checkCropByCheckFragment == null){
                    checkCropByCheckFragment = new CheckCropByCheckFragment();
                    transaction.add(R.id.frame_content,checkCropByCheckFragment);
                }else{
                    transaction.show(checkCropByCheckFragment);
                }
                break;
        }
        transaction.commit();
    }

    private ImageButton addImageButtonOptions(){
        if (ibOptions == null) {
            ibOptions = new ImageButton(getContext());
            ibOptions.setBackground(getContext().getResources().getDrawable(R.mipmap.ic_screening));
        }
       return ibOptions;
    }

    @Event(value = {R.id.tv_proficient})
    private  void onClick(View view){
        switch (view.getId()){
            case R.id.tv_proficient:

                break;

        }
    }
}
