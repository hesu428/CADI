package com.example.haams.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        gIntent= getIntent();

        Toast.makeText(SecondActivity.this.gIntent.getStringExtra("name")
    }
}
