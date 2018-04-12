package com.example.a.projectapptenno;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    TextView txt_buaan_details;
    TextView txt_motamonan_details;
    TextView txt_nguyenlieu_details;
    TextView txt_motacachlam_details;
    TextView txt_motacacbuoclam_details;
    Toolbar toolbar;
    private String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/crud.php";
    private ProgressDialog mProgressDialog;
    String id_food = "";
    ArrayList<Fragment_Setter_Getter> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initControl();
        initData();
        initEvent();
        initDisplay();
    }

    private void initEvent() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_statusbar_color));
    }

    private void initData() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Food", MODE_PRIVATE);
        id_food = sharedPreferences.getString("id_food", null);
        collapsingToolbarLayout.setTitleEnabled(true);
        collapsingToolbarLayout.setTitle("");
        txt_buaan_details.setText("");
        txt_motamonan_details.setText("");
        txt_nguyenlieu_details.setText("");
        txt_motacacbuoclam_details.setText("");
        txt_motacachlam_details.setText("");
//        setSupportActionBar(toolbar);
//        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
//        collapsingToolbarLayout.setTitle(getResources().getString(R.string.txt_diemtam));
//        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.AppTheme);
//        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
//        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.black));
    }

    private void initControl() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        txt_buaan_details = (TextView) findViewById(R.id.txt_buaan_details);
        txt_motamonan_details = (TextView) findViewById(R.id.txt_motamonan_details);
        txt_nguyenlieu_details = (TextView) findViewById(R.id.txt_nguyenlieu_details);
        txt_motacachlam_details = (TextView) findViewById(R.id.txt_motacachlam_details);
        txt_motacacbuoclam_details = (TextView) findViewById(R.id.txt_motacacbuoclam_details);
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
                            String MEAL = "";
                            String INTRO = "";
                            String MATERIAL = "";
                            String PREPARE = "";
                            String GUIDE = "";
                            for (int i = 0; i < array.length(); i++) {
                                object = array.getJSONObject(i);
                                if (object.getString("ID").equals(id_food)) {
                                    TITLE = object.getString("TITLE");
                                    MEAL = object.getString("MEAL");
                                    INTRO = object.getString("INTRO");
                                    MATERIAL = object.getString("MATERIAL");
                                    PREPARE = object.getString("PREPARE");
                                    GUIDE = object.getString("GUIDE");
                                    collapsingToolbarLayout.setTitleEnabled(true);
                                    collapsingToolbarLayout.setTitle(TITLE);
                                    txt_buaan_details.setText(MEAL);
                                    txt_motamonan_details.setText(INTRO);
                                    txt_nguyenlieu_details.setText(MATERIAL);
                                    txt_motacacbuoclam_details.setText(GUIDE);
                                    txt_motacachlam_details.setText(PREPARE);

                                }


                            }
                            Log.d("JS0NArrayyyy", array.length() + "");

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
                hashMap.put("select", "2");
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getApplicationContext());
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
