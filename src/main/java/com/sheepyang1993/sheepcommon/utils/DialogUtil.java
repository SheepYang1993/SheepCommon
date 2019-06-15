package com.sheepyang1993.sheepcommon.utils;

import android.app.Activity;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/5/28 15:44
 * @describe 对话框提示工具类
 */
public class DialogUtil {
    private QMUITipDialog mTipDialog;

    private DialogUtil() {
    }

    private static class SingletonInstance {
        private static final DialogUtil INSTANCE = new DialogUtil();
    }

    public static DialogUtil getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public static void showLoadingDialog(Activity activity) {
        getInstance().showLoadingDialog(activity, "正在加载...", QMUITipDialog.Builder.ICON_TYPE_LOADING);
    }

    public static void showLoadingDialog(Activity activity, String tip) {
        getInstance().showLoadingDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_LOADING);
    }

    public static void showLoadingSuccessDialog(Activity activity, String tip) {
        getInstance().showLoadingDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_SUCCESS);
    }

    public static void showLoadingFailDialog(Activity activity, String tip) {
        getInstance().showLoadingDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_FAIL);
    }

    public static void showLoadingInfoDialog(Activity activity, String tip) {
        getInstance().showLoadingDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_INFO);
    }

    public static void showToastDialog(Activity activity) {
        getInstance().showToastDialog(activity, "正在加载...", QMUITipDialog.Builder.ICON_TYPE_LOADING, null);
    }

    public static void showToastDialog(Activity activity, String tip) {
        getInstance().showToastDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_LOADING, null);
    }

    public static void showToastSuccessDialog(Activity activity, String tip) {
        getInstance().showToastDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_SUCCESS, null);
    }

    public static void showToastFailDialog(Activity activity, String tip) {
        getInstance().showToastDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_FAIL, null);
    }

    public static void showToastInfoDialog(Activity activity, String tip) {
        getInstance().showToastDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_INFO, null);
    }

    public static void showToastDialog(Activity activity, Runnable runnable) {
        getInstance().showToastDialog(activity, "正在加载...", QMUITipDialog.Builder.ICON_TYPE_LOADING, runnable);
    }

    public static void showToastDialog(Activity activity, String tip, Runnable runnable) {
        getInstance().showToastDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_LOADING, runnable);
    }

    public static void showToastSuccessDialog(Activity activity, String tip, Runnable runnable) {
        getInstance().showToastDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_SUCCESS, runnable);
    }

    public static void showToastFailDialog(Activity activity, String tip, Runnable runnable) {
        getInstance().showToastDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_FAIL, runnable);
    }

    public static void showToastInfoDialog(Activity activity, String tip, Runnable runnable) {
        getInstance().showToastDialog(activity, tip, QMUITipDialog.Builder.ICON_TYPE_INFO, runnable);
    }

    private void showLoadingDialog(Activity activity, String tip, int type) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (mTipDialog != null) {
            dismissLoadingDialog(activity);
        }
        mTipDialog = new QMUITipDialog.Builder(activity)
                .setIconType(type)
                .setTipWord(tip)
                .create();
        mTipDialog.show();
    }

    public static void dismissLoadingDialog(Activity activity) {
        getInstance().dismissDialog(activity);
    }

    private void showToastDialog(final Activity activity, String tip, int type, final Runnable runnable) {
        showLoadingDialog(activity, tip, type);

        HandlerUtil.runDelayedInUIThread(new Runnable() {
            @Override
            public void run() {
                dismissLoadingDialog(activity);
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, 800);
    }

    private void dismissDialog(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (mTipDialog != null) {
            mTipDialog.dismiss();
        }
    }
}
