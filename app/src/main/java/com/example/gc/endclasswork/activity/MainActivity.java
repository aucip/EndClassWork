package com.example.gc.endclasswork.activity;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.gc.endclasswork.MyPagerAdapter;
import com.example.gc.endclasswork.R;
import com.example.gc.endclasswork.activity.Activity_five;
import com.example.gc.endclasswork.activity.Activity_four;
import com.example.gc.endclasswork.activity.Activity_one;
import com.example.gc.endclasswork.activity.Activity_three;
import com.example.gc.endclasswork.activity.Activity_two;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;

/**
 * Created by 龚 聪 on 2018/5/24.
 */

public class MainActivity extends Activity implements OnClickListener {

    private ViewPager viewPager;    //用来放置界面切换
    private List<View> myViews = new ArrayList<View>();
    //LocalActivityManager用来获取每个activity的view,放于Adapter中
    //MyViewPageAdapter用来放viewpager的内容
    //OnClickListener设置底部图片的点击事件
    //OnPageChangeListener设置图片的滑动事件
    private LocalActivityManager manager;
    private ViewPager.OnPageChangeListener pageChangeListener;

    //底部菜单5个Linearlayout
    private LinearLayout tab_home;
    private LinearLayout tab_sell;
    private LinearLayout tab_classify;
    private LinearLayout tab_cart;
    private LinearLayout tab_my;
    // 底部菜单5个ImageView
    private ImageView iv_home;
    private ImageView iv_sell;
    private ImageView iv_classify;
    private ImageView iv_cart;
    private ImageView iv_my;
    // 底部菜单5个菜单标题
    private TextView tv_home;
    private TextView tv_sell;
    private TextView tv_classify;
    private TextView tv_cart;
    private TextView tv_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new LocalActivityManager(this, true);
        manager.dispatchCreate(savedInstanceState);
        initView();
        initViewPage();
        initEvent();
    }
    public void initView(){
        viewPager = (ViewPager)findViewById(R.id.vpager);
        // 初始化底部5个LinearLayout
        tab_home = (LinearLayout)findViewById(R.id.Tab_home);
        tab_sell = (LinearLayout)findViewById(R.id.Tab_sell);
        tab_classify = (LinearLayout)findViewById(R.id.Tab_classify);
        tab_cart = (LinearLayout)findViewById(R.id.Tab_cart);
        tab_my = (LinearLayout)findViewById(R.id.Tab_my);
        // 初始化底部菜单5个ImageView
        iv_home = (ImageView)findViewById(R.id.iv_home);
        iv_sell = (ImageView)findViewById(R.id.iv_sell);
        iv_classify = (ImageView)findViewById(R.id.iv_classify);
        iv_cart = (ImageView)findViewById(R.id.iv_cart);
        iv_my = (ImageView)findViewById(R.id.iv_my);
        // 底部菜单5个菜单标题
        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_sell = (TextView) findViewById(R.id.tv_sell);
        tv_classify = (TextView) findViewById(R.id.tv_classify);
        tv_cart = (TextView) findViewById(R.id.tv_cart);
        tv_my = (TextView) findViewById(R.id.tv_my);
    }

    public void initViewPage(){
        AddActivitiesToViewPager();
        viewPager.setCurrentItem(0);
        //滑动事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                restartBotton();
                //当前view被选择的时候,改变底部菜单图片，文字颜色
                int currentItem = viewPager.getCurrentItem();
                switch (currentItem){
                    case 0:
                        tv_home.setTextColor(0xffD81E06);
                        break;
                    case 1:
                        tv_sell.setTextColor(0xffD81E06);
                        break;
                    case 2:
                        tv_classify.setTextColor(0xffD81E06);
                        break;
                    case 3:
                        tv_cart.setTextColor(0xffD81E06);
                        break;
                    case 4:
                        tv_my.setTextColor(0xffD81E06);
                        break;
                    default:
                        break;
                }
             }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void AddActivitiesToViewPager() {
        Intent intent = new Intent();
        intent.setClass(this, Activity_one.class);
        intent.putExtra("id", 1);
        myViews.add(getView("QualityActivity1", intent));

        intent.setClass(this, Activity_two.class);
        intent.putExtra("id", 2);
        myViews.add(getView("QualityActivity2", intent));

        intent.setClass(this, Activity_three.class);
        intent.putExtra("id", 3);
        myViews.add(getView("QualityActivity3", intent));

        intent.setClass(this, Activity_four.class);
        intent.putExtra("id", 4);
        myViews.add(getView("QualityActivity4", intent));

        intent.setClass(this, Activity_five.class);
        intent.putExtra("id", 5);
        myViews.add(getView("QualityActivity5", intent));
        //适配器初始化并设置
        viewPager.setAdapter(new MyPagerAdapter(myViews));
    }

    private View getView(String id, Intent intent){
        return manager.startActivity(id, intent).getDecorView();
    }

    public void initEvent(){
        tab_home.setOnClickListener(this);
        tab_sell.setOnClickListener(this);
        tab_classify.setOnClickListener(this);
        tab_cart.setOnClickListener(this);
        tab_my.setOnClickListener(this);
    }
    /**
     * 判断哪个要显示，及设置按钮图片
     */
    @Override
    public void onClick(View v) {
        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为红色，页面随之跳转
        switch (v.getId())
        {
            case R.id.Tab_home:
                viewPager.setCurrentItem(0);
                tv_home.setTextColor(0xffD81E06);
                break;
            case R.id.Tab_sell:
                viewPager.setCurrentItem(1);
                tv_sell.setTextColor(0xffD81E06);
                break;
            case R.id.Tab_classify:
                viewPager.setCurrentItem(2);
                tv_classify.setTextColor(0xffD81E06);
                break;
            case R.id.Tab_cart:
                viewPager.setCurrentItem(3);
                tv_cart.setTextColor(0xffD81E06);
                break;
            case R.id.Tab_my:
                viewPager.setCurrentItem(4);
                tv_my.setTextColor(0xffD81E06);
                break;
            default:
                break;
        }
    }

    public void restartBotton(){
        // ImageView置为正常状态
        iv_sell.setImageResource(R.drawable.sell);
        iv_cart.setImageResource(R.drawable.cart);
        iv_my.setImageResource(R.drawable.my);
        // TextView置为黑色
        tv_home.setTextColor(Color.BLACK);
        tv_sell.setTextColor(Color.BLACK);
        tv_classify.setTextColor(Color.BLACK);
        tv_cart.setTextColor(Color.BLACK);
        tv_my.setTextColor(Color.BLACK);
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event) {        // 如果是返回键
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        finish();
        return false;
    }
}
