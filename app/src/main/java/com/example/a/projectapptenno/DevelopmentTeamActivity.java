package com.example.a.projectapptenno;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class DevelopmentTeamActivity extends AppCompatActivity {
    ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development_team);
        initControl();
        initData();
        initEvent();
    }

    private void initControl() {
        img_back = (ImageView) findViewById(R.id.img_back_developmentteam);
    }

    private void initData() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DevelopmentTeam_Home = new Intent(DevelopmentTeamActivity.this,HomeActivity.class);
                startActivity(DevelopmentTeam_Home);
            }
        });
    }

    private void initEvent() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.my_statusbar_color));
    }
}
