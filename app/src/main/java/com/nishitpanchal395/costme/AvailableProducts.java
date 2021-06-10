package com.nishitpanchal395.costme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AvailableProducts extends Fragment {
    ListView listView;
    public List<List_addProducts> listAvailableProducts;
    public List<List_addProducts> list_updated_available;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(list_updated_available==null){
            list_updated_available=new ArrayList<>();
        }


        listAvailableProducts=PrefConfigForProducts.readinPref(getContext());


        for(int i=0;i<listAvailableProducts.size();i++){

            if(listAvailableProducts.get(i).Quantity!=0){
                list_updated_available.add(listAvailableProducts.get(i));
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_available_products, container, false);
        listView=view.findViewById(R.id.listView_available_products);
        CustomAdapter2 customAdapter2=new CustomAdapter2(getContext(),list_updated_available);
        listView.setAdapter(customAdapter2);
        return view;
    }
}
