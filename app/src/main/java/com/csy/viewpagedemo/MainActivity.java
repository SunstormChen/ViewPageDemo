package com.csy.viewpagedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isGuide()){
            Intent intent = new Intent(this,LinkPageActivity.class);
            startActivity(intent);
        }
    }
    public Boolean isGuide(){
        SharedPreferences sp = MainActivity.this.getSharedPreferences("guide_flag",MODE_PRIVATE);
        return  sp.getBoolean("state",false);
    }
    public void fun1(View view){
        Intent intent = new Intent(this,ViewPageActivity.class);
        startActivity(intent);
    }

    public void fun2(View view){
        Intent intent = new Intent(this,LinkPageActivity.class);
        startActivity(intent);
    }
    public void fun3(View view){
        Intent intent = new Intent(this,TabActivity.class);
        startActivity(intent);
    }

    public void fun4(View view){
        Intent intent = new Intent(this,FragmentViewPagerActivity.class);
        startActivity(intent);
    }
}
