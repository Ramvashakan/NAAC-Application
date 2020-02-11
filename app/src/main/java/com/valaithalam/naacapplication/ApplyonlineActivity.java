package com.valaithalam.naacapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.android.material.navigation.NavigationView;

public class ApplyonlineActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyonline);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout3);
        navigationView = findViewById(R.id.nav_draw_online);

        WebView myWebView =  findViewById(R.id.applyonline);

        myWebView.loadUrl("http://www.naac.gov.in/apply-now");

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                Intent i;

                switch (id){

                    case R.id.about :
                        i =new Intent(ApplyonlineActivity.this, AboutActivity.class);
                        startActivity(i);
                        break;

                    case R.id.history :
                        i =new Intent(ApplyonlineActivity.this, MainActivity.class);
                        startActivity(i);
                        break;

                    case R.id.assessment :
                        i =new Intent(ApplyonlineActivity.this, AssesmentActivity.class);
                        startActivity(i);
                        break;

                    case R.id.online :
                        i =new Intent(ApplyonlineActivity.this, ApplyonlineActivity.class);
                        startActivity(i);
                        break;

                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return false;

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }
}
