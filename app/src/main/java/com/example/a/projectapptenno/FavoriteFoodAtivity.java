package com.example.a.projectapptenno;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a.projectapptenno.Adapter.Favorite_Food;
import com.example.a.projectapptenno.Setter_Getter.Favorite_Food_Setter_Getter;

import java.util.ArrayList;

public class FavoriteFoodAtivity extends AppCompatActivity {
    ImageView img_backarrow;
    ArrayList<Favorite_Food_Setter_Getter> arrayList;
    ListView listView;
    Favorite_Food adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_food_ativity);
        initControl();
        initData();
        initEvent();
    }

    private void initControl() {
        img_backarrow = (ImageView) findViewById(R.id.img_backarrow);
        listView = (ListView) findViewById(R.id.lst_favoritefood);
    }

    private void initData() {
        img_backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Favorite_Home = new Intent(FavoriteFoodAtivity.this,HomeActivity.class);
                startActivity(Favorite_Home);
            }
        });
        arrayList = new ArrayList<>();
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        arrayList.add(new Favorite_Food_Setter_Getter(R.drawable.foodbanhmithit2,
                getResources().getString(R.string.txt_diemtam),
                "Bánh mì thịt"));
        adapter = new Favorite_Food(arrayList,FavoriteFoodAtivity.this);
        listView.setAdapter(adapter);
    }

    private void initEvent() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.my_statusbar_color));
    }
}
