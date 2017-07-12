package com.android.cgcxy.drollcyclopedia.bean;

import android.text.SpannableString;

/**
 * Created by chuangguo.qi on 2017/7/12.
 */

public class CrosstalkTimeBean {

    private String _pos;
    private String _id;

    public String get_pos() {
        return _pos;
    }

    public void set_pos(String _pos) {
        this._pos = _pos;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "CrosstalkTimeBean{" +
                "_pos='" + _pos + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
