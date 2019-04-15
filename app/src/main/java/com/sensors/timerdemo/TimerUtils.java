package com.sensors.timerdemo;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

public class TimerUtils {

    /** 计算应用运行时间,单位为毫秒 */
    private static float appRunTime_start;
    private static float appRunTime_end;

    /** 计算播放时间,单位为毫秒 */
    private static float playTime_start;
    private static float playTime_end;

    public static void startRunTime() {
        appRunTime_start = SystemClock.elapsedRealtime();
        Log.d("SA.yuejz", String.valueOf(appRunTime_start));
    }

    public static float getRunTimeInterval() {
        appRunTime_end = SystemClock.elapsedRealtime();
        Log.d("SA.yuejz", String.valueOf(appRunTime_end - appRunTime_start));
        return (appRunTime_end - appRunTime_start) / 1000.0f;
    }

    public static void startPlayTime() {
        playTime_start = SystemClock.elapsedRealtime();
        Log.d("SA.yuejz", String.valueOf(playTime_start));
    }

    public static float getPlayTimeInterval() {
        playTime_end = SystemClock.elapsedRealtime();
        Log.d("SA.yuejz", String.valueOf(playTime_end - playTime_start));
        return (playTime_end - playTime_start) / 1000.0f;
    }
}
