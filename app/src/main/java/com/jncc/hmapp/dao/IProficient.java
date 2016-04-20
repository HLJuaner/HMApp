package com.jncc.hmapp.dao;

import com.jncc.hmapp.entity.Proficient;

import java.util.List;

/**
 * Created by h_vk on 16/4/19.
 */
public interface IProficient {

    /**
     * 获取专家列表
     *
     * @param requestUrl  提交地址
     */
    List<Proficient> getProficientList(String requestUrl);
}
