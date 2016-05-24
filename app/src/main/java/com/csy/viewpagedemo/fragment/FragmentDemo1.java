package com.csy.viewpagedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csy.viewpagedemo.R;

/**
 * created dpb on 16/5/3.
 * <p/>
 * e_mail  dengpbs@163.com.
 */
public class FragmentDemo1  extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_layout_1,container,false);
    }
}
