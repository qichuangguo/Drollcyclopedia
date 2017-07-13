package com.android.cgcxy.drollcyclopedia.bean;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/12.
 */

public class CrosstalkBean {


    /**
     * user_name : 安静的小狗
     * dislike_start : 4
     * _created_at : 2017-07-13T09:11:01.000+0800
     * avatar : http://image.uc.cn/s/uae/g/0q/avatar/20.png
     * content : 请问一下各位奇友如果你的女朋友和你兄弟上床了你会怎么做。。。
     * hot_comment : {"_id":0}
     * _updated_at : 2017-07-13T09:50:13.000+0800
     * _incrs : {"share":2,"like":9,"dislike":13,"fb_wuliao":1}
     * _pos : 1499908506821
     * comment_total : 12
     * tag : 段子
     * _id : cb561573b361816e7395a4a1fdfcb012
     * like_start : 23
     * media_data : []
     */

    private String user_name;
    private int dislike_start;
    private String _created_at;
    private String avatar;
    private String content;
    private HotCommentBean hot_comment;
    private String _updated_at;
    private IncrsBean _incrs;
    private long _pos;
    private int comment_total;
    private String tag;
    private String _id;
    private int like_start;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getDislike_start() {
        return dislike_start;
    }

    public void setDislike_start(int dislike_start) {
        this.dislike_start = dislike_start;
    }

    public String get_created_at() {
        return _created_at;
    }

    public void set_created_at(String _created_at) {
        this._created_at = _created_at;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HotCommentBean getHot_comment() {
        return hot_comment;
    }

    public void setHot_comment(HotCommentBean hot_comment) {
        this.hot_comment = hot_comment;
    }

    public String get_updated_at() {
        return _updated_at;
    }

    public void set_updated_at(String _updated_at) {
        this._updated_at = _updated_at;
    }

    public IncrsBean get_incrs() {
        return _incrs;
    }

    public void set_incrs(IncrsBean _incrs) {
        this._incrs = _incrs;
    }

    public long get_pos() {
        return _pos;
    }

    public void set_pos(long _pos) {
        this._pos = _pos;
    }

    public int getComment_total() {
        return comment_total;
    }

    public void setComment_total(int comment_total) {
        this.comment_total = comment_total;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getLike_start() {
        return like_start;
    }

    public void setLike_start(int like_start) {
        this.like_start = like_start;
    }


    public static class HotCommentBean {
        /**
         * _id : 0
         */

        private int _id;

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }
    }

    public static class IncrsBean {
        /**
         * share : 2
         * like : 9
         * dislike : 13
         * fb_wuliao : 1
         */

        private int share;
        private int like;
        private int dislike;
        private int fb_wuliao;

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getDislike() {
            return dislike;
        }

        public void setDislike(int dislike) {
            this.dislike = dislike;
        }

        public int getFb_wuliao() {
            return fb_wuliao;
        }

        public void setFb_wuliao(int fb_wuliao) {
            this.fb_wuliao = fb_wuliao;
        }
    }

    @Override
    public String toString() {
        return "CrosstalkBean{" +
                "user_name='" + user_name + '\'' +
                ", dislike_start=" + dislike_start +
                ", _created_at='" + _created_at + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", hot_comment=" + hot_comment +
                ", _updated_at='" + _updated_at + '\'' +
                ", _incrs=" + _incrs +
                ", _pos=" + _pos +
                ", comment_total=" + comment_total +
                ", tag='" + tag + '\'' +
                ", _id='" + _id + '\'' +
                ", like_start=" + like_start +
                '}';
    }
}
