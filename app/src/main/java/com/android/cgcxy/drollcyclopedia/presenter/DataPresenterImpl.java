package com.android.cgcxy.drollcyclopedia.presenter;

import android.content.Context;

import com.android.cgcxy.drollcyclopedia.base.Constant;
import com.android.cgcxy.drollcyclopedia.bean.CrosstalkBean;
import com.android.cgcxy.drollcyclopedia.bean.CrosstalkTimeBean;
import com.android.cgcxy.drollcyclopedia.fragments.CrosstalkFragment;
import com.android.cgcxy.drollcyclopedia.fragments.ShowView;
import com.android.cgcxy.drollcyclopedia.mode.DataModeImpl;
import com.android.cgcxy.drollcyclopedia.mode.RefreshListener;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/12.
 */

public class DataPresenterImpl{

    private ShowView showView;
    private final DataModeImpl dataMode;
    private List<CrosstalkTimeBean> crosstalkTimeBeen;
    private List<CrosstalkBean> crosstalkBeen;

    public DataPresenterImpl(ShowView showView,Context context){
        this.showView =showView;
        dataMode = new DataModeImpl(context);
    }

    public void getCrosstalkTimeJsonData(String url){

        dataMode.getCrosstalkTimeJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                DataPresenterImpl.this.crosstalkTimeBeen =((List<CrosstalkTimeBean>)t);
                String pos = crosstalkTimeBeen.get(0).get_pos();
                Constant.replace=pos;
                dataMode.getCrosstalkValidJsonData(Constant.CROSSTALKTIMEDETAILSBEFORE+pos+Constant.CROSSTALKTIMEDETAILSBEFOREQUEEN, new RefreshListener() {
                    @Override
                    public <T> void resultListener(T t) {
                        DataPresenterImpl.this.crosstalkBeen=((List<CrosstalkBean>) t);
                        showView.setData(crosstalkBeen);
                    }

                    @Override
                    public <E> void onError(E e) {

                    }
                });
            }

            @Override
            public <E> void onError(E e) {
                ((VolleyError)e).getNetworkTimeMs();
            }


        });
    }
}
