package com.sheepyang1993.sheepcommon.adapter;

import com.blankj.utilcode.util.TimeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sheepyang1993.sheepcommon.R;
import com.sheepyang1993.sheepcommon.model.LogModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/7/27
 */
public class LogAdapter extends BaseQuickAdapter<LogModel, BaseViewHolder> {
    private DateFormat mFormat = new SimpleDateFormat("yyyy-dd-MM\nHH:mm:ss", Locale.getDefault());

    public LogAdapter() {
        super(R.layout.item_log);
    }

    @Override
    protected void convert(BaseViewHolder helper, LogModel item) {
        helper.setText(R.id.tvTime, TimeUtils.millis2String(item.getCreateTime(), mFormat));
        helper.setText(R.id.tvTag, item.getTag());
        helper.setText(R.id.tvLog, item.getMsg());
        helper.addOnLongClickListener(R.id.tvLog);
    }
}
