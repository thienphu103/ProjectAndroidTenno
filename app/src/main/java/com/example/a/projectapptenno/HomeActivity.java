package com.example.a.projectapptenno;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.projectapptenno.Adapter.HomeTablayoutAdapter;
import com.example.a.projectapptenno.FragmentHomeActivity.FragmentTodayHomeActivity;
import com.example.a.projectapptenno.FragmentHomeActivity.FragmentTomorrow2HomeActivity;
import com.example.a.projectapptenno.FragmentHomeActivity.FragmentTomorrowHomeActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView img_user;
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawer;
    public ViewPager mViewPager;
    public TabLayout mTablayout;
    ArrayList listFragment;
    ArrayList<String> listTitle;
    HomeTablayoutAdapter adapter;
    TextView Today, Tomorrow, Tommorrow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initControl();
        initData();
        initEvent();
        createTabIcons();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void createTabIcons() {
        Today = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        Today.setText(getResources().getString(R.string.txt_today));
        Today.setTextColor(getResources().getColor(R.color.color_text));
        mTablayout.getTabAt(0).setCustomView(Today);
        // icon Hôm nay
        Tomorrow = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        Tomorrow.setText(getResources().getString(R.string.txt_tomorrow));
        Tomorrow.setTextColor(getResources().getColor(R.color.color_text_click));
        mTablayout.getTabAt(1).setCustomView(Tomorrow);
        // icon Ngày mai
        Tommorrow2 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        Tommorrow2.setText(getResources().getString(R.string.txt_ngaykia));
        Tommorrow2.setTextColor(getResources().getColor(R.color.color_text_click));
        mTablayout.getTabAt(2).setCustomView(Tommorrow2);
        // icon ngày kia
    }
    private void initControl() {
        img_user = (ImageView) findViewById(R.id.img_user_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        mTablayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_content);
        mTablayout.setupWithViewPager(mViewPager);
    }

    private void initData() {
        img_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(navigationView)) {
                    drawer.closeDrawer(navigationView);
                } else if (!drawer.isDrawerOpen(navigationView)) {
                    drawer.openDrawer(navigationView);
                }
            }
        });
        listFragment = new ArrayList();
        listFragment.add(new FragmentTodayHomeActivity());
        listFragment.add(new FragmentTomorrowHomeActivity());
        listFragment.add(new FragmentTomorrow2HomeActivity());
        listTitle = new ArrayList<>();
        listTitle.add(getResources().getString(R.string.txt_today));
        listTitle.add(getResources().getString(R.string.txt_tomorrow));
        listTitle.add(getResources().getString(R.string.txt_ngaykia));
        adapter = new HomeTablayoutAdapter(getSupportFragmentManager(),
                HomeActivity.this,
                listTitle, listFragment);
        mViewPager.setAdapter(adapter);
    }

    private void initEvent() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_statusbar_color));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        Today.setText(getResources().getString(R.string.txt_today));
                        Today.setTextColor(getResources().getColor(R.color.color_text));
                        mTablayout.getTabAt(0).setCustomView(Today);
                        // icon Hôm nay
                        Tomorrow.setText(getResources().getString(R.string.txt_tomorrow));
                        Tomorrow.setTextColor(getResources().getColor(R.color.color_text_click));
                        mTablayout.getTabAt(1).setCustomView(Tomorrow);
                        // icon Ngày mai
                        Tommorrow2.setText(getResources().getString(R.string.txt_ngaykia));
                        Tommorrow2.setTextColor(getResources().getColor(R.color.color_text_click));
                        mTablayout.getTabAt(2).setCustomView(Tommorrow2);
                        // icon ngày kia
                        break;
                    case 1:
                        Today.setText(getResources().getString(R.string.txt_today));
                        Today.setTextColor(getResources().getColor(R.color.color_text_click));
                        mTablayout.getTabAt(0).setCustomView(Today);
                        // icon Hôm nay
                        Tomorrow.setText(getResources().getString(R.string.txt_tomorrow));
                        Tomorrow.setTextColor(getResources().getColor(R.color.color_text));
                        mTablayout.getTabAt(1).setCustomView(Tomorrow);
                        // icon Ngày mai
                        Tommorrow2.setText(getResources().getString(R.string.txt_ngaykia));
                        Tommorrow2.setTextColor(getResources().getColor(R.color.color_text_click));
                        mTablayout.getTabAt(2).setCustomView(Tommorrow2);
                        // icon ngày kia
                        break;
                    case 2:
                        Today.setText(getResources().getString(R.string.txt_today));
                        Today.setTextColor(getResources().getColor(R.color.color_text_click));
                        mTablayout.getTabAt(0).setCustomView(Today);
                        // icon Hôm nay
                        Tomorrow.setText(getResources().getString(R.string.txt_tomorrow));
                        Tomorrow.setTextColor(getResources().getColor(R.color.color_text_click));
                        mTablayout.getTabAt(1).setCustomView(Tomorrow);
                        // icon Ngày mai
                        Tommorrow2.setText(getResources().getString(R.string.txt_ngaykia));
                        Tommorrow2.setTextColor(getResources().getColor(R.color.color_text));
                        mTablayout.getTabAt(2).setCustomView(Tommorrow2);
                        // icon ngày kia
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent Home_FavoriteFood = new Intent(HomeActivity.this, FavoriteFoodAtivity.class);
            startActivity(Home_FavoriteFood);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent Home_Changethepassword = new Intent(HomeActivity.this, ChangethepasswordActivity.class);
            startActivity(Home_Changethepassword);

        } else if (id == R.id.nav_slideshow) {
            Intent Home_DevelopmentTeam = new Intent(HomeActivity.this, DevelopmentTeamActivity.class);
            startActivity(Home_DevelopmentTeam);
        } else if (id == R.id.nav_manage) {
            Intent Home_Login = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(Home_Login);

        }


        return true;
    }
}
