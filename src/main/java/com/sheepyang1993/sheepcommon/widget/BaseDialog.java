package com.sheepyang1993.sheepcommon.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.sheepyang1993.sheepcommon.R;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/11
 */
public abstract class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        super(context, R.style.CommonDialog);
        initView(context);
    }

    /**
     * 初始化界面
     */
    protected abstract void initView(@NonNull Context context);
}
