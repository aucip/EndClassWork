package com.example.gc.endclasswork.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.gc.endclasswork.MyDatabaseHelper;
import com.example.gc.endclasswork.R;
import static android.widget.Toast.LENGTH_SHORT;

public class Activity_login extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase sdb;
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
        //c初始化控件
        login_bt01 = (Button)findViewById(R.id.login_bt01);
        login_bt02 = (Button)findViewById(R.id.login_bt02);
        login_bt03 = (Button)findViewById(R.id.login_bt03);
        login_edit01 = (EditText)findViewById(R.id.login_edit01);
        login_edit02 = (EditText)findViewById(R.id.login_edit02);
        //用来存储信息
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        //创建数据库，使用自带的sqlite3实现
        dbHelper = new MyDatabaseHelper(this,"User.db",null,1);
        initEvent();
    }

    private void initEvent() {
        login_bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                /*获取文本框的账户与密码*/
                final String user = login_edit01.getText().toString().trim();
                final String pawd = login_edit02.getText().toString().trim();
                int result = login(user, pawd);
                if(result == 1){
                    editor = pref.edit();
                    editor.putString("user", user); //键值对方式保存信息
                    editor.putString("pawd", pawd);
                    editor.commit();    //提交
                    finish();           //结束进程
                    Intent intent = new Intent(Activity_login.this, MainActivity.class);
                    intent.putExtra("data", user);
                    startActivity(intent); //跳转到主界面
//                    Toast.makeText(Activity_login.this, "亲爱的：" + user + "\n欢迎您登录！", Toast.LENGTH_LONG).show();
                }
                else if(result == -1){
                    Toast.makeText(Activity_login.this, "密码错误！", LENGTH_SHORT).show();
                    login_edit02.setText(null);
                }
                else{
                    Toast.makeText(Activity_login.this, "用户名不存在！", LENGTH_SHORT).show();
                    login_edit01.setText(null);
                    login_edit02.setText(null);
                }
                sdb.close();
//                if(user.equals("123") && pawd.equals("123")) {
//                    editor = pref.edit();
//                    editor.putString("user", user);
//                    editor.putString("pawd", pawd);
//                    editor.commit();
//                    finish();
//                    startActivity(new Intent(Activity_login.this, MainActivity.class));
//                }
//                else {
//                    Toast.makeText(Activity_login.this, "账户密码不正确\n请重新输入", Toast.LENGTH_SHORT).show();
//                    login_edit01.setText(null);
//                    login_edit02.setText(null);
//                }

             }
        });
        //注册按钮实现跳转到注册界面
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
                Toast.makeText(Activity_login.this, "点击此按钮无\n任何有效信息", LENGTH_SHORT).show();
            }
        });
    }

    /*实现文本框与数据库信息匹配*/
    public int login(String username,String password) {
        //打开数据库
        sdb = dbHelper.getWritableDatabase();
        String sql = "select * from user where username = ?";
        String sql01 = "select * from user where password = ? and username = ?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username});
        if(cursor.getCount() > 0){      //匹配账号是否存在，存在继续，不存在返回0
            Cursor pwdcursor =sdb.rawQuery(sql01,new String[]{password,username});
            if(pwdcursor.getCount() > 0){   //匹配密码是否正确,正确返回1，错误返回-1
                cursor.close();
                pwdcursor.close();
                return 1;
            }
            else {
                cursor.close();
                pwdcursor.close();
                return -1;
            }
        }
        else {
            cursor.close();
            return 0;
        }
    }

    //重启登录界面时讲上次登录信息输出在文本框
    @Override
    protected void onStart(){
        super.onStart();
        if(!pref.getString("user","").equals("")){
            login_edit01.setText(pref.getString("user",""));
            login_edit02.setText(pref.getString("pawd",""));
        }
    }

}
