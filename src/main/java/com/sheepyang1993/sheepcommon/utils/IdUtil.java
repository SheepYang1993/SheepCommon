package com.sheepyang1993.sheepcommon.utils;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.Utils;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/7/16 11:07
 * @describe Id相关工具类
 */
public class IdUtil {
    public static String getImei() {
        if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return "";
        }
        return PhoneUtils.getIMEI();
    }

    public static String getUuid() {
        return UUIDUtil.uuid();
    }
}
