package com.example.gc.endclasswork.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gc.endclasswork.Activity_login;
import com.example.gc.endclasswork.R;

/**
 * Created by 龚 聪 on 2018/6/2.
 */


public class Activity_five extends Activity implements View.OnClickListener {
    private LinearLayout ll_01, ll_02;
    private Button btn_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager05);
        ll_01 = (LinearLayout)findViewById(R.id.ll_01);
        ll_02 = (LinearLayout)findViewById(R.id.ll_02);
        btn_setting = (Button)findViewById(R.id.btn_setting);
        ll_01.setOnClickListener(this);
        ll_02.setOnClickListener(this);
        btn_setting.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_01:
                Toast.makeText(Activity_five.this, "该功能还未实现，敬请期待哦！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_02:
                finish();
                startActivity(new Intent(this, Activity_login.class));
                break;
            case R.id.btn_setting:
                    startActivity(new Intent(Activity_five.this, Activity_setting.class));
                    break;
            default:
                break;
        }
    }
}