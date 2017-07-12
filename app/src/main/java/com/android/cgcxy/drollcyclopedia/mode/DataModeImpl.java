package com.android.cgcxy.drollcyclopedia.mode;

import android.content.Context;

import com.android.cgcxy.drollcyclopedia.bean.CrosstalkTimeBean;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/12.
 */

public class DataModeImpl implements DataMode {

    private  RequestQueue requestQueue;

    public DataModeImpl(Context context){
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void getJsonData(String url) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                try {

                    JSONArray data = jsonObject.getJSONArray("data");
                    Gson gson = new Gson();
                    CrosstalkTimeBean crosstalkTimeBean = gson.fromJson(data.get(0).toString(),CrosstalkTimeBean.class);

                } catch (JSONException e) {

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("=====volleyError====="+volleyError.networkResponse.toString());
            }
        });

        requestQueue.add(jsonObjectRequest);
    }



}
