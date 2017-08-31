package com.android.cgcxy.drollcyclopedia.Choiceness.entity;

import com.android.cgcxy.drollcyclopedia.base.BaseEntity;
import com.android.cgcxy.drollcyclopedia.tools.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 26092 on 2017/7/13.
 * 精选
 */

public class ChoicenessEntity extends BaseEntity {

    //昵称
    public String user_name;
    //头像
    public String avatar;
    //标题
    public String title;
    //评论总条数
    public String comment_total;
    //讨厌
    public String dislike_start;
    //喜欢
    public String like_start;

    // 图片
    public List<Map<String, String>> mediaDataMap = new ArrayList<>();
    public String resolution;
    public String origin_pic_url;
    ;

    public String _id;//id
    public String author;//作者
    public String message;//消息
    public String like;//赞

    public String _avatar;//头像
    public String post_title;//标题

    @Override
    public void initWithJson(JSONObject jsonObject) {
        user_name = Utils.optString(jsonObject, "user_name", "");
        avatar = Utils.optString(jsonObject, "avatar", "");
        title = Utils.optString(jsonObject, "title", "");
        comment_total = Utils.optString(jsonObject, "comment_total", "");
        dislike_start = Utils.optString(jsonObject, "dislike_start", "");
        like_start = Utils.optString(jsonObject, "like_start", "");

        //神评论
        JSONObject dataObject1 = optJSONObject(jsonObject, "hot_comment");
        if (null != dataObject1) {
            _id = Utils.optString(dataObject1, "_id", "");
            author = Utils.optString(dataObject1, "author", "");
            message = Utils.optString(dataObject1, "message", "");
            like = Utils.optString(dataObject1, "like", "");
            JSONObject dataObject2 = optJSONObject(jsonObject, "extra");
            if (null != dataObject1) {
                _avatar = Utils.optString(dataObject1, "avatar", "");
                post_title = Utils.optString(dataObject1, "post_title", "");
            }
        }
        //图片
        JSONArray media_data = optJSONArray(jsonObject, "media_data");
        if (null != media_data) {
            for (int i = 0; i < media_data.length(); i++) {
                Map<String, String> map = new HashMap<>();
                map.put("wifi_img_url", Utils.optString(optJSONObject(media_data, i), "wifi_img_url", ""));
                map.put("mobile_img_url", Utils.optString(optJSONObject(media_data, i), "mobile_img_url", ""));
                map.put("is_origin", Utils.optString(optJSONObject(media_data, i), "is_origin", ""));
                map.put("format", Utils.optString(optJSONObject(media_data, i), "format", ""));
                map.put("share_img_url", Utils.optString(optJSONObject(media_data, i), "share_img_url", ""));

                JSONObject origin_img_url = optJSONObject(optJSONObject(media_data, i), "origin_img_url");
                origin_pic_url = Utils.optString(origin_img_url, "origin_pic_url", "");
                resolution = Utils.optString(origin_img_url, "resolution", "");

                mediaDataMap.add(map);
            }
        }
    }

}
