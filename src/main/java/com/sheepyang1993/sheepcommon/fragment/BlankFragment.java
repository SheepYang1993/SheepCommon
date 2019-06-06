package com.sheepyang1993.sheepcommon.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sheepyang1993.sheepcommon.R;

/**
 * 空白的Fragment
 *
 * @author SheepYang
 */
public class BlankFragment extends BaseFragment {
    private static final String EXTRA_CONTENT = "content";

    public static BlankFragment newInstance(String title, String content) {
        Bundle args = new Bundle();
        args.putString(EXTRA_TITLE, title);
        args.putString(EXTRA_CONTENT, content);
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String content = getArguments().getString(EXTRA_CONTENT);
        TextView textView = new TextView(getContext());
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.CommonC02));
        textView.setText(String.format("这是空白页面\n\n%s", content));
        textView.setBackgroundColor(getResources().getColor(R.color.CommonC01));
        return textView;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }
}
