package com.example.ubereatsclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNav = findViewById(R.id.nav_bar);
        mBottomNav.setOnNavigationItemSelectedListener(nav_listener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav_listener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.home1 :  selectFragment = new HomeFragment();
                            break;

                        case R.id.search :  selectFragment = new SearchFragment();
                            break;



                        case R.id.history :  selectFragment = new HistoryFragment();
                            break;

                        case R.id.profile :  selectFragment = new ProfileFragmnet();
                            break;
                        case R.id.offer :  selectFragment = new OfferFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectFragment).commit();
                    return true;
                }
            };


}
