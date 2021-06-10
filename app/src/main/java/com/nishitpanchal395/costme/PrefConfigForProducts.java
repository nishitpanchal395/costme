package com.nishitpanchal395.costme;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrefConfigForProducts {
    private static final String LIST_KEY_PRODUCTS = "List_Key_Products";

    public static void writeinPref(Context context, List<List_addProducts> list_addProducts2){
        Gson gson2=new Gson();
        String jsonString2=gson2.toJson(list_addProducts2);
        SharedPreferences sharedPreferences2= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor2=sharedPreferences2.edit();
        editor2.putString(LIST_KEY_PRODUCTS,jsonString2);
        editor2.apply();
    }

    public  static List<List_addProducts> readinPref(Context context){
        SharedPreferences sharedPreferences2=PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString2=sharedPreferences2.getString(LIST_KEY_PRODUCTS,"");
        Gson gson2=new Gson();
        Type type2=new TypeToken<ArrayList<List_addProducts>>() {}.getType();
        List<List_addProducts> list_addProducts2=gson2.fromJson(jsonString2,type2);
        if(list_addProducts2==null){
            list_addProducts2=new ArrayList<>();
        }
////        for(int i=0;i<list_addProducts2.size();i++){
//        int adsfd=list_addProducts2.get(0).Quantity;
//
//        Log.d("asdbb",adsfd+"adf");
////        }






        return list_addProducts2;
    }
}
