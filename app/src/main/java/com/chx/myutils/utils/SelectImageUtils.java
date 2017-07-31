package com.chx.myutils.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;

import java.io.File;
import java.util.Date;

/**
 * Created by chaohx on 2017/7/31.
 */

public class SelectImageUtils {
    //由于需要用到startActivityForResult，所以该工具类必须依附于一个Activity来使用
    private Activity activity;
    //唤起系统相机拍照的标识，在onActivityResult接收回调数据时区分 拍照/从相册选取照片
    private int RESULT_CAMERA = 1;
    //唤起系统相册的标识。
    private int RESULT_ALBUM=2;
    //指定相机拍照时，图片的存储地址
    private String targetCameraPath;

    public SelectImageUtils(Activity activity) {
        this.activity = activity;
    }

    //去拍照
    public void toCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //设置拍照之后的存储路径
        targetCameraPath = Environment.getExternalStorageDirectory() + File.separator + new Date().getTime() + ".jpg";
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(targetCameraPath)));
        //由于我们需要调用完Camera后，可以返回Camera获取到的图片，
        //所以，我们使用startActivityForResult来启动Camera
        activity.startActivityForResult(intent, RESULT_CAMERA);
    }

    //去相册中选择
    public void toAlbum() {
        Intent pickIntent = new Intent(Intent.ACTION_PICK);
        //设置拿出数据的类型
        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(pickIntent, RESULT_ALBUM);
    }

    public Bitmap dealImageData(int requestCode, int resultCode, Intent data) {
        try {
            if (requestCode == RESULT_CAMERA) {
                //从拍照回来的
                if (!TextUtils.isEmpty(targetCameraPath)) {
                    //ImageZipUtils是一个图片压缩工具
//                    String imagePath = targetCameraPath = ImageZipUtils.saveBitmap(activity, targetCameraPath);
                    return BitmapFactory.decodeFile(targetCameraPath);
                }
            } else if (requestCode == RESULT_ALBUM) {
                //获得照片资源的原始地址
                Uri originalUri = data.getData();
                if (originalUri != null) {
                    String[] proj = {MediaStore.Images.Media.DATA};
                    Cursor cursor = activity.managedQuery(originalUri, proj, null, null, null);
                    int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();
                    String imagePath = cursor.getString(column_index);
                    if (!TextUtils.isEmpty(imagePath)) {
                        imagePath = ImageZipUtils.saveBitmap(activity, imagePath);
                        return BitmapFactory.decodeFile(imagePath);
                    }

                } else {
                    ToastUtils.showToast("从相册获取图片失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
