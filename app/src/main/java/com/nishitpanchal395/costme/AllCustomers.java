package com.nishitpanchal395.costme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AllCustomers extends Fragment {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_all_customers,container,false);
        
        ListView listView=view.findViewById(R.id.ListView_InALLCus);


            CustomAdapter adapter = new CustomAdapter(getContext(), StorageClass.list_addCustomers = PrefConfig.readinPref(getContext()));
            listView.setAdapter(adapter);



//        ArrayList<List_addProducts> arrayList=new ArrayList<List_addProducts>();
//        arrayList.add(new List_addProducts("sdfdsf","sdfdsf",45,"sdfffbb",45,11,200,2323,"SDfdf",99999,"sdfsdf"));
//
//        CustomAdapter customAdapter=new CustomAdapter(getActivity(),arrayList);
//        listView.setAdapter(customAdapter);

//        ArrayAdapter adapter=new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(adapter);


        return view;
    }

}