package com.nishitpanchal395.costme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class zzzzzz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zzzzzz);
        ListView listView=(ListView)findViewById(R.id.listhupagalnahi);
        if(StorageClass.list_add_2customers_others==null){
            StorageClass.list_add_2customers_others=new ArrayList<>();
        }
        Custom_Adapter_addcustomers_other_list custom_adapter_addcustomers_other_list=new Custom_Adapter_addcustomers_other_list(zzzzzz.this,StorageClass.list_add_2customers_others);
        listView.setAdapter(custom_adapter_addcustomers_other_list);


    }
}