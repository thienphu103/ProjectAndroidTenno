package com.example.a.projectapptenno.Admin;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.a.projectapptenno.Adapter.Acount_Admin;
import com.example.a.projectapptenno.Adapter.Add_Admin;
import com.example.a.projectapptenno.Adapter.Favorite_Food;
import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Favorite_Food_Setter_Getter;

import java.util.ArrayList;

public class Account_Admin extends AppCompatActivity {
    ArrayList<Favorite_Food_Setter_Getter> arrayList;
    ListView listView;
    Acount_Admin adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__admin);
        initControl();
        initData();
        initEvent();
    }

    private void initControl() {
        listView = (ListView) findViewById(R.id.lst_acount);
    }

    private void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new Favorite_Food_Setter_Getter("Dòng 1","Dòng 2","Dòng 3"));
        arrayList.add(new Favorite_Food_Setter_Getter("Dòng 1","Dòng 2","Dòng 3"));
        arrayList.add(new Favorite_Food_Setter_Getter("Dòng 1","Dòng 2","Dòng 3"));
        adapter = new Acount_Admin(arrayList,Account_Admin.this);
        listView.setAdapter(adapter);
    }

    private void initEvent() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_statusbar_color));
    }
}
