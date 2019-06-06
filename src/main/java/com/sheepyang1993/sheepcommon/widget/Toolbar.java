package com.sheepyang1993.sheepcommon.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sheepyang1993.sheepcommon.R;


/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/5/24 8:58
 * @describe 自定义的toolbar
 */
public class Toolbar extends LinearLayout {
    private OnClickListener mLeftIvClickListener;
    private ImageView mIvLeft;
    private TextView mTvTitle;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        inflate(context, R.layout.layout_tool_bar, this);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Toolbar);
        boolean showLeftImageView = typedArray.getBoolean(R.styleable.Toolbar_showLeftImageView, true);
        String title = typedArray.getString(R.styleable.Toolbar_title);
        typedArray.recycle();

        mTvTitle = findViewById(R.id.tvToolbarTitle);
        mIvLeft = findViewById(R.id.ivToolbarLeft);
        mIvLeft.setVisibility(showLeftImageView ? VISIBLE : INVISIBLE);
        mIvLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLeftIvClickListener != null) {
                    mLeftIvClickListener.onClick(v);
                }
            }
        });
        setTitle(title);
    }

    public void setTitle(String title) {
        if (mTvTitle != null && title != null) {
            mTvTitle.setText(title);
        }
    }

    public void setLeftIvClickListener(OnClickListener leftIvClickListener) {
        mLeftIvClickListener = leftIvClickListener;
    }
}
