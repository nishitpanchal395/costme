package com.nishitpanchal395.costme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TodaysTask extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tabItem1,tabItem2;
    ViewPager viewPager;
    PageAdapter3 pageAdapter3;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_task);

        toolbar=findViewById(R.id.toolbar_manage_customers);
        tabLayout=(TabLayout)findViewById(R.id.tablayout3_task);
        tabItem1=(TabItem)findViewById(R.id.tab1_inv);
        tabItem2=(TabItem)findViewById(R.id.tab2_inv);
        viewPager=(ViewPager)findViewById(R.id.pageviewer3_task);
        pageAdapter3=new PageAdapter3(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter3);

        setSupportActionBar(toolbar);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1)
                    pageAdapter3.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.addmore:break;
            case R.id.app_bar_search:break;
            case R.id.item1:break;
            case R.id.item2:break;
            case R.id.item3:break;
        }
        return true;
    }
}