package com.example.gc.endclasswork.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gc.endclasswork.MyDatabaseHelper;
import com.example.gc.endclasswork.R;

public class Activity_register extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase sdb;
    private ImageView register_iv;
    private EditText register_edit01;
    private EditText register_edit02;
    private EditText register_edit03;
    private EditText register_edit04;
    private Button register_bt01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化控件
        register_bt01 = (Button)findViewById(R.id.register_bt01);
        register_edit01 = (EditText)findViewById(R.id.register_edit01);
        register_edit02 = (EditText)findViewById(R.id.register_edit02);
        register_edit03 = (EditText)findViewById(R.id.register_edit03);
        register_edit04 = (EditText)findViewById(R.id.register_edit04);
        register_iv = (ImageView) findViewById(R.id.register_iv);
        dbHelper = new MyDatabaseHelper(this,"User.db",null,1);
        initEvent();
    }

    private void initEvent() {
        /*匿名类*/
        register_bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String name = register_edit01.getText().toString().trim();
                String pawd = register_edit02.getText().toString().trim();
                String pawd1 = register_edit03.getText().toString().trim();
                String tel = register_edit04.getText().toString().trim();
                if(name.equals("") || pawd.equals("") || pawd1.equals("") || tel.equals("")) {
                    Toast.makeText(Activity_register.this, "请输入完整信息！", Toast.LENGTH_SHORT).show();
                    register_edit01.setText(null);
                    register_edit02.setText(null);
                    register_edit03.setText(null);
                    register_edit04.setText(null);
                }
                else if(!pawd.equals(pawd1)){
                    Toast.makeText(Activity_register.this, "密码不一致！", Toast.LENGTH_SHORT).show();
                    register_edit02.setText(null);
                    register_edit03.setText(null);
                }
                else{
                    int result = register(name, pawd, tel);
                    if(result == -1) {
                        Toast.makeText(Activity_register.this, "用户已存在！", Toast.LENGTH_SHORT).show();
                    }
                    if(result == 1){
                        Toast.makeText(Activity_register.this, "注册成功！", Toast.LENGTH_SHORT).show();
                        register_edit01.setText(null);
                        register_edit02.setText(null);
                        register_edit03.setText(null);
                        register_edit04.setText(null);
                    }
                }
                sdb.close();
            }
        });
        /*返回按钮*/
        register_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    /*讲文本框的数据保存到数据库内*/
    public int register(String name, String pawd, String tel){
        //打开数据库
        sdb = dbHelper.getWritableDatabase();
        String sql = "select * from user where username = ?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{name});  //判断注册的用户名在数据库是否存在
        if(cursor.getCount() > 0){
            cursor.close();
            return -1;
        }
        else {
            ContentValues values = new ContentValues();
            values.put("username", name);
            values.put("password", pawd);
            values.put("tel", tel);
            sdb.insert("user", null, values);
            return 1;
        }
    }
}
