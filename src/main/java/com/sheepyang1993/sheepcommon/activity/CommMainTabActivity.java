package com.sheepyang1993.sheepcommon.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.sheepyang1993.sheepcommon.R;
import com.sheepyang1993.sheepcommon.adapter.MyViewPagerAdapter;
import com.sheepyang1993.sheepcommon.fragment.BaseFragment;
import com.sheepyang1993.sheepcommon.utils.ListUtil;

import java.util.List;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/7
 * 通用的主页框架
 * 三个tab
 */
public abstract class CommMainTabActivity extends BaseActivity {
    private long mExitTime;
    private List<Fragment> mFragmentList;
    private ViewPager mViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public abstract List<Fragment> initFragment();

    @Override
    protected void initView() {
        SmartTabLayout tabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
        setFragmentList(initFragment());
        mViewPager.setOffscreenPageLimit(3);
        tabLayout.setCustomTabView(R.layout.layout_tab, R.id.tvTab);
        tabLayout.setViewPager(mViewPager);
        tabLayout.setOnTabClickListener(position -> {
            if (ListUtil.isNotEmpty(mFragmentList) && mFragmentList.get(position) != null
                    && mFragmentList.get(position).getArguments() != null
                    && !TextUtils.isEmpty(mFragmentList.get(position).getArguments().getString(BaseFragment.EXTRA_TITLE))) {
                String title = mFragmentList.get(position).getArguments().getString(BaseFragment.EXTRA_TITLE);
                setToolbarTitle(title);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //与上次点击返回键时刻作差
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            //大于2000ms则认为是误操作，使用Toast进行提示
            ToastUtils.showShort("再按一次退出程序");
            //并记录下本次点击“返回键”的时刻，以便下次进行判断
            mExitTime = System.currentTimeMillis();
        } else {
            //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
            super.onBackPressed();
        }
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        mFragmentList = fragmentList;
        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList));
    }
}
