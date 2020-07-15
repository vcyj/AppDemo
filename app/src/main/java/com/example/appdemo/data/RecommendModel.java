package com.example.appdemo.data;

import android.util.Log;

import com.example.appdemo.bean.DemoInfo;
import com.example.appdemo.http.ApiService;
import com.example.appdemo.http.HttpManger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendModel {

    public void getDemo(Callback<DemoInfo>callback){
        HttpManger manager=new HttpManger();
        ApiService apiService=manager.getRetrofit(manager.getOKHTTPClient()).create(ApiService.class);
        apiService.getDemo().enqueue(callback);

    }

}
