package com.jncc.hmapp.utils;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.jncc.hmapp.HMApplication;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by h_vk on 16/4/16.
 */
public class VolleyRequestUtil {


   private static StringRequest stringRequest;

    private static JsonObjectRequest jsonObjectRequest;


    /**
     * StringRequest GET 方式提交
     *
     * @param context
     * @param tag  队列TAG名称
     * @param url  请求地址
     * @param successListener  自定义成功回调
     * @param errorListener  自定义失败回调
     */
    public static void requestGet(Context context, String tag, String url, final Response.Listener<String> successListener,final Response.ErrorListener errorListener){
        HMApplication.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET,url,successListener,errorListener);
        stringRequest.setTag(tag);
        HMApplication.getHttpQueues().add(stringRequest);
        HMApplication.getHttpQueues().start();
    }

    /**
     * StringRequest POST 方式提交
     *
     * @param context
     * @param tag  队列TAG名称
     * @param url  请求地址
     * @param successListener  自定义成功回调
     * @param errorListener  自定义失败回调
     * @param params 提交参数
     */
    public static void requestPost(Context context,String tag,String url, final Response.Listener<String> successListener, final Response.ErrorListener errorListener, final Map<String,String> params){
        HMApplication.getHttpQueues().cancelAll(context);
        stringRequest = new StringRequest(Request.Method.POST,url,successListener,errorListener){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        HMApplication.getHttpQueues().add(stringRequest);
        HMApplication.getHttpQueues().start();
    }


    /**
     * JsonObjectRequest POST 方式提交
     *
     * @param context
     * @param tag  队列TAG名称
     * @param url  请求地址
     * @param successListener  自定义成功回调
     * @param errorListener  自定义失败回调
     * @param params 提交参数
     */
    public static void jsonObjectRequestPost(Context context,String tag,String url, final Response.Listener<JSONObject> successListener, final Response.ErrorListener errorListener,final Map<String,String> params){
        HMApplication.getHttpQueues().cancelAll(tag);
        JSONObject json = new JSONObject(params);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, json,successListener,errorListener);
        stringRequest.setTag(tag);
        HMApplication.getHttpQueues().add(stringRequest);
        HMApplication.getHttpQueues().start();
    }
}
