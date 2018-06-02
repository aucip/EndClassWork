package com.example.gc.endclasswork.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.example.gc.endclasswork.R;
import com.example.gc.endclasswork.recycle.BannerAdapter;
import com.example.gc.endclasswork.recycle.BannerIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 龚 聪 on 2018/6/2.
 */


public class Activity_three extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    //定义需要加载的图片集合
    private List<Integer> imageList = new ArrayList<Integer>(5);
    private RecyclerView recyclerView;

    private SwipeRefreshLayout swp;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager03);
        mHandler = new Handler();
        swp = (SwipeRefreshLayout) findViewById(R.id.swp);
        swp.setOnRefreshListener(this);
        initRecycle();
    }

    private void initRecycle() {
        //初始化图片
        imageList.add(R.drawable.pager_three_01);
        imageList.add(R.mipmap.lunbo2_1);
        imageList.add(R.mipmap.lunbo2_2);
        imageList.add(R.mipmap.lunbo2_3);
        imageList.add(R.mipmap.lunbo2_4);
        imageList.add(R.mipmap.lunbo2_5);

        final BannerAdapter bannerAdapter = new BannerAdapter(this, imageList);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(bannerAdapter);
        recyclerView.scrollToPosition(imageList.size() * 10);
        //一页一页滑动
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        final BannerIndicator bannerIndicator = (BannerIndicator)findViewById(R.id.indicator);
        bannerIndicator.setNumber(imageList.size());
        //监听当前滑动状态
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if( newState == RecyclerView.SCROLL_STATE_IDLE){
                    int i = layoutManager.findFirstVisibleItemPosition() % imageList.size();
                    bannerIndicator.setPosition(i);
                }
            }
        });

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                recyclerView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition() + 1);
            }
        }, 3000, 3000, TimeUnit.MILLISECONDS);

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
}