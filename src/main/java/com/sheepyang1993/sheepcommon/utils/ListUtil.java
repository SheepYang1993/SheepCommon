package com.sheepyang1993.sheepcommon.utils;

import java.util.List;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/5/25
 */
public class ListUtil {
    public static boolean isEmpty(List list) {
        if (list == null) {
            return true;
        } else if (list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }
}
