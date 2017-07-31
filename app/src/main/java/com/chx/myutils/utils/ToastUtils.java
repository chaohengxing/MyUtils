package com.chx.myutils.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.chx.myutils.App;
import com.chx.myutils.R;
import com.chx.myutils.utils.DensityUtils;


/**
 * Created by chaohx on 2017/7/12.
 */

public class ToastUtils {


    /**
     * 这里是方法的重载，用于开放不同的参数
     *
     * @param messageID
     */
    public static void showToast(int messageID) {
        showToast(App.getInstance(), messageID);
    }


    public static void showToast(String message) {
        showToast(App.getInstance(), message);
    }


    public static void showToast(int messageID, int duration) {
        showToast(App.getInstance(), messageID, duration);
    }

    public static void showToast(String message, int duration) {
        showToast(App.getInstance(), message, duration);
    }


    public static void showToast(Context context, int resId) {
        showToast(context, context.getString(resId), Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }

    public static void showToast(Activity context, int resId) {
        showToast(context, context.getString(resId), Toast.LENGTH_SHORT);
    }

    public static void showToast(Activity context, int resId, int duration) {
        showToast(context, context.getString(resId), duration);
    }

    private static void showToast(Activity context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }


    private static void showToast(Context context, int resId, int duration) {
        ///Toast.makeText(context, resId, duration).show();
        showToast(context, context.getString(resId), duration);
    }

    static Toast toast;
    static TextView contentView;


    /**
     * 自定义Toast的样式与位置
     *
     * @param context
     * @param message
     * @param duration
     */
    private static void showToast(Context context, String message, int duration) {
        if (context == null) {
            return;
        }
        try {
            if (toast == null || contentView == null) {
                int dp30 = DensityUtils.dp2px(context, 30);
                int dp20 = DensityUtils.dp2px(context, 20);
                contentView = new TextView(context);
                contentView.setGravity(Gravity.CENTER);
                contentView.setBackgroundResource(R.drawable.bg_toast);
                contentView.setTextSize(16);
                contentView.setTextColor(context.getResources().getColor(R.color.white));
                contentView.setPadding(dp30, dp20, dp30, dp20);
                toast = new Toast(context);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(contentView);
                toast.setDuration(duration);
            }
            contentView.setText(message);
            toast.show();
        } catch (Exception e) {
            Toast.makeText(context, message, duration).show();
            e.printStackTrace();
        }
    }
}
