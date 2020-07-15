package com.example.appdemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.appdemo.R;
import com.example.appdemo.bean.DemoInfo;
import com.example.appdemo.databinding.RecommendWeatherBinding;

import java.util.ArrayList;
import java.util.List;

public class RecommendAppAdapter extends RecyclerView.Adapter<RecommendAppAdapter.ViewHolder> {


    private DemoInfo demoInfo;
    private LayoutInflater mLayoutInflater;
    private List dd = new ArrayList();

    public RecommendAppAdapter(Context context, DemoInfo demoInfos) {
        this.demoInfo = demoInfos;
        dd = demoInfo.getData().getForecast();


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecommendWeatherBinding bind=RecommendWeatherBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        ViewHolder holder=new ViewHolder(bind);
        return holder;

    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_ymd.setText(demoInfo.getData().getForecast().get(position).getYmd());

        holder.tv_low.setText(demoInfo.getData().getForecast().get(position).getLow());
        holder.tv_high.setText(demoInfo.getData().getForecast().get(position).getHigh());
        holder.tv_fl.setText(demoInfo.getData().getForecast().get(position).getFl());
        holder.tv_fx.setText(demoInfo.getData().getForecast().get(position).getFx());
    }


    @Override
    public int getItemCount() {
        return dd.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_fl,tv_ymd,tv_fx,tv_high,tv_low;

        public ViewHolder(@NonNull RecommendWeatherBinding recommendWeatherBinding) {
            super(recommendWeatherBinding.getRoot());
            tv_fl=recommendWeatherBinding.fl;
            tv_fx=recommendWeatherBinding.fx;
            tv_high=recommendWeatherBinding.high;
            tv_low=recommendWeatherBinding.low;
            tv_ymd=recommendWeatherBinding.ymd;

        }

    }

}