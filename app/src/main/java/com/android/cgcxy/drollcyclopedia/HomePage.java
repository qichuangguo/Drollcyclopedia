package com.android.cgcxy.drollcyclopedia;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;

import com.android.cgcxy.drollcyclopedia.adapter.ViewPagerFragmentAdapter;
import com.android.cgcxy.drollcyclopedia.base.BaseActivity;
import com.android.cgcxy.drollcyclopedia.base.BaseFragment;
import com.android.cgcxy.drollcyclopedia.fragments.ChoicenessFragment;
import com.android.cgcxy.drollcyclopedia.fragments.CrosstalkFragment;
import com.android.cgcxy.drollcyclopedia.fragments.DiscoverFragment;
import com.android.cgcxy.drollcyclopedia.fragments.RailleryFragment;
import com.android.cgcxy.drollcyclopedia.fragments.VideoFragment;

import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseActivity {


    private ViewPager viewPager;
    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private ViewPagerFragmentAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_page;
    }

    @Override
    protected void onAfterActivityCreate() {
        initFragment();
        initView();
    }

    private void initFragment() {

        ChoicenessFragment choicenessFragment = new ChoicenessFragment();
        CrosstalkFragment crosstalkFragment = new CrosstalkFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        RailleryFragment raillerfFragment = new RailleryFragment();
        VideoFragment videoFragment = new VideoFragment();

        mFragmentList.add(choicenessFragment);
        mFragmentList.add(videoFragment);
        mFragmentList.add(crosstalkFragment);
        mFragmentList.add(discoverFragment);
        mFragmentList.add(raillerfFragment);

        adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(),mFragmentList);


    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

    }
}
