package com.sheepyang1993.sheepcommon.debug;

import com.blankj.utilcode.util.SPUtils;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/5/27 20:45
 * @describe 测试环境所需要的常量
 */
public class DebugUtils {
    private static final String SP_SHOW_DEBUG_INFO = "SP_SHOW_DEBUG_INFO";

    public static boolean isShowDebugInfo() {
        return SPUtils.getInstance().getBoolean(SP_SHOW_DEBUG_INFO, false);
    }

    public static void setShowDebugInfo(boolean intoDebugMode) {
        SPUtils.getInstance().put(SP_SHOW_DEBUG_INFO, intoDebugMode);
    }
}
