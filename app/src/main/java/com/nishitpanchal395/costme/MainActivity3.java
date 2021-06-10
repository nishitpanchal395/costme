package com.nishitpanchal395.costme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;

    public static final String SHOP_INFO = "shopinfo";
    public static final String SHOP_INFO_BOOL = "mehubaba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText = findViewById(R.id.editTextTextPersonName2);
        editText2 = findViewById(R.id.editTextTextPersonName);
        editText3 = findViewById(R.id.editTextTextPersonName3);

        SharedPreferences sharedPreferences = getSharedPreferences(SHOP_INFO, MODE_PRIVATE);

        ImageView imageViewButton = findViewById(R.id.imageView_button);
        imageViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String s1 = editText.getText().toString();
                String s2 = editText2.getText().toString();
                String s3 = editText3.getText().toString();

                if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty()){
                    Toast.makeText(MainActivity3.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                else {


                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("str", s1);
                    editor.putString("str1", s2);
                    editor.putString("str2", s3);
                    editor.putBoolean(SHOP_INFO_BOOL,true);
                    editor.apply();

                    Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });


    }
}