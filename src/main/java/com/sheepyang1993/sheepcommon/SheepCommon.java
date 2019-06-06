package com.sheepyang1993.sheepcommon;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.orhanobut.hawk.Hawk;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/7
 */
public class SheepCommon {
    /**
     * 通用库初始化
     *
     * @param app
     * @param channel
     * @param buglyAppId
     * @param umengAppKey
     */
    public static void init(Application app, String channel, String buglyAppId, String umengAppKey) {
        initBugly(app, buglyAppId);
        initUmeng(app, umengAppKey, channel);
        initUtils(app);
        initHttpUtil(app);
    }

    private static void initHttpUtil(Application app) {
        OkGo.getInstance().init(app);
    }

    private static void initUtils(Application app) {
        //常用工具类
        Utils.init(app);
        //对象存储
        Hawk.init(app).build();
    }

    /**
     * 初始化bugly
     */
    private static void initBugly(Application app, String buglyAppId) {
        CrashReport.initCrashReport(app, buglyAppId, false);
    }

    private static void registerUmengActivityLifecycle(Application app) {
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                MobclickAgent.onResume(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
                MobclickAgent.onPause(activity);
            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }


    /**
     * 初始化友盟
     */
    private static void initUmeng(Application app, String umengAppKey, String channel) {
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey
         * 参数3:【友盟+】 Channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret, 未接入推送则为null
         */
        UMConfigure.init(app, umengAppKey, channel, UMConfigure.DEVICE_TYPE_PHONE, null);
        /**
         * 设置日志加密
         * 参数：boolean 默认为false（不加密）
         */
        UMConfigure.setEncryptEnabled(true);
        registerUmengActivityLifecycle(app);
    }
}
