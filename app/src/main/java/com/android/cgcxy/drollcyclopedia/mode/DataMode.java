package com.android.cgcxy.drollcyclopedia.mode;

import android.content.Context;

/**
 * Created by chuangguo.qi on 2017/7/12.
 */

public interface DataMode {

    void getCrosstalkTimeJsonData(String url,RefreshListener ref);
    void getCrosstalkValidJsonData(String url,RefreshListener ref);
}
