package com.samx08.animx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.samx08.animx.adapters.ViewPageAdapter;
import com.samx08.animx.navigation_fragment.Sample1;
import com.samx08.animx.navigation_fragment.Sample2;
import com.samx08.animx.navigation_fragment.Sample3;
import com.samx08.animx.navigation_fragment.Sample4;

public class DashBoard extends AppCompatActivity {


    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolBar;
    ActionBarDrawerToggle toggle;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView=findViewById(R.id.navigation);
        drawerLayout=findViewById(R.id.drawer);
        toolBar=findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolBar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.getMenu().performIdentifierAction(R.id.search,0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();
                Fragment fragment=null;
                switch (id)
                {
                    case R.id.search:
                        loadFragment(new dataFragment());
                        break;
                    case R.id.basket:
                        fragment=new Sample1();
                        loadFragment(fragment);
                        break;
                    case R.id.favorite:
                        fragment=new Sample2();
                        loadFragment(fragment);
                        break;
                    case R.id.promo_code:
                        fragment=new Sample3();
                        loadFragment(fragment);
                        break;
                    case R.id.orders:
                        fragment=new Sample4();
                        loadFragment(fragment);
                        break;
                    case R.id.setting:
                        fragment=new Sample5();
                        loadFragment(fragment);
                        break;
                    case R.id.support:
                        fragment=new Sample6();
                        loadFragment(fragment);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });




    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }
}