package com.example.appdemo.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.appdemo.bean.FragmentInfo;
import com.example.appdemo.ui.fragment.CategryFragments;
import com.example.appdemo.ui.fragment.GamesFragment;
import com.example.appdemo.ui.fragment.HomeFragment;
import com.example.appdemo.ui.fragment.RecomendFragment;

import java.util.ArrayList;
import java.util.List;

public class Viewpageadapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo>mfragments=new ArrayList<>(2);

    public Viewpageadapter(@NonNull FragmentManager fm) {
        super(fm);
        initFragments();
    }
     private void initFragments(){
        mfragments.add(new FragmentInfo("游戏",GamesFragment.class));
        mfragments.add(new FragmentInfo("分类",CategryFragments.class));
        mfragments.add(new FragmentInfo("主页",HomeFragment.class));
        mfragments.add(new FragmentInfo("推荐",RecomendFragment.class));

     }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        try {
            return (Fragment) mfragments.get(position).getFragment().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
//        Fragment fragment=null;
//        switch (position){
//            case 0:
//                fragment=new GamesFragment();
//                break;
//            case 1:
//                fragment=new HomeFragment();
//                break;
//            case 2:
//                fragment=new CategryFragments();
//                break;
//            case 3:
//                fragment=new RecomendFragment();
//                break;
//        }
return null;
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mfragments.get(position).getTitle();
    }
}
