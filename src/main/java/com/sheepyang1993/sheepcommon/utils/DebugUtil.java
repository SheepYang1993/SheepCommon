package com.sheepyang1993.sheepcommon.utils;

import com.blankj.utilcode.util.SPUtils;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/7/29 16:13
 * @describe Debug工具类
 */
public class DebugUtil {
    private static final String SP_DEBUG_ENV = "SP_DEBUG_ENV";

    /**
     * 是否测试环境
     *
     * @return
     */
    public static boolean isDebugEnv() {
        return SPUtils.getInstance().getBoolean(SP_DEBUG_ENV, false);
    }

    public static void setDebugEnv(boolean isDebug) {
        SPUtils.getInstance().put(SP_DEBUG_ENV, isDebug);
    }
}
