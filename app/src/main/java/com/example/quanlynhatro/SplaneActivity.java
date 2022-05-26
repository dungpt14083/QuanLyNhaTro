package com.example.quanlynhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplaneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splane);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(SplaneActivity.this,DangNhapActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}