package com.example.gc.endclasswork.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gc.endclasswork.R;

public class Activity_register extends AppCompatActivity {
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
        register_bt01 = (Button)findViewById(R.id.register_bt01);
        register_edit01 = (EditText)findViewById(R.id.register_edit01);
        register_edit02 = (EditText)findViewById(R.id.register_edit02);
        register_edit03 = (EditText)findViewById(R.id.register_edit03);
        register_edit04 = (EditText)findViewById(R.id.register_edit04);
        register_iv = (ImageView) findViewById(R.id.register_iv);
        initEvent();
    }

    private void initEvent() {
/*匿名类*/
        register_bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(register_edit01.getText().toString().equals("") || register_edit02.getText().toString().equals("") ||
                        register_edit03.getText().toString().equals("") || register_edit04.getText().toString().equals("")) {
                    Toast.makeText(Activity_register.this, "请输入完整信息", Toast.LENGTH_SHORT).show();
                    register_edit01.setText(null);
                    register_edit02.setText(null);
                    register_edit03.setText(null);
                    register_edit04.setText(null);
                }
                else {
                    Toast.makeText(Activity_register.this, "注册成功", Toast.LENGTH_SHORT).show();
                    register_edit01.setText(null);
                    register_edit02.setText(null);
                    register_edit03.setText(null);
                    register_edit04.setText(null);
                }
            }
        });
        register_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
