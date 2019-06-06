package com.sheepyang1993.sheepcommon.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/5/26
 */
public class HandlerUtil {
    private static final Object LOCK = new Object();
    private volatile static Handler mainHandler = null;
    private volatile static Handler backgroundHandler;

    public static void runOnUIThread(Runnable action) {
        Handler mainHandler = HandlerUtil.getMainHandler();
        mainHandler.post(action);
    }

    private static Handler getMainHandler() {
        if (mainHandler != null) {
            return mainHandler;
        }

        synchronized (LOCK) {
            // Only the first thread entering in this section will create the Handler
            if (mainHandler == null) {
                mainHandler = new Handler(Looper.getMainLooper());
            }
            return mainHandler;
        }
    }

    public static void runOnBackgroundThread(Runnable action) {
        Handler backgroundHandler = HandlerUtil.getBackgroundHandler();
        backgroundHandler.post(action);
    }

    private static Handler getBackgroundHandler() {
        if (backgroundHandler != null) {
            return backgroundHandler;
        }

        synchronized (LOCK) {
            // Only the first thread entering in this section will create the Handler
            if (backgroundHandler == null) {
                final HandlerThread mHandlerThread = new HandlerThread("HandlerThread");
                mHandlerThread.start();
                backgroundHandler = new Handler(mHandlerThread.getLooper());
            }
            return backgroundHandler;
        }
    }

    public static Runnable runDelayedInUIThread(Runnable runnable, long delayMillis) {
        return postDelayed(getMainHandler(), runnable, delayMillis);
    }

    public static Runnable runDelayedInBackgroundThread(Runnable runnable, long delayMillis) {
        return postDelayed(getBackgroundHandler(), runnable, delayMillis);
    }

    private static Runnable postDelayed(Handler handler, final Runnable runnable, long delayMillis) {
        if (handler == null || runnable == null || delayMillis < 1) {
            return null;
        }

        Runnable delayedRunnable = new Runnable() {
            @Override
            public void run() {
                runnable.run();
            }
        };
        handler.postDelayed(delayedRunnable, delayMillis);

        return delayedRunnable;
    }

    public static void removeCallbacks(Runnable runnable) {
        removeCallbacks(getMainHandler(), runnable);
        removeCallbacks(getBackgroundHandler(), runnable);
    }

    private static void removeCallbacks(Handler handler, Runnable runnable) {
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public static void removeAllCallbacks() {
        if (backgroundHandler != null) {
            backgroundHandler.removeCallbacks(null);
        }
        if (mainHandler != null) {
            mainHandler.removeCallbacks(null);
        }
    }
}
