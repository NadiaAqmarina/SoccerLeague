package com.example.soccerleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText txtusername;
    EditText txtpassword;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("login", MODE_PRIVATE);
        txtusername = (EditText)findViewById(R.id.txtusername);
        txtpassword = (EditText)findViewById(R.id.txtpassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtusername.getText().toString().equalsIgnoreCase("nadia")
                        && txtpassword.getText().toString().equalsIgnoreCase("000")){
                    //saving ke SP
                    editor = pref.edit();
                    editor.putString("username", txtusername.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();
                    //menuju ke main menu
                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    finish();
                }
            }
        });
    }
}