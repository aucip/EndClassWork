package com.example.gc.endclasswork.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gc.endclasswork.R;

public class Activity_login extends AppCompatActivity {
    //用来保存账号密码信息
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private Button login_bt01;
    private Button login_bt02;
    private Button login_bt03;
    private EditText login_edit01;
    private EditText login_edit02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_bt01 = (Button)findViewById(R.id.login_bt01);
        login_bt02 = (Button)findViewById(R.id.login_bt02);
        login_bt03 = (Button)findViewById(R.id.login_bt03);
        login_edit01 = (EditText)findViewById(R.id.login_edit01);
        login_edit02 = (EditText)findViewById(R.id.login_edit02);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        initEvent();
    }

    private void initEvent() {
        login_bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String user = login_edit01.getText().toString();
                String pawd = login_edit02.getText().toString();
                if(user.equals("123") && pawd.equals("123")) {
                    editor = pref.edit();
                    editor.putString("user", user);
                    editor.putString("pawd", pawd);
                    editor.commit();
                    finish();
                    startActivity(new Intent(Activity_login.this, MainActivity.class));
                }
                else {
                    Toast.makeText(Activity_login.this, "账户密码不正确\n请重新输入", Toast.LENGTH_SHORT).show();
                    login_edit01.setText(null);
                    login_edit02.setText(null);
                }
            }
        });
        login_bt02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//				setContentView(R.layout.register_ui);
                Intent intent = new Intent(Activity_login.this, Activity_register.class);
                startActivity(intent);
            }
        });
        login_bt03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(Activity_login.this, "点击此按钮无\n任何有效信息", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        if(!pref.getString("user","").equals("")){
            login_edit01.setText(pref.getString("user",""));
            login_edit02.setText(pref.getString("pawd",""));
        }
    }
}
