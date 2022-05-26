package com.example.quanlynhatro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quanlynhatro.UI.FragmentHome;
import com.example.quanlynhatro.UI.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
   FragmentHome fragmentHome;
   FragmentProfile fragmentProfile;
   FragmentManager fragmentManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        fragmentHome = new FragmentHome();
        fragmentProfile = new FragmentProfile();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frag_container,fragmentHome).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.trangchu:
                       fragmentManager.beginTransaction().replace(R.id.frag_container,fragmentHome).commit();
                       break;
                   case R.id.profile:
                       fragmentManager.beginTransaction().replace(R.id.frag_container,fragmentProfile).commit();
                       break;
                   default:
                       fragmentManager.beginTransaction().replace(R.id.frag_container,fragmentHome).commit();
               }
                return true;
            }
        });
    }

}