package com.csy.viewpagedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * created dpb on 16/5/3.
 * <p/>
 * e_mail  dengpbs@163.com.
 */
public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;

    private FragmentManager fm;

    public MyFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("-------", position + " " + fm.getFragments());
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
