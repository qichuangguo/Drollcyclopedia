package com.android.cgcxy.drollcyclopedia.base;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    public abstract void initWithJson(JSONObject jsonObject);

    // 解析单个对象
    public JSONObject optJSONObject(JSONObject jsonObject, String key){
        try {
            return jsonObject.optJSONObject(key);
        }catch (Exception e){
            return null;
        }
    }

    // 从数组中解析对象
    public JSONObject optJSONObject(JSONArray jsonArray, int index){
        try {
            return jsonArray.optJSONObject(index);
        }catch (Exception e){
            return null;
        }
    }

    // 从对象中解析数组
    public JSONArray optJSONArray(JSONObject jsonObject, String key){
        try {
            return jsonObject.optJSONArray(key);
        }catch (Exception e){
            return null;
        }
    }
}
