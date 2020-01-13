package com.nicootech.fragment7navigationdrawerwithfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar
                ,R.string.navigation_drawer_open
                ,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //3//
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentWelcom()).commit();

            //navigationView.setCheckedItem(R.id.nav_message);
        }
        //3//

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //3//
        switch (menuItem.getItemId()){
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentMessage()).commit();
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentChat()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentProfile()).commit();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        //3//
        return true;
    }
}
