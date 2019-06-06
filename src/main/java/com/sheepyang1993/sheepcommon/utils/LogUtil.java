package com.sheepyang1993.sheepcommon.utils;

import android.util.Log;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/5/23 9:08
 * @describe 日志工具类
 */
public class LogUtil {

    public static void v(String tag, String msg) {
        v(tag, msg, false);
    }

    public static void v(String tag, String msg, boolean showStackTrace) {
        if (showStackTrace) {
            vStackTrace(tag, msg);
        } else {
            Log.v(tag, msg);
        }
    }

    private static void vStackTrace(String tag, String msg) {
        for (int i = 0; i < Thread.currentThread().getStackTrace().length; i++) {
            String realContent = getContent(msg, i);
            Log.v(tag, realContent);
        }
    }

    protected static String getNameFromTrace(StackTraceElement[] traceElements, int place) {
        StringBuilder taskName = new StringBuilder();
        if (traceElements != null && traceElements.length > place) {
            StackTraceElement traceElement = traceElements[place];
            taskName.append(traceElement.getMethodName());
            taskName.append("(").append(traceElement.getFileName()).append(":").append(traceElement.getLineNumber()).append(")");
        }
        return taskName.toString();
    }

    private static String getContent(String msg, int place) {
        try {
            String sourceLinks = getNameFromTrace(Thread.currentThread().getStackTrace(), place);
            return sourceLinks + String.format(msg);
        } catch (Throwable throwable) {
            return msg;
        }
    }
}
