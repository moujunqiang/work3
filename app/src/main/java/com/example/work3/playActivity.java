package com.example.work3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class playActivity extends AppCompatActivity implements OnClickListener {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_main);
        findViewById(R.id.btnshake).setOnClickListener(this);
        findViewById(R.id.setp).setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btnshake){
            Intent intent = new Intent(this, shakeplay.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.setp){
            Intent intent = new Intent(this, LocationActivity.class);
            startActivity(intent);
        }
    }
}
