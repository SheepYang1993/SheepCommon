package com.sheepyang1993.sheepcommon.utils.umeng;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SheepYang
 * @date 2019/12/13
 */
public class UmengUtil {
    private static Context sContext;

    public static void onEvent(String key, Map<String, Object> params) {
        MobclickAgent.onEventObject(sContext, key, params);
    }

    public static void onEvent(String key, String params) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("params", params);
        MobclickAgent.onEventObject(sContext, key, paramsMap);
    }

    public static void onEvent1(String key, String... params) {
        Map<String, Object> paramsMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(params[i]);
        }
        paramsMap.put("params", sb.toString());
        MobclickAgent.onEventObject(sContext, key, paramsMap);
    }

    public static void onEvent2(String key, String subKey, String... params) {
        Map<String, Object> paramsMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(params[i]);
        }
        paramsMap.put(subKey, sb.toString());
        MobclickAgent.onEventObject(sContext, key, paramsMap);
    }

    public static void init(Context context) {
        sContext = context;
    }
}
