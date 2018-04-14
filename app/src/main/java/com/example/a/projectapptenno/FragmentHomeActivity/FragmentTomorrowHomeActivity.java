package com.example.a.projectapptenno.FragmentHomeActivity;


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
import com.example.a.projectapptenno.Adapter.Fragment_Tomorrow;
import com.example.a.projectapptenno.DetailActivity;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/crud.php";
    private ProgressDialog mProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TomorrowFragment = inflater.inflate(R.layout.fragment_tomorrow_home, container, false);
        initControl();
        initData();
        initEvent();
        initDisplay();
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
//        adapter = new Fragment_Tomorrow(arrayList,getActivity());
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent Tomorrow2_Detai = new Intent(getActivity(), DetailActivity.class);
//                startActivity(Tomorrow2_Detai);
//            }
//        });

    }
    private void initDisplay() {
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
                            Log.d("JS0NArrayyyy", array.length() + "");
                            adapter = new com.example.a.projectapptenno.Adapter.Fragment_Tomorrow(arrayList, getActivity());
                            if (arrayList.size() > 0) {
                                listView.setAdapter(adapter);
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
                hashMap.put("select", "1");
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
