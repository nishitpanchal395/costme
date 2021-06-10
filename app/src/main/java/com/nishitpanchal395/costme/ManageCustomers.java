package com.nishitpanchal395.costme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ManageCustomers extends AppCompatActivity {
    TabLayout tabLayout1;
    TabItem tabItem1,tabItem2,tabItem3;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_customers);
//        if(StorageClass.temp_string_data==null){
//            StorageClass.temp_string_data=new ArrayList<>();
//        }

        if(StorageClass.list_add_2customers_others==null){
            StorageClass.list_add_2customers_others=new ArrayList<>();
        }

        toolbar=findViewById(R.id.toolbar_manage_customers);
        tabLayout1=(TabLayout)findViewById(R.id.tablayout1_customers);
        tabItem1=(TabItem)findViewById(R.id.tab1_cus);
        tabItem2=(TabItem)findViewById(R.id.tab2_cus);
        tabItem3=(TabItem)findViewById(R.id.tab2_cus);
        viewPager=(ViewPager)findViewById(R.id.viewpage1_customers);

        setSupportActionBar(toolbar);


        pageAdapter=new PageAdapter(getSupportFragmentManager(),tabLayout1.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 ||tab.getPosition()==1 ||tab.getPosition()==2 )
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
                StorageClass.other_cus=false;
                StorageClass.array_show_other=false;
                if(StorageClass.array_show_other==false){
                    StorageClass.list_add_2customers_others.clear();
                }
//                StorageClass.clear(StorageClass.temp_string_data);
                Intent intent=new Intent(ManageCustomers.this,try_menu_addcustomers.class);
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