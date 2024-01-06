package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences shPref;
        shPref=getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        EditText edit=(EditText) findViewById(R.id.editTextText);
        if(shPref.contains("Name")){
            Toast.makeText(this, "readed data", Toast.LENGTH_LONG).show();
            edit.setText(shPref.getString("Name",null));
        }

        Button btn1=(Button) findViewById(R.id.button);
        Button btn2=(Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit=(EditText) findViewById(R.id.editTextText);

                String txt=edit.getText().toString();
Toast.makeText(MainActivity.this,txt,Toast.LENGTH_LONG).show();
                SharedPreferences.Editor sEdit=shPref.edit();
                sEdit.putString(txt,"1111");
                sEdit.apply();

                Toast.makeText(MainActivity.this,"saved",Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username=(EditText) findViewById(R.id.inpt1);
                String name=username.getText().toString();

                String person=shPref.getString(name,"reza");
                Toast.makeText(MainActivity.this, person, Toast.LENGTH_SHORT).show();
            }
        });
    }
}