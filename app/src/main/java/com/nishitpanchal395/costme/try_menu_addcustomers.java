package com.nishitpanchal395.costme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.microedition.khronos.egl.EGLDisplay;

public class try_menu_addcustomers extends AppCompatActivity {

//    String cgb;

    public static final String SHOP_OTHER = "mehubaba";
    SharedPreferences sharedPreferences;
    public static ArrayList<list_add_customers_others> arrayListforitemsother;

    public EditText editText;
    public EditText editText2;
    public EditText editText3;
    public EditText editText4;
    public EditText editText5;
    public EditText editText6;
    public EditText editText7;
    public EditText editText8;
    public EditText editText9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_menu_addcustomers);


        //temp array to try
//        ArrayList<list_add_customers_others> temparrayforfun = new ArrayList<>();
//        temparrayforfun.add(new list_add_customers_others("Adsf", 45, 56, 852));

        //


        if (StorageClass.list_add_2customers_others == null) {
            StorageClass.list_add_2customers_others = new ArrayList<>();
        }
        if(StorageClass.listAddProducts==null){
            StorageClass.listAddProducts=new ArrayList<>();
        }
        if(StorageClass.list_addCustomers==null){
            StorageClass.list_addCustomers=new ArrayList<>();
        }

        ListView listView = (ListView) findViewById(R.id.list_addcustomers_other);
        Custom_Adapter_addcustomers_other_list adapter_addcustomers_other_list = new Custom_Adapter_addcustomers_other_list(try_menu_addcustomers.this, StorageClass.list_add_2customers_others);
        listView.setAdapter(adapter_addcustomers_other_list);
        Log.v("lkjh1",StorageClass.list_add_2customers_others.size()+"");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(try_menu_addcustomers.this, "Long Press to Delete item", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item=position;

                new AlertDialog.Builder(try_menu_addcustomers.this)
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setTitle("Are you sure ?")
                        .setMessage("Do you want to delete this item!")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StorageClass.list_add_2customers_others.remove(which_item);
                                adapter_addcustomers_other_list.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("no",null)
                        .show();

                return true;
            }
        });



        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });



        //Creating objects of xml elements
        editText = findViewById(R.id.Customer_name);
        editText2 = findViewById(R.id.customer_number);
        editText3 = findViewById(R.id.customer_location);
        editText4 = findViewById(R.id.date_purchase);

        editText5 = findViewById(R.id.Product_names);
        editText6 = findViewById(R.id.Total_cost);
        editText7 = findViewById(R.id.Due_amount);
        editText8 = findViewById(R.id.Paid_amount);
        editText9 = findViewById(R.id.LAst_pay_date);
        ImageView imageView = findViewById(R.id.save_customer);
        CheckBox checkBox = findViewById(R.id.date_today);
        Button button = findViewById(R.id.other_customers);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getApplicationContext().getSharedPreferences(SHOP_OTHER, MODE_PRIVATE);
                SharedPreferences.Editor editor_temp = sharedPreferences.edit();
                editor_temp.putString("dcv1", editText.getText().toString());
                editor_temp.putString("dcv2", editText2.getText().toString());
                editor_temp.putString("dcv3", editText3.getText().toString());
                editor_temp.putString("dcv4", editText4.getText().toString());
                editor_temp.putString("dcv5",editText5.getText().toString());
                editor_temp.apply();
                Intent intent = new Intent(try_menu_addcustomers.this, Other_customers.class);
                startActivity(intent);
            }
        });


        //onClick listener on check box to set date on edit text
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Calendar calendar = Calendar.getInstance();
                    editText4.setText(DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime()));
                } else if (isChecked == false) {
                    editText4.setText("");
                }
            }
        });

        //onClick Listner o imageview to save data in arraylist
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty() || editText2.getText().toString().isEmpty()||StorageClass.list_add_2customers_others.isEmpty() || editText6.getText().toString().isEmpty()|| editText7.getText().toString().isEmpty()||editText8.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Plz Enter Required data", Toast.LENGTH_LONG).show();
                } else {
                    String s1 = editText.getText().toString();
                    String s2temp = editText2.getText().toString();
                    int s2 = Integer.parseInt(s2temp);
                    String s3 = editText3.getText().toString();
                    String s4 = editText4.getText().toString();

                    String s5 = editText5.getText().toString();
                    String s6temp = editText6.getText().toString();
                    int s6 = Integer.parseInt(s6temp);
                    String s7temp = editText7.getText().toString();
                    int s7 = Integer.parseInt(s7temp);
                    String s8temp = editText8.getText().toString();
                    int s8 = Integer.parseInt(s8temp);
                    String s9 = editText9.getText().toString();
//                    arrayListforitemsother = new ArrayList<>();

                    StorageClass.list_addCustomers.add(new List_addCustomers(s1+"", s2, s3+"", s4+"", StorageClass.list_add_2customers_others, s5+"", s6, s7, s8, s9+""));
                    PrefConfig.writeinPref(getApplicationContext(), StorageClass.list_addCustomers);

                    Intent intent = new Intent(try_menu_addcustomers.this, MainActivity2.class);
                    startActivity(intent);

                }

            }
        });




        if (StorageClass.other_cus) {
            sharedPreferences = getApplicationContext().getSharedPreferences(SHOP_OTHER, MODE_PRIVATE);
            editText.setText(sharedPreferences.getString("dcv1", ""));
            editText2.setText(sharedPreferences.getString("dcv2", ""));
            editText3.setText(sharedPreferences.getString("dcv3", ""));
            editText4.setText(sharedPreferences.getString("dcv4", ""));
            editText5.setText(sharedPreferences.getString("dcv5", ""));


//            Log.v("mbxx", temparrayforfun.size() + "  c");
//            for (String s : StorageClass.temp_string_data) {
//                 cgb+=s+"\n";
//            }
//            editText5.setText(cgb);
        }


    }
}