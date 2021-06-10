package com.nishitpanchal395.costme;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<List_addCustomers> {
    public CustomAdapter(Context context, List<List_addCustomers> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        List_addCustomers user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            //need to chnage layout here
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        // Lookup view for data population
        TextView h1 = (TextView) convertView.findViewById(android.R.id.text1);

        // Populate the data into the template view using the data object

        h1.setText(user.customerName);

        // Return the completed view to render on screen
        return convertView;
    }
}














//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import com.nishitpanchal395.costme.List_addProducts;
//
//import java.util.ArrayList;
//
//public class CustomAdapter extends ArrayAdapter<List_addProducts> {
//    public CustomAdapter(Context context, ArrayList<List_addProducts> users) {
//        super(context, 0, users);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Get the data item for this position
//        List_addProducts user = getItem(position);
//        // Check if an existing view is being reused, otherwise inflate the view
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
//        }
//        // Lookup view for data population
//        TextView a12 = (TextView) convertView.findViewById(R.id.textView5);
//        TextView  b13= (TextView) convertView.findViewById(R.id.textView4);
//        TextView  c14= (TextView) convertView.findViewById(R.id.textView6);
//        TextView  d15= (TextView) convertView.findViewById(R.id.textView7);
//        TextView  e16= (TextView) convertView.findViewById(R.id.textView8);
//        // Populate the data into the template view using the data object
//
//        a12.setText(user.ProductName);
//        b13.setText(user.ProductName);
//        c14.setText(user.ProductName);
//        d15.setText(user.ProductName);
//        e16.setText(user.ProductName);
//
//        // Return the completed view to render on screen
//        return convertView;
//    }
//}