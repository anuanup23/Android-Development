package com.example.codingblocks_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        tvResult = findViewById(R.id.tvResult);
        Intent parent = getIntent();
        int result = parent.getIntExtra("result", 0);
        tvResult.setText(String.valueOf(result));
    }
}