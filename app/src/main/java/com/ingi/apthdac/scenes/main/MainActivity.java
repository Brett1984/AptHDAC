package com.ingi.apthdac.scenes.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.ingi.apthdac.R;
import com.ingi.apthdac.common.BaseActivity;
import com.ingi.apthdac.scenes.trading.TradingActivity;

import java.util.ArrayList;

import im.dacer.androidcharts.LineView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView, View.OnClickListener{
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.attachView(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setTitle("Min's Home");

        Button tradingButton = (Button)findViewById(R.id.tradingButton);
        tradingButton.setOnClickListener(this);

        initTabView();
        initGraphView();
    }

    private void initGraphView() {
        ArrayList<String> strList = new ArrayList<>();
        for(int i = 1; i <= 31; i++) {
            strList.add(String.format("06-%02d", i));
        }

        ArrayList<ArrayList<Float>> dataLists = new ArrayList();
        ArrayList<Float> miningData = new ArrayList();
        for(int i=0; i < 31; i++) {
            miningData.add(new Float(Math.random() + 1));
        }
        dataLists.add(miningData);

        LineView lineView = (LineView)findViewById(R.id.line_view);
        lineView.setDrawDotLine(false);
        lineView.setShowPopup(LineView.SHOW_POPUPS_MAXMIN_ONLY); //optional
        lineView.setBottomTextList(strList);
        lineView.setColorArray(new int[]{Color.BLACK,Color.GREEN,Color.GRAY,Color.CYAN});
        lineView.setFloatDataList(dataLists);
    }


    private void initTabView() {
        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab spec 1");
        tabSpec1.setContent(R.id.content1);
        tabSpec1.setIndicator("내지갑");
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab spec 2");
        tabSpec2.setContent(R.id.content2);
        tabSpec2.setIndicator("에너지 사용현황");
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab spec 3");
        tabSpec3.setContent(R.id.content3);
        tabSpec3.setIndicator("환경 데이터현황");
        tabHost.addTab(tabSpec3);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.myInfomation:
                break;

            case R.id.myWallet:
                break;

            case R.id.miningStatus:
                break;

            case R.id.spentResourceStatus:
                break;

            case R.id.homeStatus:
                break;

            case R.id.otherApartmentStatus:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClickTrading() {
        startActivity(new Intent(this, TradingActivity.class));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.tradingButton)
            onClickTrading();
    }
}
