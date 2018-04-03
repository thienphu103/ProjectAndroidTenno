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

import com.example.a.projectapptenno.Adapter.Fragment_Tomorrow;
import com.example.a.projectapptenno.DetailActivity;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class FragmentTomorrowHomeActivity extends Fragment {
    View TomorrowFragment;
    ArrayList<Fragment_Setter_Getter> arrayList;
    ListView listView;
    Fragment_Tomorrow adapter;
    private TextView txt_tempSun;
    private TextView txt_tempNoon;
    private TextView txt_tempAfternoon;
    private TextView txt_tempNight;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TomorrowFragment = inflater.inflate(R.layout.fragment_tomorrow_home, container, false);
        initControl();
        initData();
        initEvent();
        return TomorrowFragment;
    }

    private void initEvent() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Weather", MODE_PRIVATE);
        String weather_today = sharedPreferences.getString("weather_tomorrow", null);
        txt_tempSun.setText(weather_today);
        txt_tempNoon.setText(weather_today);
        txt_tempAfternoon.setText(weather_today);
        txt_tempNight.setText(weather_today);
    }

    private void initControl() {
        listView = (ListView) TomorrowFragment.findViewById(R.id.lst_fragment_tomorrow);
        txt_tempSun=(TextView) TomorrowFragment.findViewById(R.id.txt_doCSun_tomorrow);
        txt_tempNoon=(TextView) TomorrowFragment.findViewById(R.id.txt_doCNoon_tomorrow);
        txt_tempAfternoon=(TextView) TomorrowFragment.findViewById(R.id.txt_doCAfternoon_tomorrow);
        txt_tempNight=(TextView) TomorrowFragment.findViewById(R.id.txt_doCNight_tomorrow);
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
        adapter = new Fragment_Tomorrow(arrayList,getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent Tomorrow2_Detai = new Intent(getActivity(), DetailActivity.class);
                startActivity(Tomorrow2_Detai);
            }
        });

    }
}
