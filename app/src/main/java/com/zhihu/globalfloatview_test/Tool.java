package com.zhihu.globalfloatview_test;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2021-02-19 17:49
 * description:
 */
public class Tool {

    public static boolean isAppOnForeground(Context context) {
        if (context == null) {
            return false;
        }

        ActivityManager activityManager = (ActivityManager) context.getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = context.getApplicationContext().getPackageName();

        /**
         * 获取Android设备中所有正在运行的App
         */
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }

}
