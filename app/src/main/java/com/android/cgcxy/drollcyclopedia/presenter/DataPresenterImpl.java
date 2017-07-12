package com.android.cgcxy.drollcyclopedia.presenter;

import android.content.Context;

import com.android.cgcxy.drollcyclopedia.fragments.ShowView;
import com.android.cgcxy.drollcyclopedia.mode.DataModeImpl;

/**
 * Created by chuangguo.qi on 2017/7/12.
 */

public class DataPresenterImpl {

    private ShowView showView;
    private final DataModeImpl dataMode;

    public DataPresenterImpl(ShowView showView,Context context){
        this.showView =showView;
        dataMode = new DataModeImpl(context);
    }

    public void getData(String url){

        dataMode.getJsonData(url);
    }
}
