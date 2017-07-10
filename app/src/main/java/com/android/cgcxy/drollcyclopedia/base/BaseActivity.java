package com.android.cgcxy.drollcyclopedia.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by chuangguo.qi on 2017/7/10.
 */

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        onAfterActivityCreate();
    }
    protected abstract void initView();
    protected abstract int getLayoutId();
    protected abstract void onAfterActivityCreate();

    /**
     * 添加fragment
     * @param id
     * @param fragment
     * @param tag
     * @param keep
     */
    public void commitFragment(int id, Fragment fragment, String tag,
                               boolean keep) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(id, fragment);
        if (keep) {
            transaction.addToBackStack(tag);
        } else {
            transaction.disallowAddToBackStack();
        }
        transaction.commitAllowingStateLoss();
    }

    public void commitFragment(int id, Fragment fragment, boolean keep){
        commitFragment(id,fragment,null,keep);
    }

}
