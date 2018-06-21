package com.example.gc.endclasswork.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

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

public class Activity_three extends Activity implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {
    //定义需要加载的图片集合
    private List<Integer> imageList = new ArrayList<Integer>(5);
    private RecyclerView recyclerView;

    private SwipeRefreshLayout swp;
    private Handler mHandler;

    private LinearLayout pager03_left01;
    private LinearLayout pager03_left02;
    private LinearLayout pager03_left03;
    private LinearLayout pager03_left04;
    private LinearLayout pager03_left05;
    private LinearLayout pager03_left06;
    private LinearLayout pager03_left07;
    private LinearLayout pager03_left08;
    private LinearLayout pager03_left09;
    private LinearLayout pager03_left10;
    private LinearLayout pager03_left11;
    private LinearLayout pager03_left12;
    private LinearLayout pager03_left13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager03);
        mHandler = new Handler();
        swp = (SwipeRefreshLayout) findViewById(R.id.swp);
        swp.setOnRefreshListener(this);
        init();
        initRecycle();
    }
    public void init(){
        pager03_left01 = (LinearLayout)findViewById(R.id.pager03_left01);
        pager03_left02 = (LinearLayout)findViewById(R.id.pager03_left02);
        pager03_left03 = (LinearLayout)findViewById(R.id.pager03_left03);
        pager03_left04 = (LinearLayout)findViewById(R.id.pager03_left04);
        pager03_left05 = (LinearLayout)findViewById(R.id.pager03_left05);
        pager03_left06 = (LinearLayout)findViewById(R.id.pager03_left06);
        pager03_left07 = (LinearLayout)findViewById(R.id.pager03_left07);
        pager03_left08 = (LinearLayout)findViewById(R.id.pager03_left08);
        pager03_left09 = (LinearLayout)findViewById(R.id.pager03_left09);
        pager03_left10 = (LinearLayout)findViewById(R.id.pager03_left10);
        pager03_left11 = (LinearLayout)findViewById(R.id.pager03_left11);
        pager03_left12 = (LinearLayout)findViewById(R.id.pager03_left12);
        pager03_left13 = (LinearLayout)findViewById(R.id.pager03_left13);
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
    //按钮事件
    public void onClick(View v) {
        restart();
        switch (v.getId()){
            case R.id.pager03_btn01:
                pager03_left01.setBackgroundColor(Color.WHITE);
                break;
            case R.id.pager03_btn02:
                pager03_left02.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn03:
                pager03_left03.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn04:
                pager03_left04.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn05:
                pager03_left05.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn06:
                pager03_left06.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn07:
                pager03_left07.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn08:
                pager03_left08.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn09:
                pager03_left09.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn10:
                pager03_left10.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn11:
                pager03_left11.setBackgroundColor(Color.WHITE);
                break;
            case R.id.pager03_btn12:
                pager03_left12.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager03_btn13:
                pager03_left13.setBackgroundColor(Color.WHITE);
                Toast.makeText(this, "暂无更多信息！\n敬请期待更新！", Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }

    private void restart() {
        pager03_left01.setBackgroundColor(0xffedecec);
        pager03_left02.setBackgroundColor(0xffedecec);
        pager03_left03.setBackgroundColor(0xffedecec);
        pager03_left04.setBackgroundColor(0xffedecec);
        pager03_left05.setBackgroundColor(0xffedecec);
        pager03_left06.setBackgroundColor(0xffedecec);
        pager03_left07.setBackgroundColor(0xffedecec);
        pager03_left08.setBackgroundColor(0xffedecec);
        pager03_left09.setBackgroundColor(0xffedecec);
        pager03_left10.setBackgroundColor(0xffedecec);
        pager03_left11.setBackgroundColor(0xffedecec);
        pager03_left12.setBackgroundColor(0xffedecec);
        pager03_left13.setBackgroundColor(0xffedecec);
    }
}