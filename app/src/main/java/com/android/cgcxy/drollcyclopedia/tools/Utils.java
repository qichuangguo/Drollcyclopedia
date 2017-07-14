package com.android.cgcxy.drollcyclopedia.tools;

import android.text.TextUtils;

import org.json.JSONObject;

/**
 * Created by 26092 on 2017/7/13.
 */

public class Utils {
    public static String optString(JSONObject jsonObject, String key,
                                   String defaultValue) {
        String value = defaultValue;
        try {
            if (null != jsonObject) {
                value = jsonObject.optString(key);
                if (Utils.isEmpty(value)) {
                    value = defaultValue;
                }
            }
        } catch (Exception e) {
            value = defaultValue;
        }
        if ("null".equals(value)) {
            value = defaultValue;
        }
        return value;
    }
    // 判断字符串是否为空
    public static boolean isEmpty(String str) {
        if (null == str || TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            return true;
        }
        return false;
    }
}
