package services;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobilehealth.MainActivity;
import com.example.mobilehealth.R;

public class FragmentService {
    public static String currentFragmentTitle;
    public static int currentFragmentColor;
    public static void setFragment(Activity activity, Fragment fragment, int frameLayoutResource){
        MainActivity mainActivity = (MainActivity) activity;
        FragmentTransaction ft = mainActivity.getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayoutResource, fragment);
        ft.commit();
        mainActivity.setFragmentName(currentFragmentTitle);
        mainActivity.setFragmentColor(currentFragmentColor);
    }
}
