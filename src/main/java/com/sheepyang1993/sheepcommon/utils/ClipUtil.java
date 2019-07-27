package com.sheepyang1993.sheepcommon.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.Utils;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/7/27
 * 复制工具
 */
public class ClipUtil {
    public static void copy(String text) {
        //获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager) Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("Label", text);
        // 将ClipData内容放到系统剪贴板里。
        if (ObjectUtils.isNotEmpty(cm)) {
            cm.setPrimaryClip(mClipData);
        }
    }
}
