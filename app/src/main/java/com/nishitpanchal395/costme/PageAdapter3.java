package com.nishitpanchal395.costme;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter3 extends FragmentPagerAdapter {
    int count;
    public PageAdapter3(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new task_unavailableProducts();
            case 1:return new task_DueCustomers();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
