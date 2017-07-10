package com.android.cgcxy.drollcyclopedia;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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

public class HomePage extends BaseActivity implements View.OnClickListener {


    private ViewPager viewPager;
    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private ViewPagerFragmentAdapter adapter;
    private LinearLayout linearLayout;

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

        adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), mFragmentList);
    }


    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            linearLayout.getChildAt(i).setOnClickListener(this);
        }

        seleteTextBg(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                seleteTextBg(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void seleteTextBg(int position) {

        for (int i = 0; i < linearLayout.getChildCount(); i++) {

            TextView childAt = (TextView) linearLayout.getChildAt(i);
            if (position == i) {
                childAt.setSelected(true);
                childAt.setTextColor(this.getResources().getColor(R.color.FFCF24));
            } else {
                childAt.setSelected(false);
                childAt.setTextColor(this.getResources().getColor(R.color.black));
            }
        }

    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            int id = linearLayout.getChildAt(i).getId();
            if (id==v.getId()){
                viewPager.setCurrentItem(i);
            }
        }
    }
}
