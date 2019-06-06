package com.sheepyang1993.sheepcommon.adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sheepyang1993.sheepcommon.fragment.BaseFragment;
import com.sheepyang1993.sheepcommon.utils.ListUtil;

import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList;

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return ListUtil.isEmpty(mFragmentList) ? 0 : mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = mFragmentList.get(position).getArguments().getString(BaseFragment.EXTRA_TITLE);
        return title;
    }
}
