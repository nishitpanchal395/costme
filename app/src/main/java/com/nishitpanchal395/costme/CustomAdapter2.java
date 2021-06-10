package com.nishitpanchal395.costme;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter2 extends ArrayAdapter<List_addProducts> {
    public CustomAdapter2(Context context, List<List_addProducts> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        List_addProducts user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_customhu, parent, false);
        }
        // Lookup view for data population
        TextView h1 = (TextView) convertView.findViewById(R.id.product_name_listview);
        TextView h2 = (TextView) convertView.findViewById(R.id.product_sale_price_list);
        TextView h3 = (TextView) convertView.findViewById(R.id.product_purchase_price_list);
        TextView h4 = (TextView) convertView.findViewById(R.id.product_inStock_list);

        // Populate the data into the template view using the data object

        h1.setText(user.ProductName+"("+user.BrandName+")");
        h2.setText(user.CustomerPrice+" Rs");
        h3.setText(user.OurPrice+" Rs");
        h4.setText(user.Quantity+"");





        // Return the completed view to render on screen
        return convertView;
    }
}


