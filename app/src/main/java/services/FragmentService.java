package services;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobilehealth.MainActivity;

public class FragmentService {
    public static void setFragment(Activity activity, Fragment fragment, int frameLayoutResource){
        MainActivity mainActivity = (MainActivity) activity;
        FragmentTransaction ft = mainActivity.getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayoutResource, fragment);
        ft.commit();
    }
}
