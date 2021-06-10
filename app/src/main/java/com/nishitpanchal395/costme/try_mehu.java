package com.nishitpanchal395.costme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class try_mehu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_mehu);


        EditText editText1 = findViewById(R.id.edit_text1);
        EditText editText2 = findViewById(R.id.edit_text2);
        EditText editText3 = findViewById(R.id.edit_text3);
        EditText editText4 = findViewById(R.id.edit_text4);
        EditText editText5 = findViewById(R.id.edit_text5);
        EditText editText6 = findViewById(R.id.edit_text6);
        EditText editText7 = findViewById(R.id.edit_text7);
        EditText editText8 = findViewById(R.id.edit_text8);
        EditText editText9 = findViewById(R.id.edit_text9);
        EditText editText10 = findViewById(R.id.edit_text10);
        EditText editText11 = findViewById(R.id.edit_text11);
        CheckBox checkBox = findViewById(R.id.checkbox_date_purchase_inventory);
        ImageView cancel=findViewById(R.id.cancel_products);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(try_mehu.this,ManageInventory.class);
                startActivity(intent);
            }
        });




        //onClick listener on check box to set date on edit text
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Calendar calendar = Calendar.getInstance();
                    editText5.setText(DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime()));
                } else if (isChecked == false) {
                    editText5.setText("");
                }
            }
        });


        ImageView imageView = (ImageView) findViewById(R.id.save_products);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      if ( editText1.getText().toString().isEmpty()
                        || editText2.getText().toString().isEmpty()
                        || editText3.getText().toString().isEmpty()
                        || editText6.getText().toString().isEmpty()
                        || editText7.getText().toString().isEmpty()
                        || editText8.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Plz Enter require data", Toast.LENGTH_LONG).show();
                }

                else
                    {
                    String s1 = editText1.getText().toString();
                    String s2 = editText2.getText().toString();
                    String s3temp=editText3.getText().toString();
                    int s3 = Integer.parseInt(s3temp);
                    String s4 = editText4.getText().toString();
                    String s5 = editText5.getText().toString();
                    String s6temp=editText6.getText().toString();
                    int  s6 =Integer.parseInt(s6temp);
//                    int  s6 =editText6.getInputType();
                    String s7temp=editText7.getText().toString();
                    int  s7 = Integer.parseInt(s7temp);
//                    int s7=editText7.getInputType();
                    String s8temp=editText8.getText().toString();
                    int  s8 =Integer.parseInt(s8temp);
//                    int s8=editText8.getInputType();
                    String s9 = editText9.getText().toString();
                    String  s10 = editText10.getText().toString();
                    String s11 = editText11.getText().toString();

                    StorageClass.listAddProducts.add(new List_addProducts(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11));
                    PrefConfigForProducts.writeinPref(getApplicationContext(), StorageClass.listAddProducts);

                    Intent intent=new Intent(getApplicationContext(),ManageInventory.class);
                    startActivity(intent);
                    finish();
                }


            }
        });
    }
}