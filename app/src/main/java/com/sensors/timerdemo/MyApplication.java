package com.sensors.timerdemo;

import android.app.Application;

import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

public class MyApplication extends Application {
    @Override
    public void onCreate() {

        //启动开始计时
        TimerUtils.startRunTime();

        super.onCreate();

        //初始化神策
        initSA();
    }

    private void initSA() {
        SAConfigOptions saConfigOptions = new SAConfigOptions("https://test-hechun.datasink.sensorsdata.cn/sa?project=yuejianzhong&token=d28b875ed9ac268f");
        SensorsDataAPI.sharedInstance(this, saConfigOptions);
        SensorsDataAPI.sharedInstance().enableLog(true);
    }
}
