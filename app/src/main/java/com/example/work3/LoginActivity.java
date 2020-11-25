package com.example.work3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {

    private static final int LOADING=1;
    private static final int LOADING_COMPLETE=2;
    private static final int OPEN=3;
    private Button Mbtnback,mbtngo;
    int i = 0;
    ProgressBar progressBar = null;
    Button button = null;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LOADING:
                    button.setEnabled(false);
                    i += 10;
                    progressBar.setProgress(i);
                    if (i != 100) {
                        mHandler.sendEmptyMessageDelayed(LOADING, 500);
                        button.setText("已加载"+i+"%...");
                    } else if (i == 100) {
                        button.setText("加载完成");
                        mHandler.sendEmptyMessageDelayed(LOADING_COMPLETE, 500);
                    }
                    break;
                case LOADING_COMPLETE:
                    button.setText("打开游戏");
                    button.setEnabled(true);
                    button.setBackgroundResource(android.R.color.holo_orange_light);
                    mHandler.sendEmptyMessageDelayed(OPEN, 500);
                    break;
                case OPEN:
                    progressBar.setProgress(0);
                    button.setBackgroundResource(R.drawable.btn_selewctor);
                    button.setText("加载游戏");
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        button = (Button) findViewById(R.id.btngogo);
        mbtngo=(Button)findViewById(R.id.btngogo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                mHandler.sendEmptyMessage(LOADING);
            }
        });

        Mbtnback = (Button)findViewById(R.id.btnback);
        //设置Button的单击事件
        Mbtnback.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //实例化一个意图对象Intent
                Intent intent = new Intent();
                //设置意图对象跳转至那个界面，第一个参数为本界面，第二个参数为跳转至哪个界面
                //注意 要再清单文件AndroidManifest.xml中定义声明LoginActivity
                intent.setClass(LoginActivity.this, MainActivity.class);
                //启动意图
                startActivity(intent);
            }
        });
        mbtngo = (Button)findViewById(R.id.btngogo);
        mbtngo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //实例化一个意图对象Intent
                Intent intent = new Intent();
                //设置意图对象跳转至那个界面，第一个参数为本界面，第二个参数为跳转至哪个界面
                //注意 要再清单文件AndroidManifest.xml中定义声明LoginActivity
                intent.setClass(LoginActivity.this, playActivity.class);
                //启动意图
                startActivity(intent);
            }
        });
    }

}

