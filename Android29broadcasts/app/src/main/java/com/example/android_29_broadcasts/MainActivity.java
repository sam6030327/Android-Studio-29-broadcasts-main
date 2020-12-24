package com.example.android_29_broadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, phone, gender;
    Button save, clear, read, clean;
    String Name = "Name Key";
    String Phone = "Phone Key";
    String Gender = "Man/Woman Key";

    SharedPreferences data;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditView
        name = findViewById(R.id.ed1);
        phone = findViewById(R.id.ed2);
        gender = findViewById(R.id.ed3);
        //Button
        save = findViewById(R.id.bt1);
        clear = findViewById(R.id.bt2);
        read = findViewById(R.id.bt3);
        clean = findViewById(R.id.bt4);

        data = getSharedPreferences("userData", Context.MODE_PRIVATE);

        //儲存單元
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = data.edit();
                editor.putString(Name, name.getText().toString());
                editor.putString(Phone, phone.getText().toString());
                editor.putString(Gender, gender.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this, "Save", Toast.LENGTH_SHORT).show();
            }
        });
        //讀取單元
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.contains(Name)){
                    name.setText(data.getString(Name, ""));
                }
                if (data.contains(Phone)){
                    phone.setText(data.getString(Phone, ""));
                }
                if (data.contains(Gender)){
                    gender.setText(data.getString(Gender, ""));
                }
                Toast.makeText(MainActivity.this, "Read", Toast.LENGTH_SHORT).show();
            }
        });
        //清除單元
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove(Name);
                editor.remove(Phone);
                editor.remove(Gender);
                editor.apply();
                Toast.makeText(MainActivity.this, "Clear", Toast.LENGTH_SHORT).show();

            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                phone.setText("");
                gender.setText("");
            }
        });
    }
}