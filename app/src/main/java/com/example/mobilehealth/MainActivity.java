package com.example.mobilehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import services.FragmentService;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
        FragmentService.setFragment(this, new MainFragment(), R.id.main_frameLayout);
    }
    private void init(){
        frameLayout = findViewById(R.id.main_frameLayout);
    }
}