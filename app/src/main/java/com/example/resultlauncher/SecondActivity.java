package com.example.resultlauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvoutput;
Button btnfinish;
String FirstName, SecondName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvoutput=findViewById(R.id.tvoutput);
        btnfinish=findViewById(R.id.btnfinish);
        Intent intent=getIntent();
        FirstName=getIntent().getStringExtra(MainActivity.Key_First_Name);
        SecondName=getIntent().getStringExtra(MainActivity.Key_Second_Name);
        tvoutput.setText(FirstName+""+ SecondName);
        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        Intent data=new Intent();
        data.setData(Uri.parse(FirstName+""+SecondName));
        setResult(RESULT_OK,data);
        super.finish();
    }
}