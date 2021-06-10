package com.nishitpanchal395.costme;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int count;
    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new AllCustomers();
            case 1: return new DueCustomers();
            case 2: return new PaidCustomes();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
