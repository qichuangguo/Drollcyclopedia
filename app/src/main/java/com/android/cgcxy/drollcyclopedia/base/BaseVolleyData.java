package com.android.cgcxy.drollcyclopedia.base;

import android.util.Log;

import com.android.cgcxy.drollcyclopedia.base.MyApplication;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;


/**
 * Created by 26092 on 2017/7/13.
 *
 */

public class BaseVolleyData
{
    public static JSONObject getJSONObject(String url, final VolleyJsonCallback callback){

        JsonObjectRequest jObjRequest = new JsonObjectRequest(Request.Method.GET,url, null,
                new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject result) {
                        callback.onSuccess(result);
                        Log.i("jiaojiao", "get请求成功" + result.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError arg0) {
                Log.i("jiaojiao", "get请求失败" + arg0.toString());
            }
        });
        jObjRequest.setTag("volleyget");
        MyApplication.getHttpQueue().add(jObjRequest);
        return null;
    }

    public interface VolleyJsonCallback{
        void onSuccess(JSONObject result);
    }

}
