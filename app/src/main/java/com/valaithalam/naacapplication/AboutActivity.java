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

import com.google.android.material.navigation.NavigationView;

public class AboutActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_draw_abt);
        drawerLayout = findViewById(R.id.drawer_layout2);

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
                        i =new Intent(AboutActivity.this, AboutActivity.class);
                        startActivity(i);
                        break;

                    case R.id.history :
                        i =new Intent(AboutActivity.this, MainActivity.class);
                        startActivity(i);
                        break;

                    case R.id.assessment :
                        i =new Intent(AboutActivity.this, AssesmentActivity.class);
                        startActivity(i);
                        break;

                    case R.id.online :
                        i =new Intent(AboutActivity.this, ApplyonlineActivity.class);
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
