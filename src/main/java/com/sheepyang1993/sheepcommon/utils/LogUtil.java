package com.sheepyang1993.sheepcommon.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/5/23 9:08
 * @describe 日志工具类
 */
public class LogUtil {
    private static List<OnLogListener> mLogListenerList = new ArrayList<>();

    public static void v(String tag, String msg) {
        v(tag, msg, false);
    }

    public static void v(String tag, String msg, boolean showStackTrace) {
        if (showStackTrace) {
            vStackTrace(tag, msg);
        } else {
            vRealLog(tag, msg);
        }
    }

    private static void vStackTrace(String tag, String msg) {
        for (int i = 0; i < Thread.currentThread().getStackTrace().length; i++) {
            String realContent = getContent(msg, i);
            vRealLog(tag, realContent);
        }
    }

    private static void vRealLog(String tag, String msg) {
        dispatchListener(tag, msg);
        Log.v(tag, msg);
    }

    private static void dispatchListener(String tag, String msg) {
        if (ListUtil.isNotEmpty(mLogListenerList)) {
            for (OnLogListener onLogListener : mLogListenerList) {
                onLogListener.v(tag, msg);
            }
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

    public interface OnLogListener {
        void v(String tag, String msg);
    }

    public static void addListener(OnLogListener listener) {
        mLogListenerList.add(listener);
    }
}
