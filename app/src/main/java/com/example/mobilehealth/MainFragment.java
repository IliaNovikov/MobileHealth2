package com.example.mobilehealth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapters.SectionAdapter;
import models.Section;

public class MainFragment extends Fragment {

    private List<Section> sections;
    private RecyclerView rvMain;
    private SectionAdapter sectionAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        init(view);
        rvMain.setAdapter(sectionAdapter);
//        rvMain.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return view;
    }
    private void init(View view){
        sections = new ArrayList<>();
        sections.add(new Section(R.drawable.pfc_icon, "БЖУ",  getResources().getColor(R.color.pfc_color)));
        sections.add(new Section(R.drawable.water_glass_icon, "Водный режим", getResources().getColor(R.color.water_regime_color)));
        sections.add(new Section(R.drawable.steps_icon, "Шаги", getResources().getColor(R.color.steps_color)));
        sections.add(new Section(R.drawable.medicine, "Лекарства", getResources().getColor(R.color.medicine_color)));
        sections.add(new Section(R.drawable.breath_icon, "Дыхательные техники", getResources().getColor(R.color.breath_color)));
        sections.add(new Section(R.drawable.workout_icon, "Тренировки", getResources().getColor(R.color.workout_color)));
        rvMain = view.findViewById(R.id.rvMain);
        sectionAdapter = new SectionAdapter(getContext(), sections);
    }
}