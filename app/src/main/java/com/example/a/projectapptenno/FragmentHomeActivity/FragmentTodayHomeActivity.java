package com.example.a.projectapptenno.FragmentHomeActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a.projectapptenno.DetailActivity;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class FragmentTodayHomeActivity extends Fragment {
    View TodayFragment;
    ArrayList<Fragment_Setter_Getter> arrayList;
    ListView listView;
    com.example.a.projectapptenno.Adapter.Fragment adapter;
    private TextView txt_tempSun;
    private TextView txt_tempNoon;
    private TextView txt_tempAfternoon;
    private TextView txt_tempNight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TodayFragment = inflater.inflate(R.layout.fragment_today_home, container, false);
        initControl();
        initData();
        initEvent();
        return TodayFragment;
    }

    private void initEvent() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Weather", MODE_PRIVATE);
        String weather_today = sharedPreferences.getString("weather_today", null);
        txt_tempSun.setText(weather_today);
        txt_tempNoon.setText(weather_today);
        txt_tempAfternoon.setText(weather_today);
        txt_tempNight.setText(weather_today);

    }

    private void initControl() {
        listView = (ListView) TodayFragment.findViewById(R.id.lst_fragment);
        txt_tempSun=(TextView) TodayFragment.findViewById(R.id.txt_doCSun);
        txt_tempNoon=(TextView) TodayFragment.findViewById(R.id.txt_doCNoon);
        txt_tempAfternoon=(TextView) TodayFragment.findViewById(R.id.txt_doCAfternoon);
        txt_tempNight=(TextView) TodayFragment.findViewById(R.id.txt_doCNight);
    }

    private void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        adapter = new com.example.a.projectapptenno.Adapter.Fragment(arrayList,getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent Today_Detai = new Intent(getActivity(), DetailActivity.class);
                startActivity(Today_Detai);
            }
        });

    }
}
