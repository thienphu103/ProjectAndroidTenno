package com.example.a.projectapptenno.FragmentHomeActivity;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a.projectapptenno.Adapter.Fragment_Tomorrow2;
import com.example.a.projectapptenno.DetailActivity;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private ProgressDialog mProgressDialog;
    private String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/crud.php";
    private String weather_today_text="";
    private String id_temp;

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
        if (weather_today != null) {
            weather_today_text = weather_today.substring(0, 2);
        }
        txt_tempSun.setText(String.valueOf(Integer.parseInt(weather_today.substring(0, 2)) - 3) + "°C");
        txt_tempNoon.setText(String.valueOf(Integer.parseInt(weather_today.substring(0, 2)) + 2) + "°C");
        txt_tempAfternoon.setText(String.valueOf(Integer.parseInt(weather_today.substring(0, 2)) - 2) + "°C");
        txt_tempNight.setText(String.valueOf(Integer.parseInt(weather_today.substring(0, 2)) - 4) + "°C");
        int temp = Integer.parseInt(weather_today.substring(0, 2));
        if (13 > temp ) {
            id_temp = "1";
        }
        if (13 < temp && temp <= 20) {
            id_temp = "2";
        }
        else if (20 < temp && temp <= 28) {
            id_temp = "3";
        }
        else if (28 < temp && temp <= 32) {
            id_temp = "4";
        }
        else if (32 < temp && temp <= 36) {
            id_temp = "5";
        }
        else if (temp > 36) {
            id_temp = "6";
        }
//        Toast.makeText(getContext(), "Chỉ Số Gợi Ý Ngày Mai " + "[" + temp + "_" + id_temp + "]", Toast.LENGTH_LONG).show();
        initDisplay(id_temp);
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
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Fragment_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        adapter = new Fragment_Tomorrow2(arrayList,getActivity());
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent Tomorrow_Detai = new Intent(getActivity(), DetailActivity.class);
//                startActivity(Tomorrow_Detai);
//            }
//        });

    }
    private void initDisplay(final String id_temp) {
        Toast.makeText(getActivity(), "loading database ", Toast.LENGTH_SHORT).show();
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            arrayList = new ArrayList<>();
                            JSONArray array = new JSONArray(response);
                            JSONObject object = null;
                            String TITLE = "";
                            String MEAL;
                            String ID;
                            String IMAGE;

                            for (int i = 0; i < array.length(); i++) {
                                object = array.getJSONObject(i);
                                ID = object.getString("ID");
                                MEAL = object.getString("MEAL");
                                TITLE = object.getString("TITLE");
                                IMAGE = object.getString("IMAGE");
                                arrayList.add(new Fragment_Setter_Getter(IMAGE, ID, MEAL, TITLE));
                                Log.d("JS0Ndata", TITLE + "");
                            }
                            Log.d("JS0NTemp", id_temp + "");

                            adapter = new com.example.a.projectapptenno.Adapter.Fragment_Tomorrow2(arrayList, getActivity());
                            adapter.notifyDataSetChanged();
                            if (arrayList.size() > 0) {
                                listView.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                            }
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Toast.makeText(getContext(), "ID: " + arrayList.get(position).getTxt_id() + ", Name: " + arrayList.get(position).getTxt_monan(), Toast.LENGTH_SHORT).show();
                                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("Food", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("id_food",arrayList.get(position).getTxt_id()+"");
                                    editor.commit();
                                    Intent Today_Detai = new Intent(getActivity(), DetailActivity.class);
                                    startActivity(Today_Detai);
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Exception " + e, Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), "" + error, Toast.LENGTH_SHORT).show();
                Log.d("error", error + "");
//                View view = view_find.findViewById(R.id.fragmelayout_find);
//                final Snackbar snackbar = Snackbar.make(view, "Không Có Kết Nối Internet.", Snackbar.LENGTH_INDEFINITE);
//
//                // Set an action on it, and a handler
//                snackbar.setAction("Thử Lại", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        initDisplay("");
//
//                    }
//                });
//
//                snackbar.show();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("select", "9");
                hashMap.put("id_temp", id_temp);
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
