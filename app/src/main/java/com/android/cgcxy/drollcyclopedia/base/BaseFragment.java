package com.android.cgcxy.drollcyclopedia.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chuangguo.qi on 2017/7/10.
 */

public abstract class BaseFragment extends Fragment {

    private View mMainView;
    protected BaseActivity mActivity;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity= (BaseActivity) activity;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mMainView = inflater.inflate(getLayoutId(), container, false);
        return mMainView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        onAfterActivityCreated();
    }

    protected <T extends View> T findViewById(int id){

        if(mMainView!=null){
            return (T)mMainView.findViewById(id);
        }
        return null;
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void onAfterActivityCreated();

    @Override
    public void onStop() {
        super.onStop();
        MyApplication.getHttpQueue().cancelAll("volleyget");
    }
}
