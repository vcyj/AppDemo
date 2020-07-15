package com.example.appdemo.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appdemo.R;
import com.example.appdemo.ui.adapter.Viewpageadapter;
import com.example.appdemo.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewbinding;

    private View headview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdrawerlayout();
        initTablayout();


    }


    private void initTablayout() {
        PagerAdapter adapter=new Viewpageadapter(getSupportFragmentManager());
        viewbinding.viewPage.setAdapter(adapter);

        viewbinding.tabLayout.setupWithViewPager(viewbinding.viewPage);
    }

    public void initdrawerlayout(){
        viewbinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=viewbinding.getRoot();
        setContentView(view);

        headview=viewbinding.navigationView.getHeaderView(0);
        headview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"header view be clicked",Toast.LENGTH_SHORT).show();
            }
        });
        viewbinding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_appupdate:
                        Toast.makeText(MainActivity.this,"应用更新被点击了",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_message:
                        Toast.makeText(MainActivity.this,"点击了消息处理界面",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_setting:
                        Toast.makeText(MainActivity.this,"点击了设置界面",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }

        });
        viewbinding.toolBar.inflateMenu(R.menu.menu_tool_bar);

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,viewbinding.drawerlayout,viewbinding.toolBar,R.string.open,R.string.close);
        drawerToggle.syncState();
        viewbinding.drawerlayout.addDrawerListener(drawerToggle);
    }
}