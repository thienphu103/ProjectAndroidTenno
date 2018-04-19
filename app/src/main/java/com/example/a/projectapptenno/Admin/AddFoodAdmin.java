package com.example.a.projectapptenno.Admin;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a.projectapptenno.Adapter.Add_Admin;
import com.example.a.projectapptenno.DetailActivity;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Favorite_Food_Setter_Getter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddFoodAdmin extends AppCompatActivity {
    ArrayList<String> arrayListString;
    ArrayList<Favorite_Food_Setter_Getter> arrayList;
    ListView listView;
    View.OnClickListener click;
    Add_Admin adapter;
    Button btn_add;
    private String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/crud.php";
    View.OnClickListener click2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_admin);
        initControl();
        initData();
        initEvent();
        initDisplay();
    }

    private void initControl() {
        listView = (ListView) findViewById(R.id.lst_addadmin);
        btn_add = (Button) findViewById(R.id.btn_add);
    }

    private void initData() {
//        arrayList = new ArrayList<>();
//        arrayList.add(new Favorite_Food_Setter_Getter(getResources().getString(R.string.txt_diemtam),
//                "Bánh mì thịt"));
//        adapter = new Add_Admin(arrayList,AddFoodAdmin.this);
//        listView.setAdapter(adapter);
//
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Update", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(AddFoodAdmin.this, Add.class);
                startActivity(intent);

            }
        });
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer integer = (Integer) v.getTag();
                showQuestionDelete(integer);
            }
        };
        click2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer integer = (Integer) v.getTag();
                SharedPreferences sharedPreferences = getSharedPreferences("Update", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("id_update",arrayList.get(integer).getTxt_id()+"");
                editor.commit();
                Intent intent = new Intent(getApplication(), Add.class);
                startActivity(intent);
            }
        };
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
                            String IMAGE;
                            for (int i = 0; i < array.length(); i++) {
                                object = array.getJSONObject(i);
                                ID = object.getString("ID");
                                MEAL = object.getString("MEAL");
                                TITLE = object.getString("TITLE");
                                IMAGE = object.getString("IMAGE");
                                arrayList.add(new Favorite_Food_Setter_Getter(IMAGE, MEAL, TITLE, ID));
                                Log.d("JS0Ndata", TITLE + "");
                            }
                            Log.d("JS0NArrayyyy", array.length() + "");
                            adapter = new Add_Admin(arrayList, getApplicationContext(), click, click2);
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

    private void initDelete(final String id_food) {
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
                        } catch (Exception e) {
                            e.printStackTrace();
//                            Toast.makeText(getApplicationContext(), "Exception " + e, Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

//                Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_SHORT).show();
                Log.d("error", error + "");

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("select", "8");
                hashMap.put("id", id_food);
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void showQuestionDelete(final int integer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("App");
        builder.setMessage("Bạn có muốn xóa món ăn: " + arrayList.get(integer).getTxt_id().toString() + " ra khỏi danh sách yêu thích không");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {

                    initDelete(arrayList.get(integer).getTxt_id().toString());
                    adapter.notifyDataSetChanged();
                    Intent intent = getIntent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void initEvent() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_statusbar_color));
    }
}
