package com.sheepyang1993.sheepcommon.exception;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/6/12 10:56
 * @describe 通用异常类
 */
public class SheepException extends Exception {
    private static final String DEFAULT_MSG = "默认异常, 没有异常信息";
    private String code;
    private String msg;

    public SheepException() {
        super(DEFAULT_MSG);
        this.msg = DEFAULT_MSG;
    }

    public SheepException(String message) {
        super(message);
        this.msg = message;
    }

    public SheepException(String code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code + "";
    }

    public void setCode(String code) {
        this.code = code;
    }
}
