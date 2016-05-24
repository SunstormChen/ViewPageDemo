package com.csy.viewpagedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class LinkPageActivity extends AppCompatActivity {
    private ViewPager viewPager;

    private List<View>list;

    private int[] resId = {R.drawable.l1,R.drawable.l2,R.drawable.l3,R.drawable.l4};
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);
//        iv = (ImageView) findViewById(R.id.iv);
        btn = (Button) findViewById(R.id.id_button);
        initData();
        initView();
       ViewPagerAdapter adapter = new ViewPagerAdapter(list);
        // 设置适配器
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == resId.length - 1) {
                    btn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = LinkPageActivity.this.getSharedPreferences("guide_flag", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("state",true);
                editor.commit();
                finish();
            }
        });
    }


    private void initData() {
        list = new ArrayList<>();
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i = 0;i<resId.length;i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(resId[i]);
            iv.setLayoutParams(lp);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            list.add(iv);
        }
    }


    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.id_viewPager);
    }


}
