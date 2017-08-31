package com.android.cgcxy.drollcyclopedia.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.cgcxy.drollcyclopedia.R;

/**
 * Created by chuangguo.qi on 2017/7/10.
 */

public abstract class BaseActivity extends FragmentActivity {
    // 提示信息
    private Toast toast = null;
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
    // 提示信息
    public void showToast(CharSequence str) {
        if (null != toast) {
            toast.cancel();
            toast = null;
        }
        View view = LayoutInflater.from(this).inflate(R.layout.my_toast_view, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_toast_view);
        textView.setText(str);
        toast = new Toast(this);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        //TostDialog.showTost(this,str);
    }
}
