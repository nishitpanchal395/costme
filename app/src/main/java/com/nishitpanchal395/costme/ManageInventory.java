package com.nishitpanchal395.costme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.io.InputStream;

public class ManageInventory extends AppCompatActivity {
    TabLayout tabLayout1;
    TabItem tabItem1,tabItem2,tabItem3;
    ViewPager viewPager;
    PageAdapter2 pageAdapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_inventory);


        toolbar=findViewById(R.id.toolbar_manage_customers);
        tabLayout1=(TabLayout)findViewById(R.id.tablayout2_inventory);
        tabItem1=(TabItem)findViewById(R.id.tab1_inv);
        tabItem2=(TabItem)findViewById(R.id.tab2_inv);
        tabItem3=(TabItem)findViewById(R.id.tab2_inv);
        viewPager=(ViewPager)findViewById(R.id.pageviewer2_inv);

        setSupportActionBar(toolbar);


        pageAdapter=new PageAdapter2(getSupportFragmentManager(),tabLayout1.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 ||tab.getPosition()==1 ||tab.getPosition()==2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.addmore:
                Intent intent=new Intent(ManageInventory.this,try_mehu.class);
                startActivity(intent);
                break;
            case R.id.app_bar_search:break;
            case R.id.item1:break;
            case R.id.item2:break;
            case R.id.item3:break;
        }
        return true;
    }
}