package com.nishitpanchal395.costme;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrefConfig {

    private static final String LIST_KEY = "List_Key";

    public static void writeinPref(Context context, List<List_addCustomers> list_addCustomers){
        Gson gson=new Gson();
        String jsonString=gson.toJson(list_addCustomers);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(LIST_KEY,jsonString);
        editor.apply();
    }

    public  static List<List_addCustomers> readinPref(Context context){
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString=sharedPreferences.getString(LIST_KEY,"");
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<List_addCustomers>>() {}.getType();
        List<List_addCustomers> list_addCustomers=gson.fromJson(jsonString,type);
        if(list_addCustomers==null){
            list_addCustomers=new ArrayList<>();
        }
        return list_addCustomers;
    }


}

