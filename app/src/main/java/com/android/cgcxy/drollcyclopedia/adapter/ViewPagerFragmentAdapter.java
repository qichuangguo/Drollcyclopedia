package com.android.cgcxy.drollcyclopedia.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.cgcxy.drollcyclopedia.base.BaseFragment;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/10.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> listDatas;
    public ViewPagerFragmentAdapter(FragmentManager fm,  List<Fragment> list) {
        super(fm);
        listDatas=list;
    }

    @Override
    public Fragment getItem(int position) {
        return listDatas.get(position);
    }

    @Override
    public int getCount() {
        return listDatas.size();
    }
}
