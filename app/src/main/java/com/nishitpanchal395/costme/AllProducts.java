package com.nishitpanchal395.costme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AllProducts extends Fragment {
    public List<List_addProducts> listUnavailableProducts;
    public List<List_addProducts> list_updated;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageClass.listAddProducts = PrefConfigForProducts.readinPref(getContext());
//         listUnavailableProducts= PrefConfigForProducts.readinPref(getContext());

//        Log.v("plplpl",String.valueOf(PrefConfigForProducts.readinPref(getContext()).get(1).Quantity));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_all_products, container, false);
        ListView listView=(ListView)view.findViewById(R.id.add_product);
//        StorageClass.listAddProducts = PrefConfigForProducts.readinPref(getContext());

        CustomAdapter2 customAdapter=new CustomAdapter2(getContext(),PrefConfigForProducts.readinPref(getContext()));
        listView.setAdapter(customAdapter);

//        Toast.makeText(getContext(), sfd, Toast.LENGTH_SHORT).show();
//        for(int i=0;i<StorageClass.listAddProducts.size();i++){
//            if(StorageClass.listAddProducts.get(i).Quantity.equals(0)){
//                Toast.makeText(getContext(), "yes 0", Toast.LENGTH_SHORT).show();
//            }
//        }


        return view;
    }
}