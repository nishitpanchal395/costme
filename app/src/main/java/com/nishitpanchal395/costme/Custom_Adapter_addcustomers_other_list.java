package com.nishitpanchal395.costme;

//Custom_Adapter_addcustomers_other_list

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Custom_Adapter_addcustomers_other_list extends ArrayAdapter<list_add_customers_others> {
    public Custom_Adapter_addcustomers_other_list(Context context, ArrayList<list_add_customers_others> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        list_add_customers_others user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            //need to chnage layout here
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_add_2customers_other, parent, false);
        }
        // Lookup view for data population
        TextView h1 = (TextView) convertView.findViewById(R.id.list_add_product_name_other);
        TextView h2 = (TextView) convertView.findViewById(R.id.list_Quantity_product_other);
        TextView h3 = (TextView) convertView.findViewById(R.id.list_Cost_product_other);

        // Populate the data into the template view using the data object

        h1.setText(user.Productname+"");
        h2.setText(user.Quantity+"");
        h3.setText(user.Price+"");

        // Return the completed view to render on screen
        return convertView;
    }
}

