package com.example.mobilehealth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class BreathTechnicFragment extends Fragment {

    private TextView tvName;
    private TextView tvContent;
    private DatabaseReference breathsDatabase;

    private String breathsTechnicName = "";

    private String breathsTechnicContent = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_breath_technic, container, false);
        tvName = view.findViewById(R.id.tvName);
        tvContent = view.findViewById(R.id.tvContent);
        breathsDatabase = FirebaseDatabase.getInstance().getReference();

        breathsDatabase.child("BreathTechnics").child("technic1").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if(task.isSuccessful()){
                        breathsTechnicName = String.valueOf(task.getResult().child("Name").getValue());
                        breathsTechnicContent = String.valueOf(task.getResult().child("Content").getValue());
                        Log.e("breathName", breathsTechnicName);
                        Log.e("breathContent", breathsTechnicContent);
                        tvName.setText(breathsTechnicName);
                        tvContent.setText(breathsTechnicContent);
                    }
                    else{
                        Log.e("breath", "error");
                    }
            }
        });
        return view;
    }
}