package com.nishitpanchal395.costme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class UnavailableProducts extends Fragment {

    ListView listView;
    public List<List_addProducts> listUnavailableProducts;
    public List<List_addProducts> list_updated;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(list_updated==null){
            list_updated=new ArrayList<>();}

        listUnavailableProducts=PrefConfigForProducts.readinPref(getContext());


        for(int i=0;i<listUnavailableProducts.size();i++){
            if(list_updated==null){
                list_updated=new ArrayList<>();
            }
            if(listUnavailableProducts.get(i).Quantity==0){
                list_updated.add(listUnavailableProducts.get(i));
            }
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_unavailable_products, container, false);
        listView=view.findViewById(R.id.listview_unavailable_products);


        CustomAdapter2 customAdapter2=new CustomAdapter2(getContext(),list_updated);
        listView.setAdapter(customAdapter2);
        return view;
    }
}