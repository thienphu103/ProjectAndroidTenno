package com.example.a.projectapptenno.FragmentHomeActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a.projectapptenno.Adapter.Fragment_Tomorrow;
import com.example.a.projectapptenno.DetailActivity;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;

import java.util.ArrayList;

public class FragmentTomorrowHomeActivity extends Fragment {
    View TomorrowFragment;
    ArrayList<Fragment_Setter_Getter> arrayList;
    ListView listView;
    Fragment_Tomorrow adapter;
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
    }

    private void initControl() {
        listView = (ListView) TomorrowFragment.findViewById(R.id.lst_fragment_tomorrow);
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
