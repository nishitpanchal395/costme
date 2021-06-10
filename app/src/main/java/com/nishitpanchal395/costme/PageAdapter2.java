package com.nishitpanchal395.costme;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter2 extends FragmentPagerAdapter {
int count;
    public PageAdapter2(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new AllProducts();
            case 1:return new AvailableProducts();
            case 2:return new UnavailableProducts();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
