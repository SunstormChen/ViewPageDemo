package com.csy.viewpagedemo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private List<View> list;
    private TextView tv1,tv2,tv3;
    private TextView[] textViews;
    private int[] layouts = {R.layout.tab_layout_1,R.layout.tab_layout_2,R.layout.tab_layout_3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        viewPager = (ViewPager) findViewById(R.id.id_viewTab);
        tv1 = (TextView) findViewById(R.id.id_inland);
        tv2 = (TextView) findViewById(R.id.id_internation);
        tv3 = (TextView) findViewById(R.id.id_social);
        tv1.setTextSize(40);
        list = new ArrayList<>();
        for (int i = 0;i<layouts.length;i++){
            View view = getLayoutInflater().inflate(layouts[i],null);
            list.add(view);
        }
        textViews = new TextView[3];
        textViews[0] = tv1;
        textViews[1] = tv2;
        textViews[2] = tv3;
        tv1.setTextSize(40);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(list);
        viewPager.setAdapter(viewPagerAdapter);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTextSize();
                textViews[position].setTextSize(40);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void onClick(View view){
        setTextSize();
        switch (view.getId()){
            case R.id.id_inland:
                viewPager.setCurrentItem(0);
                tv1.setTextSize(40);
                break;
            case R.id.id_internation:
                viewPager.setCurrentItem(1);
                tv2.setTextSize(40);
                break;
            case R.id.id_social:
                viewPager.setCurrentItem(2);
                tv3.setTextSize(40);
                break;
            default:
                break;
        }
    }
    public void setTextSize(){
        for(int i = 0 ; i < textViews.length ; i ++){
            textViews[i].setTextSize(20);
        }
    }
}

