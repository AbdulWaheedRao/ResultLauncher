package com.example.resultlauncher;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String Key_First_Name="FirstName";
    public static final String Key_Second_Name="SecondName";

TextView tvworld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvworld=findViewById(R.id.tvworld);
        ActivityResultLauncher<Void> secondLauncher=registerForActivityResult(new SecondActivityContract(), new ActivityResultCallback<String>() {
            @Override
            public void onActivityResult(String result) {
                Toast.makeText(MainActivity.this, ""+result, Toast.LENGTH_SHORT).show();
            }
        });
        tvworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondLauncher.launch(null);
            }
        });
    }
    class SecondActivityContract extends ActivityResultContract<Void,String>{

        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Void input) {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra(Key_First_Name,"Haseeb");
            intent.putExtra(Key_Second_Name,"Ali");
            return intent;
        }

        @Override
        public String parseResult(int resultCode, @Nullable Intent intent) {
            String result=null;
            if (resultCode==RESULT_OK){
                result=intent.getData().toString();
            }
            return null;
        }
    }
}


