package com.example.a.projectapptenno.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class HomeTablayoutAdapter extends FragmentPagerAdapter {
    Context context;
    ArrayList<String> list_title_tab;
    ArrayList<Fragment> list_fragment;
    private int page_count = 3;

    public HomeTablayoutAdapter(FragmentManager fm,
                                Context context, ArrayList<String> list_title_tab,
                                ArrayList<Fragment> list_fragment) {
        super(fm);
        this.context = context;
        this.list_title_tab = list_title_tab;
        this.list_fragment = list_fragment;
    }

    public HomeTablayoutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_title_tab.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  list_title_tab.get(position);
    }
}
