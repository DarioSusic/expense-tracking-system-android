package com.example.ets;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private TextView mTextMessage;
    private ViewPager mViewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_transaction:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_overview:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_add:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_budget:
                    mViewPager.setCurrentItem(3);
                    return true;
                case R.id.navigation_settings:
                    mViewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mViewPager = findViewById(R.id.fragmentContainer);
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TransactionFragment());
        adapter.addFragment(new OverviewFragment());
        adapter.addFragment(new AddNewItemFragment());
        adapter.addFragment(new BudgetFragment());
        adapter.addFragment(new SettingsFragment());

        viewPager.setAdapter(adapter);
    }
}
