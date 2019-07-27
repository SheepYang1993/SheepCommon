package com.sheepyang1993.sheepcommon.utils;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/7/27
 */
public class StringUtil {
    public static boolean notEmpty(String[] args) {
        return !isEmpty(args);
    }

    public static boolean isEmpty(String[] args) {
        return args == null || args.length <= 0;
    }
}
