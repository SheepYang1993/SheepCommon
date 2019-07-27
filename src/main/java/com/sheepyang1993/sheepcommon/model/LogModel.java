package com.sheepyang1993.sheepcommon.model;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/7/27
 */
public class LogModel {
    private long createTime;
    private String tag;
    private String msg;

    public LogModel(long createTime, String tag, String msg) {
        this.createTime = createTime;
        this.tag = tag;
        this.msg = msg;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
