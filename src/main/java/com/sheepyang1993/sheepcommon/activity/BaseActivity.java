package com.sheepyang1993.sheepcommon.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sheepyang1993.sheepcommon.utils.ListUtil;
import com.sheepyang1993.sheepcommon.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/5/19
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private List<Disposable> mDisposableList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initToolbar();
        initView();
        initData();
    }

    private void initToolbar() {
        mToolbar = findViewById(getToolbarId());
        if (mToolbar != null) {
            mToolbar.setLeftIvClickListener(this::onToolbarLeftClick);
        }
    }

    protected int getToolbarId() {
        return 0;
    }

    protected void onToolbarLeftClick(View v) {
        onBackPressed();
    }

    public void setToolbarTitle(String title) {
        if (mToolbar != null) {
            if (title == null) {
                mToolbar.setTitle("");
            } else {
                mToolbar.setTitle(title);
            }
        }
    }

    /**
     * 设置界面布局id
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化界面布局
     */
    protected abstract void initView();

    /**
     * 初始化界面数据
     */
    protected abstract void initData();


    public void putDisposable(Disposable d) {
        mDisposableList.add(d);
    }

    private void clearDisposable() {
        if (ListUtil.isNotEmpty(mDisposableList)) {
            for (Disposable disposable : mDisposableList) {
                disposable.dispose();
            }
            mDisposableList.clear();
            mDisposableList = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearDisposable();
    }
}
