package com.jncc.hmapp.daoimpl;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jncc.hmapp.dao.IProficient;
import com.jncc.hmapp.entity.Proficient;
import com.jncc.hmapp.utils.VolleyRequestUtil;

import java.util.List;

/**
 * Created by h_vk on 16/4/19.
 */
public class ProficientImpl implements IProficient {


    @Override
    public String getProficientList(Context context, String requestUrl) {
        //4205ee8dc320653566e8ebbd857fc7bc
        //
        final String[] result = {"fdsfdas"};
        VolleyRequestUtil.requestGet(context, "asd", requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result[0] = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result[0] = error.getMessage();
            }
        });
        return result[0];
    }
}
