package com.nishitpanchal395.costme;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Custom_Adapter_Other extends ArrayAdapter<List_addProducts> {


    public Custom_Adapter_Other(Context context, List<List_addProducts> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if(StorageClass.temp_string_data==null){
//            StorageClass.temp_string_data=new ArrayList<>();
//        }



        if (StorageClass.list_add_2customers_others == null) {
            StorageClass.list_add_2customers_others = new ArrayList<>();
        }


        // Get the data item for this position
        List_addProducts user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout_other, parent, false);
        }
        // Lookup view for data population
        TextView h1 = (TextView) convertView.findViewById(R.id.product_name_list_text_other);
        TextView h2 = (TextView) convertView.findViewById(R.id.list_text_stock_other);
        TextView h3 = (TextView) convertView.findViewById(R.id.list_text_price_other);
        TextView h4 = (TextView) convertView.findViewById(R.id.list_text_last_price_other);
        EditText e1 = (EditText) convertView.findViewById(R.id.list_stock_qty_other);
        EditText e2 = (EditText) convertView.findViewById(R.id.list_stock_discount_other);
        CheckBox c1 = (CheckBox) convertView.findViewById(R.id.list_get_checkbox_other);



        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Enter requirement first", Toast.LENGTH_SHORT).show();
                        buttonView.setChecked(false);
                    } else {
                        Log.v("asdf", position + " is checked");


//                        StorageClass.list_add_2customers_others.add(new list_add_customers_others("asdf",45,80,45));
                        String afg1 = PrefConfigForProducts.readinPref(getContext()).get(position).ProductName;
                        int afg2 = PrefConfigForProducts.readinPref(getContext()).get(position).CustomerPrice;
                        String adg3temp = e1.getText().toString();
                        int adg3 = Integer.parseInt(adg3temp);
                        String adg4temp = e2.getText().toString();
                        int adg4 = Integer.parseInt(adg4temp);


                        StorageClass.list_add_2customers_others.add(new list_add_customers_others(afg1, adg3, adg4, adg3 * afg2));


                        Log.v("asvf", StorageClass.list_add_2customers_others.get(0).Productname + "");
//                        StorageClass.temp_string_data.add(e1.getText().toString());
//                        StorageClass.temp_string_data.add(e2.getText().toString());
                        Log.v("asvf", e1.getText().toString());
//                        Log.v("asvf",StorageClass.temp_string_data.size()+"");
                    }


                } else if (isChecked == false) {
                    StorageClass.list_add_2customers_others.remove(position);
                }


//                else {
//                    Log.v("asdf", position + " not checked");
////                    StorageClass.temp_string_data.remove(position);
//                }
            }
        });


        // Populate the data into the template view using the data object

        h1.setText(user.ProductName + "(" + user.BrandName + ")");
        h2.setText("in Stock: " + user.Quantity);
        h3.setText("Price: " + user.CustomerPrice + " Rs");
        h4.setText("Last Price: " + user.CustomerLastPrice + " RS");


        // Return the completed view to render on screen
        return convertView;
    }

}
