package com.android.cgcxy.drollcyclopedia.Choiceness.entity;

import com.android.cgcxy.drollcyclopedia.base.BaseEntity;
import com.android.cgcxy.drollcyclopedia.tools.Utils;

import org.json.JSONObject;

/**
 * Created by 26092 on 2017/7/13.
 * 精选
 */

public class ChoicenessEntity  extends BaseEntity{

    /**
     *  {
     "user_name":"爱说话的猕猴桃",
     "dislike_start":6,
     "_created_at":"2017-07-10T20:11:19.000+0800",
     "avatar":"http://image.uc.cn/s/uae/g/0q/avatar/4.png",
     "title":"这顿饭算是毁了···",
     "hot_comment":{
     "_id":"51421768",
     "author":"逝の水",
     "message":"既然我得不到，那就毁掉吧",
     "like":182,
     "dislike":0,
     "extra":Object{...}
     },
     "is_hot":true,
     "_updated_at":"2017-07-11T11:20:13.000+0800",
     "_incrs":{
     "fb_kanguo":1,
     "fb_other":1,
     "like":2056,
     "dislike":303,
     "fb_wuliao":2,
     "share":166,
     "fb_seqing":2
     },
     "_pos":1499696709452,
     "comment_total":45,
     "tag":"图文",
     "_id":"fdb45a9105db82f9f82abab72957c705",
     "like_start":32,
     "media_data":[
     {
     "wifi_img_url":"http://image.uc.cn/n/nav/17/981f6c866bce5d03aecff293ef35d4a3f.jpeg",
     "mobile_img_url":"http://image.uc.cn/n/nav/17/aa8821c79cf4bf019e14355c11b240b9f.jpeg",
     "is_origin":1,
     "format":"GIF",
     "share_img_url":"http://image.uc.cn/n/nav/17/49b5d509b699285003052646771ae7a8f.jpeg",
     "origin_img_url":{
     "origin_pic_url":"http://image.uc.cn/s/nav/g/qiqu/2015/110f62dbbc2ca3963997798e0eae05b1x220x361x1877.gif",
     "resolution":"220x361"
     }
     }
     ]
     },
     */
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

    public String _id;//id
    public String author;//作者
    public String message;//消息

    public String _avatar;//头像
    public String post_title;//标题

    @Override
    public void initWithJson(JSONObject jsonObject) {
        user_name= Utils.optString(jsonObject,"user_name","");
        avatar= Utils.optString(jsonObject,"avatar","");
        title= Utils.optString(jsonObject,"title","");
        comment_total= Utils.optString(jsonObject,"comment_total","");
        dislike_start= Utils.optString(jsonObject,"dislike_start","");
        like_start= Utils.optString(jsonObject,"like_start","");

        JSONObject dataObject1 = optJSONObject(jsonObject, "hot_comment");
        if (null != dataObject1) {
            _id = Utils.optString(dataObject1, "_id", "");


            JSONObject dataObject2 = optJSONObject(jsonObject, "extra");
            if (null != dataObject1) {
                _avatar = Utils.optString(dataObject1, "avatar", "");
                post_title = Utils.optString(dataObject1, "post_title", "");

            }
        }
    }

}
