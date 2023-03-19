package com.example.mobilehealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import services.FragmentService;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private TextView tvFragmentName;
    private Toolbar toolbarMain;
    private String fragmentName;
    private int fragmentColor;

    public void setFragmentColor(int fragmentColor) {
        this.fragmentColor = fragmentColor;
        toolbarMain.setBackgroundColor(fragmentColor);
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
        tvFragmentName.setText(fragmentName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
        FragmentService.currentFragmentTitle = getString(R.string.main_page);
        FragmentService.currentFragmentColor = getColor(R.color.black);
        FragmentService.setFragment(this, new MainFragment(), R.id.main_frameLayout);
    }

    private void init(){
        frameLayout = findViewById(R.id.main_frameLayout);
        tvFragmentName = findViewById(R.id.tvFragmentName);
        toolbarMain = findViewById(R.id.toolbar);
    }
}