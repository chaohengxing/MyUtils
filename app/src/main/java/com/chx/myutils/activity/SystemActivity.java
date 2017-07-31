package com.chx.myutils.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chx.myutils.R;
import com.chx.myutils.utils.SystemUtil;
import com.chx.myutils.utils.ToastUtils;

public class SystemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "" + SystemUtil.isWifiConnected(getApplicationContext()), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "" + SystemUtil.isMobileNetworkConnected(getApplicationContext()), Toast.LENGTH_SHORT).show();

            }
        });

        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "" + SystemUtil.isNetworkConnected(getApplicationContext()), Toast.LENGTH_SHORT).show();

            }
        });

        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "" + SystemUtil.getNetworkType(getApplicationContext()), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemUtil.copyToClipBoard(getApplicationContext(), "copy到剪切板");
            }
        });

    }
}
