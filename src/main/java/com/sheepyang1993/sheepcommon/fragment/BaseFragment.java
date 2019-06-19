package com.sheepyang1993.sheepcommon.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sheepyang1993.sheepcommon.utils.ListUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/5/25
 */
public abstract class BaseFragment extends Fragment {
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    private View rootView;
    private List<Disposable> mDisposableList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        //缓存的rootView需要判断是否已经被加过parent。
        //如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(rootView);
        initData();
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
    protected abstract void initView(View view);

    /**
     * 初始化界面数据
     */
    protected abstract void initData();

    public void putDisposable(Disposable disposable) {
        if (mDisposableList == null) {
            mDisposableList = new ArrayList<>();
        }
        mDisposableList.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clearDisposable();
    }

    public void clearDisposable() {
        if (ListUtil.isNotEmpty(mDisposableList)) {
            for (Disposable disposable : mDisposableList) {
                if (!disposable.isDisposed()) {
                    disposable.dispose();
                }
            }
            mDisposableList.clear();
            mDisposableList = null;
        }
    }
}
