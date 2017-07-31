package com.chx.myutils.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chx.myutils.R;
import com.chx.myutils.utils.DensityUtils;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
//        imageView = (ImageView) findViewById(R.id.image);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "状态栏高度：" + DensityUtils.getStatusHeight(MainActivity.this), Toast.LENGTH_SHORT).show();
                Bitmap bitmap = DensityUtils.snapShotWithoutStatusBar(MainActivity.this);
                imageView.setImageBitmap(bitmap);
            }
        });

    }
}
