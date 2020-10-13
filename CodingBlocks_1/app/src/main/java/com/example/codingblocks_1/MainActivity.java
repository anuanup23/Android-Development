package com.example.codingblocks_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MFA";
    TextView tvResult;
    EditText etVar1, etVar2, etWeburl;
    Button btnAdd;
    ImageButton btnBrowse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        btnAdd = findViewById(R.id.btnAdd);
        etWeburl = findViewById(R.id.tvWeburl);
        btnBrowse = findViewById(R.id.btnSearch);
        tvResult = findViewById((R.id.tvResult));
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int var1 = Integer.valueOf(etVar1.getText().toString());
                int var2 = Integer.valueOf(etVar2.getText().toString());
                int var3 = var1 + var2;
                tvResult.setText(String.valueOf(var3));
                // go to second activity by creating intent
                Intent i = new Intent(MainActivity.this, Second_Activity.class);
                i.putExtra("result", var3);
                startActivity(i);
            }
        });
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etWeburl.getText().toString();
                Uri uri = Uri.parse(url);
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                try{
                    startActivity(i);
                } catch(ActivityNotFoundException anfe){
                    Log.e(TAG, "could not open the app with given url");
                    Toast.makeText(MainActivity.this,
                            "could not find any app tp open this link",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}