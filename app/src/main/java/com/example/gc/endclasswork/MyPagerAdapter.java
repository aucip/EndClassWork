package com.example.gc.endclasswork;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 龚 聪 on 2018/5/25.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<View> views;
    public MyPagerAdapter(List<View> views){
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView(views.get(position));
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        container.addView(view);
        return view;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
