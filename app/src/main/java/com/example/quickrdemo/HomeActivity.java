package com.example.quickrdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mAdRecyclerView;
    private AdPostAdapter mAdapter;
    private TextView mNoAdTv;
    private ImageView mNoAdImg;
    public static Bitmap mBitmapForAdImages[];
    public static String mProductTitleForAd[];
    public static String mProductPrice[];

    @Override
    protected void onResume() {
        super.onResume();
        if(mBitmapForAdImages[0] == null){
            mNoAdTv.setVisibility(View.VISIBLE);
            mNoAdImg.setVisibility(View.VISIBLE);
            mAdRecyclerView.setVisibility(View.GONE);
        }else{
            mNoAdTv.setVisibility(View.GONE);
            mNoAdImg.setVisibility(View.GONE);
            mAdRecyclerView.setVisibility(View.VISIBLE);
            mAdapter.setAdImageId(mBitmapForAdImages);
            mAdapter.setAdTitle(mProductTitleForAd);
            mAdapter.setAdPrice(mProductPrice);
            mAdRecyclerView.setAdapter(mAdapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mNoAdTv = findViewById(R.id.no_post_tv);
        mNoAdImg = findViewById(R.id.empty_img);

        mBitmapForAdImages = new Bitmap[3];
        mProductTitleForAd = new String[3];
        mProductPrice = new String[3];

        mAdRecyclerView = findViewById(R.id.ad_post_rv);
        mAdapter = new AdPostAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mAdRecyclerView.setLayoutManager(layoutManager);
        mAdRecyclerView.setHasFixedSize(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class destinationClass = AddPostActivity.class;
                Intent intentToStartDetailActivity = new Intent(HomeActivity.this, destinationClass);
                startActivity(intentToStartDetailActivity);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorite) {
            return true;
        }else if(id == R.id.action_cart){

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_payment) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
