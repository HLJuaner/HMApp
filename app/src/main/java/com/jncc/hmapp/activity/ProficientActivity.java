package com.jncc.hmapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jncc.hmapp.BaseFragmentActivity;
import com.jncc.hmapp.R;

public class ProficientActivity extends BaseFragmentActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_proficient;
    }

    @Override
    protected void initData() {
        setTitle("农业专家");
        showTitleBarWhiteLeft();
    }
}
