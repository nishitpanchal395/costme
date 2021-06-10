package com.nishitpanchal395.costme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Other_customers extends AppCompatActivity {

    public List<List_addProducts> ALlProducts_Other;
    try_menu_addcustomers addcustomers = new try_menu_addcustomers();
    ArrayList<String> stringArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_customers);
        ALlProducts_Other = PrefConfigForProducts.readinPref(Other_customers.this);
        ListView listView = (ListView) findViewById(R.id.listview_other);


        Custom_Adapter_Other custom_adapter_other = new Custom_Adapter_Other(Other_customers.this, PrefConfigForProducts.readinPref(Other_customers.this));
        listView.setAdapter(custom_adapter_other);




////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////
////                CheckBox checkBox = view.findViewById(R.id.list_get_checkbox_other);
////                TextView textView = view.findViewById(R.id.product_name_list_text_other);
////                TextView textView1 = view.findViewById(R.id.list_text_stock_other);
////                TextView textView2 = view.findViewById(R.id.list_text_price_other);
////                TextView textView3 = view.findViewById(R.id.list_text_last_price_other);
////                EditText editText = view.findViewById(R.id.list_stock_qty_other);
////                EditText editText2 = view.findViewById(R.id.list_stock_discount_other);
////
////
////                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
////                    @Override
////                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////                        if(isChecked){
////                            String dsaf = PrefConfigForProducts.readinPref(Other_customers.this).get(position).ProductName;
////                            Log.v("dsfsadf",dsaf);
////                            stringArrayList.add(dsaf);
////                        }
////                        if(isChecked==false){
////                            stringArrayList.remove(position);
////                        }
////                    }
////                });
//
////                if (checkBox.isChecked()) {
////                    String dsaf = PrefConfigForProducts.readinPref(Other_customers.this).get(position).ProductName;
////                    stringArrayList.add(dsaf);
////                }
//
//
//            }
//        });
//
//
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_other, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.other_search:
                break;
            case R.id.remove_other:

                Intent intent = new Intent(this, ManageCustomers.class);
                startActivity(intent);
                finish();
                break;
            case R.id.addmore:

                StorageClass.other_cus = true;
                Intent intent1 = new Intent(Other_customers.this, try_menu_addcustomers.class);
                startActivity(intent1);
                finish();
                break;

        }
        return true;
    }
}