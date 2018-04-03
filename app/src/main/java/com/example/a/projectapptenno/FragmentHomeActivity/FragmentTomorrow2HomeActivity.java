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

import com.example.a.projectapptenno.Adapter.Fragment_Tomorrow2;
import com.example.a.projectapptenno.DetailActivity;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class FragmentTomorrow2HomeActivity extends Fragment {
    View TomorrowFragment2;
    ArrayList<Fragment_Setter_Getter> arrayList;
    ListView listView;
    Fragment_Tomorrow2 adapter;
    private TextView txt_tempSun;
    private TextView txt_tempNoon;
    private TextView txt_tempAfternoon;
    private TextView txt_tempNight;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TomorrowFragment2 = inflater.inflate(R.layout.fragment_tomorrow2_home, container, false);
        initControl();
        initData();
        initEvent();
        return TomorrowFragment2;
    }

    private void initEvent() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Weather", MODE_PRIVATE);
        String weather_today = sharedPreferences.getString("weather_tomorrow2", null);
        txt_tempSun.setText(weather_today);
        txt_tempNoon.setText(weather_today);
        txt_tempAfternoon.setText(weather_today);
        txt_tempNight.setText(weather_today);

    }

    private void initControl() {
        listView = (ListView) TomorrowFragment2.findViewById(R.id.lst_fragment_tomorrow2);
        txt_tempSun=(TextView) TomorrowFragment2.findViewById(R.id.txt_doCSun_tomorrow2);
        txt_tempNoon=(TextView) TomorrowFragment2.findViewById(R.id.txt_doCNoon_tomorrow2);
        txt_tempAfternoon=(TextView) TomorrowFragment2.findViewById(R.id.txt_doCAfternoon_tomorrow2);
        txt_tempNight=(TextView) TomorrowFragment2.findViewById(R.id.txt_doCNight_tomorrow2);
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
        adapter = new Fragment_Tomorrow2(arrayList,getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent Tomorrow_Detai = new Intent(getActivity(), DetailActivity.class);
                startActivity(Tomorrow_Detai);
            }
        });

    }
}
