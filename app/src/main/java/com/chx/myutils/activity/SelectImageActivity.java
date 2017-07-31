package com.chx.myutils.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chx.myutils.R;
import com.chx.myutils.utils.SelectImageUtils;

import org.w3c.dom.Text;

public class SelectImageActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private TextView textView1;
    private TextView textView2;

    private SelectImageUtils selectImageUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        selectImageUtils = new SelectImageUtils(this);
        imageView = (ImageView) findViewById(R.id.image_view);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView1:
                selectImageUtils.toCamera();
                break;
            case R.id.textView2:
                selectImageUtils.toAlbum();
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageView.setImageBitmap(selectImageUtils.dealImageData(requestCode, resultCode, data));
    }
}
