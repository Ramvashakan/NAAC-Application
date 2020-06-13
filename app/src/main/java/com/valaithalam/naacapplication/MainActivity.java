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
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout1;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_draw_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout1 = findViewById(R.id.drawer_layout1);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout1, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout1.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                Intent i;

                switch (id){

                    case R.id.about :
                        i =new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(i);
                        break;

                    case R.id.history :
                        i =new Intent(MainActivity.this, MainActivity.class);
                        startActivity(i);
                        break;

                    case R.id.assessment :
                        i =new Intent(MainActivity.this, AssesmentActivity.class);
                        startActivity(i);
                        break;

                    case R.id.online:
                        i= new Intent(MainActivity.this,ApplyonlineActivity.class);
                        startActivity(i);
                        break;
                }
                menuItem.setChecked(true);
                drawerLayout1.closeDrawers();
                return false;

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout1.isDrawerOpen(GravityCompat.START)){

            drawerLayout1.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }


}
