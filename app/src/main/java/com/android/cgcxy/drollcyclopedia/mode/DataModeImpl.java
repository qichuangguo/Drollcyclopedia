package com.android.cgcxy.drollcyclopedia.mode;

import android.content.Context;
import android.util.Log;

import com.android.cgcxy.drollcyclopedia.bean.CrosstalkBean;
import com.android.cgcxy.drollcyclopedia.bean.CrosstalkTimeBean;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/12.
 */

public class DataModeImpl implements DataMode {

    private  RequestQueue requestQueue;
    private String TAG="DataModeImpl";

    public DataModeImpl(Context context){
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void getCrosstalkTimeJsonData(String url, final RefreshListener refresh) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {

                    JSONArray data = jsonObject.getJSONArray("data");
                    Gson gson = new Gson();
                    List<CrosstalkTimeBean> datas = new ArrayList<>();
                    for (int i = 0; i <data.length() ; i++) {
                        CrosstalkTimeBean crosstalkTimeBean = gson.fromJson(data.get(i).toString(),CrosstalkTimeBean.class);
                        datas.add(crosstalkTimeBean);
                    }
                    refresh.resultListener(datas);

                } catch (JSONException e) {

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void getCrosstalkValidJsonData(final String url, final RefreshListener ref) {

        JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                System.out.println("=====url===="+url);
                Gson gson = new Gson();
                try {
                    JSONArray data = jsonObject.getJSONArray("data");
                    List<CrosstalkBean> datas = new ArrayList<>();
                    for (int i = 0; i < data.length(); i++) {
                        CrosstalkBean CrosstalkBean = gson.fromJson(data.get(i).toString(), CrosstalkBean.class);
                        datas.add(CrosstalkBean);
                    }

                    ref.resultListener(datas);
                    for (int i = 0; i <datas.size() ; i++) {

                        Log.i(TAG, "onResponse: "+datas.get(i));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ref.onError(volleyError);
            }
        });

        requestQueue.add(jsonObject);
    }


}
