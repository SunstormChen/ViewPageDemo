package com.csy.viewpagedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.csy.viewpagedemo.fragment.FragmentDemo1;
import com.csy.viewpagedemo.fragment.FragmentDemo2;
import com.csy.viewpagedemo.fragment.FragmentDemo3;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager+Fragment
 */
public class FragmentViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_view_pager);
        mViewPager = (ViewPager) findViewById(R.id.fragment_viewPager);
        fragments = new ArrayList<>();
        // 准备数据源
        fragments.add(new FragmentDemo1());
        fragments.add(new FragmentDemo2());
        fragments.add(new FragmentDemo3());
        fragments.add(new FragmentDemo1());
        fragments.add(new FragmentDemo2());
        fragments.add(new FragmentDemo3());
        // 选择适配器
        //MyFragmentPagerAdapter adapter  = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        MyFragmentStatePagerAdapter adapter  = new MyFragmentStatePagerAdapter(getSupportFragmentManager(),fragments);
        // 设置适配器
        mViewPager.setAdapter(adapter);
    }
}
