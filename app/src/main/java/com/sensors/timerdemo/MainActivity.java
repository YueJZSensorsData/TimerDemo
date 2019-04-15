package com.sensors.timerdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_play).setOnClickListener(this);
        findViewById(R.id.end_play).setOnClickListener(this);
        findViewById(R.id.end_app).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_play:
                TimerUtils.startPlayTime();
//                delayed();
                break;
            case R.id.end_play:
                getPlayTime();
                break;
            case R.id.end_app:
                getRunTime();
                break;
        }
    }

    /**
     * 点击控件后立即退到后台，模拟到后台统计事件
     */
    private void delayed() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getPlayTime();
                Log.d("SA.yuejz", "postDelayed");
            }
        }, 40000);
    }

    private void getRunTime() {
        JSONObject jsonObject = new JSONObject();
        try {
            float runTime = TimerUtils.getRunTimeInterval();
            jsonObject.put("runtime", runTime);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SensorsDataAPI.sharedInstance().track("append", jsonObject);
    }

    private void getPlayTime() {
        JSONObject jsonObject = new JSONObject();
        try {
            float playTime = TimerUtils.getPlayTimeInterval();
            jsonObject.put("playtime", playTime);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SensorsDataAPI.sharedInstance().track("playmusic", jsonObject);
    }
}
