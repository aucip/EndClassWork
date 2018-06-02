package com.example.gc.endclasswork.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gc.endclasswork.R;

/**
 * Created by 龚 聪 on 2018/6/2.
 */


public class Activity_four extends Activity {
    private int totalCount;
    private int text_01, text_02, text_03;
    private double text_04;
    private TextView tv01, tv02, tv03, tv04;
    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager04);

        init();

    }
    public void init() {
        btn01 = (Button) findViewById(R.id.btn_01);
        btn02 = (Button) findViewById(R.id.btn_02);
        tv01 = (TextView) findViewById(R.id.tv01);

        btn03 = (Button) findViewById(R.id.btn_03);
        btn04 = (Button) findViewById(R.id.btn_04);
        tv02 = (TextView) findViewById(R.id.tv02);

        btn05 = (Button) findViewById(R.id.btn_05);
        btn06 = (Button) findViewById(R.id.btn_06);
        tv03 = (TextView) findViewById(R.id.tv03);
        tv04 = (TextView)findViewById(R.id.tv04);
        btn07 = (Button) findViewById(R.id.btn_07);
        btn07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_four.this, "您的余额不足哦亲！", Toast.LENGTH_SHORT).show();
            }
        });

        text_01 = Integer.parseInt(tv01.getText().toString());
        text_02 = Integer.parseInt(tv02.getText().toString());
        text_03 = Integer.parseInt(tv03.getText().toString());
        text_04 = 5979.0 * text_01 + 3799.0 * text_02 + 1938.0 * text_03;
        tv04.setText("¥" + Double.toString(text_04));
        initEvent();
    }
    public void initEvent() {
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_01 == 0) {
                    tv01.setText("0");
                } else {
                    text_01--;
                    tv01.setText(Integer.toString(text_01));
                }
                text_04 = 5979.0 * text_01 + 3799.0 * text_02 + 1938.0 * text_03;
                tv04.setText("¥" + Double.toString(text_04));
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_01 == 10) {
                    Toast.makeText(Activity_four.this, "商品限购十件哦亲！", Toast.LENGTH_SHORT).show();
                    tv01.setText("10");
                } else {
                    text_01++;
                    tv01.setText(Integer.toString(text_01));
                }
                text_04 = 5979.0 * text_01 + 3799.0 * text_02 + 1938.0 * text_03;
                tv04.setText("¥" + Double.toString(text_04));
            }
        });
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_02 == 0) {
                    tv02.setText("0");
                } else {
                    text_02--;
                    tv02.setText(Integer.toString(text_02));
                }
                text_04 = 5979.0 * text_01 + 3799.0 * text_02 + 1938.0 * text_03;
                tv04.setText("¥" + Double.toString(text_04));
            }
        });
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_02 == 10) {
                    Toast.makeText(Activity_four.this, "商品限购十件哦亲！", Toast.LENGTH_SHORT).show();
                    tv02.setText("10");
                } else {
                    text_02++;
                    tv02.setText(Integer.toString(text_02));
                }
                text_04 = 5979.0 * text_01 + 3799.0 * text_02 + 1938.0 * text_03;
                tv04.setText("¥" + Double.toString(text_04));
            }
        });
        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_03 == 0) {
                    tv03.setText("0");
                } else {
                    text_03--;
                    tv03.setText(Integer.toString(text_03));
                }
                text_04 = 5979.0 * text_01 + 3799.0 * text_02 + 1938.0 * text_03;
                tv04.setText("¥" + Double.toString(text_04));
            }
        });
        btn06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_03 == 10) {
                    Toast.makeText(Activity_four.this, "商品限购十件哦亲！", Toast.LENGTH_SHORT).show();
                    tv03.setText("10");
                } else {
                    text_03++;
                    tv03.setText(Integer.toString(text_03));
                }
                text_04 = 5979.0 * text_01 + 3799.0 * text_02 + 1938.0 * text_03;
                tv04.setText("¥" + Double.toString(text_04));
            }
        });

    }
}