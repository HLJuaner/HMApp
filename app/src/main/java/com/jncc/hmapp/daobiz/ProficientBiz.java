package com.jncc.hmapp.daobiz;

import android.content.Context;

import com.jncc.hmapp.dao.IProficient;
import com.jncc.hmapp.daoimpl.ProficientImpl;

/**
 * Created by h_vk on 16/4/19.
 */
public class ProficientBiz {

    private static final IProficient iProficient = new ProficientImpl();

    public static String Test(Context context){

        return  iProficient.getProficientList(context,"http://v.juhe.cn/football/coach_info?league_id=128&team_id=3148&key=4205ee8dc320653566e8ebbd857fc7bc");
    }
}
