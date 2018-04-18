package com.example.a.projectapptenno.Admin;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a.projectapptenno.Adapter.Add_Admin;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Favorite_Food_Setter_Getter;

import java.util.ArrayList;

public class AddFoodAdmin extends AppCompatActivity {
    ArrayList<String> arrayListString;
    ArrayList<Favorite_Food_Setter_Getter> arrayList;
    ListView listView;
    Add_Admin adapter;
    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_admin);
        initControl();
        initData();
        initEvent();
    }

    private void initControl() {
        listView = (ListView) findViewById(R.id.lst_addadmin);
        btn_add = (Button) findViewById(R.id.btn_add);
    }

    private void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new Favorite_Food_Setter_Getter(getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        adapter = new Add_Admin(arrayList,AddFoodAdmin.this);
        listView.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Add_Add = new Intent(AddFoodAdmin.this,Add.class);
                startActivity(Add_Add);
            }
        });
    }

    private void initEvent() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_statusbar_color));
    }
}
