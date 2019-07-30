package com.sheepyang1993.sheepcommon.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;

import com.blankj.utilcode.util.RegexUtils;
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
    private String mFilterStr = "";
    private DateFormat mFormat = new SimpleDateFormat("HH:mm:ss SSS", Locale.getDefault());

    public LogAdapter() {
        super(R.layout.item_log);
    }

    @Override
    protected void convert(BaseViewHolder helper, LogModel item) {
        String tag = item.getTag();
        helper.setText(R.id.tvTime, TimeUtils.millis2String(item.getCreateTime(), mFormat));
        helper.setText(R.id.tvTag, tag);
        helper.setText(R.id.tvLog, item.getMsg());
        helper.addOnLongClickListener(R.id.tvLog);
        if (!TextUtils.isEmpty(mFilterStr)) {
            boolean show = mFilterStr.contains(tag);
            hideItem(helper, show);
        } else {
            hideItem(helper, true);
        }
    }

    private void hideItem(BaseViewHolder helper, boolean show) {
        ViewGroup.LayoutParams lp = helper.itemView.getLayoutParams();
        if (show) {
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else {
            lp.height = 0;
        }
        helper.itemView.setLayoutParams(lp);
    }

    public void setFilterStr(String filterStr) {
        mFilterStr = filterStr;
        notifyDataSetChanged();
    }
}
