package com.sheepyang1993.sheepcommon.http.response;

import java.io.Serializable;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/5/27 22:00
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class LzyResponse<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    public int code;
    public String msg;
    public T result;

    @Override
    public String toString() {
        return "LzyResponse{\n" +//
                "\tcode=" + code + "\n" +//
                "\tmsg='" + msg + "\'\n" +//
                "\tresult=" + result + "\n" +//
                '}';
    }
}