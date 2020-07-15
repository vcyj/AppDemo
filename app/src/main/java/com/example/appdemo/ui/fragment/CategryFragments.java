package com.example.appdemo.ui.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appdemo.databinding.FragmentCategryBinding;

public class CategryFragments extends androidx.fragment.app.Fragment {
    private FragmentCategryBinding categryBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        categryBinding=FragmentCategryBinding.inflate(inflater,container,false);
        View view=categryBinding.getRoot();
        Typeface iconfont=Typeface.createFromAsset(getActivity().getAssets(),"iconfont.ttf");

        categryBinding.textIconMessage.setTypeface(iconfont);
        return view;
    }

}
