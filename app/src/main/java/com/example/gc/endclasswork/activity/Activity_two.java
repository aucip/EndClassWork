package com.example.gc.endclasswork.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gc.endclasswork.R;

/**
 * Created by 龚 聪 on 2018/6/2.
 */


public class Activity_two extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout swp;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager02);
        mHandler = new Handler();
        swp = (SwipeRefreshLayout) findViewById(R.id.swp);
        swp.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swp.setRefreshing(false);
            }
        }, 1500);
    }
    public void onClick01(View view){
        Toast.makeText(Activity_two.this, "加入购物车成功", Toast.LENGTH_SHORT).show();
    }
}