package com.csy.viewpagedemo;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends AppCompatActivity {
    private ViewPager viewPager;

    private List<View> list;
    private ViewPagerAdapter adapter;
    private int[] resId = {R.drawable.b01, R.drawable.b02, R.drawable.b03, R.drawable.b04};
    //    private int index = 0 ;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    int totalcount = resId.length;//autoChangeViewPager.getChildCount();
                    int currentItem = viewPager.getCurrentItem();
                    int toItem = currentItem + 1 == totalcount ? 0 : currentItem + 1;
                    viewPager.setCurrentItem(toItem, true);
                    break;
                default:
                    break;
            }
        }
    };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_viewpage);
//        iv = (ImageView) findViewById(R.id.iv);
            initData();
            initView();
            adapter = new ViewPagerAdapter(list);
            // 设置适配器
            viewPager.setAdapter(adapter);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        handler.sendEmptyMessageDelayed(1, 1000);
                        SystemClock.sleep(1000);
                    }
                }

            }).start();


        }

        private void initData() {
            list = new ArrayList<>();
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            for (int i = 0; i < resId.length; i++) {
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


