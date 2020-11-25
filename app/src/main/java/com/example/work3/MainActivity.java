package com.example.work3;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar = null;
    private Button mbtngo,mbtnload,mbtnsave,mbtnclear;
    private EditText medkey,meduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mbtngo=(Button)findViewById(R.id.btngo);
        mbtngo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initView(){
        medkey=(EditText)findViewById(R.id.edkey);
        meduser=(EditText)findViewById(R.id.eduser);
        mbtnload=(Button)findViewById(R.id.btnload);
        mbtnsave=(Button)findViewById(R.id.btnsave);
        mbtnclear=(Button)findViewById(R.id.btnclear);
        mbtnsave.setOnClickListener(new OnClickListener() {
            @SuppressLint({ "NewApi", "CommitPrefEdits" })
            @Override
            public void onClick(View v){
                String temp1 = meduser.getText().toString();
                String temp2 = medkey.getText().toString();
                if(temp1.isEmpty()||temp2.isEmpty())return;
                SharedPreferences mSharedPreferences = getSharedPreferences("ywj", Context.MODE_PRIVATE);
                Editor mEditor = mSharedPreferences.edit();
                mEditor.putString("账号",temp1);
                mEditor.putString("密码",temp2);
                mEditor.commit();
                Toast.makeText(MainActivity.this, "保存成功！", Toast.LENGTH_SHORT).show();
            }
        });
        mbtnclear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //清空编辑框
                medkey.setText("");
                meduser.setText("");
                Toast.makeText(MainActivity.this, "清空成功！", Toast.LENGTH_SHORT).show();
            }
        });
        mbtnload.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                SharedPreferences mSharedPreferences = getSharedPreferences("ywj", Context.MODE_PRIVATE);
                //getString()第二个参数为缺省值，如果preference中不存在该key，将返回缺省值
                String temp1 = mSharedPreferences.getString("账号","");
                String temp2 = mSharedPreferences.getString("密码","");
                //设置编辑框值
                meduser.setText(temp1);
                medkey.setText(temp2);
                Toast.makeText(MainActivity.this, "读取成功！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
