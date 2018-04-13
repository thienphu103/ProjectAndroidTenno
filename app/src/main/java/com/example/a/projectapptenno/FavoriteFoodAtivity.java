package com.example.a.projectapptenno;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a.projectapptenno.Adapter.Favorite_Food;
import com.example.a.projectapptenno.Setter_Getter.Favorite_Food_Setter_Getter;
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FavoriteFoodAtivity extends AppCompatActivity {
    ImageView img_backarrow;
    ArrayList<String> arrayListString;

    ArrayList<Favorite_Food_Setter_Getter> arrayList;
    ListView listView;
    Favorite_Food adapter;
    private String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/crud.php";
    private String id_guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_food_ativity);
        initControl();
        initData();
        initEvent();
        getData();
        initDisplay();
    }

    private void initControl() {
        img_backarrow = (ImageView) findViewById(R.id.img_backarrow);
        listView = (ListView) findViewById(R.id.lst_favoritefood);
    }

    private void initData() {
        img_backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Favorite_Home = new Intent(FavoriteFoodAtivity.this, HomeActivity.class);
                startActivity(Favorite_Home);
            }
        });
        arrayListString = new ArrayList<>();
//        arrayList = new ArrayList<>();
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
//                getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        adapter = new Favorite_Food(arrayList,FavoriteFoodAtivity.this);
//        listView.setAdapter(adapter);
    }

    private void initEvent() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_statusbar_color));
        SharedPreferences sharedPreferences2 = getApplicationContext().getSharedPreferences("User", MODE_PRIVATE);
        id_guest = sharedPreferences2.getString("id_guest", null);
    }


    private void getData() {
        Toast.makeText(getApplicationContext(), "loading database ", Toast.LENGTH_SHORT).show();
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray array = new JSONArray(response);
                            JSONObject object = null;
                            String ID_GUEST = "";
                            String ID_FOOD;
                            String ID;
                            for (int i = 0; i < array.length(); i++) {
                                object = array.getJSONObject(i);
                                ID_FOOD = object.getString("ID_FOOD");
                                arrayListString.add(ID_FOOD);
                                Log.d("JS0Ndata", ID_FOOD + "");
                            }
                            Log.d("JS0NArrayyyyFood", array.length() + "");

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Exception " + e, Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_SHORT).show();
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
                hashMap.put("id_guest", id_guest);
                hashMap.put("select", "4");
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void initDisplay() {
        Toast.makeText(getApplicationContext(), "loading database ", Toast.LENGTH_SHORT).show();
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
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
                            String ID_FOOD = null;
                                for (int i = 0; i < array.length(); i++) {
                                    object = array.getJSONObject(i);
                                    if (object.getString("ID").equals(ID_FOOD)) {
                                        ID = object.getString("ID");
                                        MEAL = object.getString("MEAL");
                                        TITLE = object.getString("TITLE");
                                        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2, MEAL, TITLE, ID));
                                    }
                                    Log.d("JS0Ndata", TITLE + "");
                                }
                            Log.d("JS0NArrayyyy", array.length() + "");
                            adapter = new Favorite_Food(arrayList, FavoriteFoodAtivity.this);
                            if (arrayList.size() > 0) {
                                listView.setAdapter(adapter);
                            }
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Toast.makeText(getApplicationContext(), "ID: " + arrayList.get(position).getTxt_id() + ", Name: " + arrayList.get(position).getTxt_monan(), Toast.LENGTH_SHORT).show();
                                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Food", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("id_food", arrayList.get(position).getTxt_id() + "");
                                    editor.commit();
                                    Intent Today_Detai = new Intent(getApplicationContext(), DetailActivity.class);
                                    startActivity(Today_Detai);
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Exception " + e, Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_SHORT).show();
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
}
